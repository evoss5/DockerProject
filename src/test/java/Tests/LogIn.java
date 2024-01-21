package Tests;

import Pages.Utilities.Languages;
import Pages.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class LogIn extends BaseTest {

    private LoginPage login;
    private SqlQueries database;

    @Test
    public void LoginPage() {
        login = home.goToLoginPage();
        login.logToThePage("admin", "admin");
        Assertions.assertTrue(login.isInvalidEmailOrPasswordMessageVisible(), "Invalid email or password.");
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
        login.logToThePage(myLogin, myPassword);
        home = login.loginButtonClick();
        Assertions.assertTrue(home.isAddToCartButtonVisible(), "You are not logged into account!");
    }

    @Test
    public void dismissCookieMessage() {
        login = home.goToLoginPage();
        Assertions.assertEquals(login.urlLogin, driver.getCurrentUrl(), "The page is not login page");
        String myLogin = service.getCredentialValue("myLogin");
        String myPassword = service.getCredentialValue("myPassword");
        login.logToThePage(myLogin, myPassword);
        home = login.loginButtonClick();
        Assertions.assertTrue(home.isAddToCartButtonVisible(), "Add to cart button is not visible.");
        home.acceptCookieButtonClick();
        Assertions.assertFalse(home.isCookieAcceptButtonVisible(), "Cookie message is still visible");
    }

    @Test
    public void logOutFromAccount() {
        login = home.goToLoginPage();
        Assertions.assertEquals(login.urlLogin, driver.getCurrentUrl(), "The page is not login page");
        String myLogin = service.getCredentialValue("myLogin");
        String myPassword = service.getCredentialValue("myPassword");
        login.logToThePage(myLogin, myPassword);
        home = login.loginButtonClick();
        Assertions.assertTrue(home.isAddToCartButtonVisible(), "Add to cart button is not visible.");
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
        login.logToThePage(myLogin, myPassword);
        home = login.loginButtonClick();
        Assertions.assertTrue(home.isAddToCartButtonVisible(), "Add to cart button is not visible.");
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
        login.logToThePage(myLogin, myPassword);
        home = login.loginButtonClick();
        home.languageSelectionMenuButtonClick();
        home.selectLanguage(Languages.FRENCH.getDisplayName());
        Assertions.assertFalse(home.isLanguageChanged(), "You haven't changed language");
    }
    }

