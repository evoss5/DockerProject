package Tests;

import Pages.AfterLoginPage;
import Pages.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

public class LogIn extends BaseTest {

    private LoginPage login;
    private AfterLoginPage page;

    @Test
    public void LoginPage() {
        login = new LoginPage(driver);
        home.clickAccountIcon();
        home.clickLoginHomePage();
        login.inputLogin("admin");
        login.inputPassword("admin");
        login.checkPassword();
        login.goToHomePage();
        Assertions.assertTrue(home.isThereInfoAboutWrongLoginOrPassword(), "Invalid email or password.");
        // TODO: 30.12.2023 pozmieniać treści messagów
    }

    @Test
    public void unsuccessfulLogInBecauseThereIsNoPassword() {
        login = new LoginPage(driver);
        home.clickAccountIcon();
        home.clickLoginHomePage();
        login.inputLogin("admin");
        login.passwordFieldClick();
        login.logInButtonClick();
        Assertions.assertTrue(login.isThereNoPasswordInsert(), "Please provide a password");
    }

    @Test
    public void logInToThePageByCredentials() {
        login = home.goToLoginPage();
        Assertions.assertEquals(login.urlLogin, driver.getCurrentUrl(), "The page is not login page");
        String myLogin = service.getCredentialValue("myLogin");
        String myPassword = service.getCredentialValue("myPassword");
        login.insertMyLogin(myLogin);
        login.insertMyPassword(myPassword);
        home = login.goToHomePage();
        Assertions.assertTrue(home.checkIfYouAreLoggedAndYouAreOnHomePage(), "You are not logged into account!");
    }

    @Test
    public void dismissCookieMessage() {
        login = home.goToLoginPage();
        Assertions.assertEquals(login.urlLogin, driver.getCurrentUrl(), "The page is not login page");
        String myLogin = service.getCredentialValue("myLogin");
        String myPassword = service.getCredentialValue("myPassword");
        login.insertMyLogin(myLogin);
        login.insertMyPassword(myPassword);
        home = login.goToHomePage();
        Assertions.assertTrue(home.checkIfYouAreLoggedAndYouAreOnHomePage());
        home.closeCookieMessage();
        Assertions.assertTrue(home.isCookieMessageNotVisible(), "Cookie message is still visible");
    }

    @Test
    public void logOutFromAccount() {
        login = home.goToLoginPage();
        Assertions.assertEquals(login.urlLogin, driver.getCurrentUrl(), "The page is not login page");
        String myLogin = service.getCredentialValue("myLogin");
        String myPassword = service.getCredentialValue("myPassword");
        login.insertMyLogin(myLogin);
        login.insertMyPassword(myPassword);
        home = login.goToHomePage();
        Assertions.assertTrue(home.checkIfYouAreLoggedAndYouAreOnHomePage());
        home.clickAccountIcon();
        home.logOutFromAccount();
        home.clickAccountIcon();
        Assertions.assertTrue(home.isLogInButtonAvailable());
    }
    @Test
    public void logInByRememberMeCheckbox() {
        login = home.goToLoginPage();
        Assertions.assertEquals(login.urlLogin, driver.getCurrentUrl(), "The page is not login page");
        login.rememberMeCheckboxClick();
        String myLogin = service.getCredentialValue("myLogin");
        String myPassword = service.getCredentialValue("myPassword");
        login.insertMyLogin(myLogin);
        login.insertMyPassword(myPassword);
        home = login.goToHomePage();
        Assertions.assertTrue(home.checkIfYouAreLoggedAndYouAreOnHomePage());
        home.clickAccountIcon();
        home.logOutFromAccount();
        login = home.goToLoginPage();
        Assertions.assertTrue(login.isTheRememberMeCheckoxTicked());
    }
}
