package Tests;

import Pages.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

public class LogIn extends BaseTest {

    private LoginPage login;

    @Test
    public void LoginPage() {
        login = home.goToLoginPage();
        login.inputLogin("admin");
        login.inputPassword("admin");
        login.clickShowHidePasswordButton();
        login.clickLoginButton();
        Assertions.assertTrue(home.isThereInfoAboutWrongLoginOrPassword(), "Invalid email or password.");
        // TODO: 14.01.2024 Sprawdzić czy  invalid message or password" się nie powtarza w innym Pagu i przenieść do Login Page
        // TODO: 14.01.2024 Użyć metodę do

    }

    @Test
    public void unsuccessfulLogInBecauseThereIsNoPassword() {
        login = home.goToLoginPage();
        login.inputPassword("");
        login.inputLogin("admin");
        Assertions.assertTrue(login.isProvidePasswordMessageVisible(), "Please provide a password");
    }

    @Test
    public void logInToThePageByCredentials() {
        login = home.goToLoginPage();
        Assertions.assertEquals(login.urlLogin, driver.getCurrentUrl(), "The page is not login page");
        String myLogin = service.getCredentialValue("myLogin");
        String myPassword = service.getCredentialValue("myPassword");
        login.insertMyLogin(myLogin);
        login.insertMyPassword(myPassword);
        home = login.clickLoginButton();
        Assertions.assertTrue(home.isAddToCartButtonVisible(), "You are not logged into account!");
    }

    @Test
    public void dismissCookieMessage() {
        login = home.goToLoginPage();
        Assertions.assertEquals(login.urlLogin, driver.getCurrentUrl(), "The page is not login page");
        String myLogin = service.getCredentialValue("myLogin");
        String myPassword = service.getCredentialValue("myPassword");
        login.insertMyLogin(myLogin);
        login.insertMyPassword(myPassword);
        home = login.clickLoginButton();
        Assertions.assertTrue(home.isAddToCartButtonVisible());
        home.clickAcceptCookieButton();
        Assertions.assertFalse(home.isCookieAcceptButtonVisible(), "Cookie message is still visible");
    }

    @Test
    public void logOutFromAccount() {
        login = home.goToLoginPage();
        Assertions.assertEquals(login.urlLogin, driver.getCurrentUrl(), "The page is not login page");
        String myLogin = service.getCredentialValue("myLogin");
        String myPassword = service.getCredentialValue("myPassword");
        login.insertMyLogin(myLogin);
        login.insertMyPassword(myPassword);
        home = login.clickLoginButton();
        Assertions.assertTrue(home.isAddToCartButtonVisible());
        home.clickAccountIcon();
        home.clickLogOutButton();
        home.clickAccountIcon();
        Assertions.assertTrue(home.isLogInButtonVisible(), "You are still logged! Logout.");
    }
    @Test
    public void logInByRememberMeCheckbox() {
        login = home.goToLoginPage();
        Assertions.assertEquals(login.urlLogin, driver.getCurrentUrl(), "The page is not login page");
        login.rememberMeCheckboxCheck();
        String myLogin = service.getCredentialValue("myLogin");
        String myPassword = service.getCredentialValue("myPassword");
        login.insertMyLogin(myLogin);
        login.insertMyPassword(myPassword);
        home = login.clickLoginButton();
        Assertions.assertTrue(home.isAddToCartButtonVisible());
        home.clickAccountIcon();
        home.clickLogOutButton();
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
        login.insertMyLogin(myLogin);
        login.insertMyPassword(myPassword);
        home = login.clickLoginButton();
        home.clickLanguageSelectionMenuButton();
        home.selectLanguage("Dansk");
        Assertions.assertFalse(login.isLanguageChanged(), "You haven't changed language");
    }
}
