package Tests;

import Pages.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

public class LogIn extends BaseTest {

    private LoginPage login;

    @Test
    public void LoginPage() {
        login = home.goToLoginPage();
        login.fillLoginField("admin");
        login.fillPasswordField("admin");
        login.showHidePasswordButtonClick();
        login.loginButtonClick();
        Assertions.assertTrue(login.isInvalidEmailOrPasswordMessageVisible(), "Invalid email or password.");
        // TODO: 14.01.2024 Sprawdzić czy  invalid message or password" się nie powtarza w innym Pagu i przenieść do Login Page
        // TODO: 14.01.2024 Użyć metodę do

    }

    @Test
    public void unsuccessfulLogInBecauseThereIsNoPassword() {
        login = home.goToLoginPage();
        login.fillPasswordField("");
        login.fillLoginField("admin");
        Assertions.assertTrue(login.isProvidePasswordMessageVisible(), "Please provide a password");
    }

    @Test
    public void logInToThePageByCredentials() {
        login = home.goToLoginPage();
        Assertions.assertEquals(login.urlLogin, driver.getCurrentUrl(), "The page is not login page");
        String myLogin = service.getCredentialValue("myLogin");
        String myPassword = service.getCredentialValue("myPassword");
        login.fillMyLoginField(myLogin);
        login.fillMyPasswordField(myPassword);
        home = login.loginButtonClick();
        Assertions.assertTrue(home.isAddToCartButtonVisible(), "You are not logged into account!");
    }

    @Test
    public void dismissCookieMessage() {
        login = home.goToLoginPage();
        Assertions.assertEquals(login.urlLogin, driver.getCurrentUrl(), "The page is not login page");
        String myLogin = service.getCredentialValue("myLogin");
        String myPassword = service.getCredentialValue("myPassword");
        login.fillMyLoginField(myLogin);
        login.fillMyPasswordField(myPassword);
        home = login.loginButtonClick();
        Assertions.assertTrue(home.isAddToCartButtonVisible());
        home.acceptCookieButtonClick();
        Assertions.assertFalse(home.isCookieAcceptButtonVisible(), "Cookie message is still visible");
    }

    @Test
    public void logOutFromAccount() {
        login = home.goToLoginPage();
        Assertions.assertEquals(login.urlLogin, driver.getCurrentUrl(), "The page is not login page");
        String myLogin = service.getCredentialValue("myLogin");
        String myPassword = service.getCredentialValue("myPassword");
        login.fillMyLoginField(myLogin);
        login.fillMyPasswordField(myPassword);
        home = login.loginButtonClick();
        Assertions.assertTrue(home.isAddToCartButtonVisible());
        home.accountIconClick();
        home.logOutButtonClick();
        home.accountIconClick();
        Assertions.assertTrue(home.isLogInButtonVisible(), "You are still logged! Logout.");
    }
    @Test
    public void logInByRememberMeCheckbox() {
        login = home.goToLoginPage();
        Assertions.assertEquals(login.urlLogin, driver.getCurrentUrl(), "The page is not login page");
        login.rememberMeCheckboxCheck();
        String myLogin = service.getCredentialValue("myLogin");
        String myPassword = service.getCredentialValue("myPassword");
        login.fillMyLoginField(myLogin);
        login.fillMyPasswordField(myPassword);
        home = login.loginButtonClick();
        Assertions.assertTrue(home.isAddToCartButtonVisible());
        home.accountIconClick();
        home.logOutButtonClick();
        login = home.goToLoginPage();
        Assertions.assertTrue(login.isTheRememberMeCheckoxChecked(), "You are not logged! Try to login again");
    }
    @Test
    public void changeLanguage() {
        login = home.goToLoginPage();
        Assertions.assertEquals(login.urlLogin, driver.getCurrentUrl(), "The page is not login page");
        login.rememberMeCheckboxCheck();
        String myLogin = service.getCredentialValue("myLogin");
        String myPassword = service.getCredentialValue("myPassword");
        login.fillMyLoginField(myLogin);
        login.fillMyPasswordField(myPassword);
        home = login.loginButtonClick();
        home.languageSelectionMenuButtonClick();
        home.selectLanguage("Dansk");
        Assertions.assertFalse(home.isLanguageChanged(), "You haven't changed language");
    }
}
