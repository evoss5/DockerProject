package Tests;

import Pages.AfterLoginPage;
import Pages.GooglePage;
import Pages.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

public class LogIn extends BaseTest {

    private LoginPage login;
    private GooglePage googlePage;
    private AfterLoginPage page;

    @Test
    public void LoginPage() {
        login = new LoginPage(driver);
        home.clickAccountIcon();
        home.clickLoginHomePage();
        login.inputLogin();
        login.inputPassword();
        login.checkPassword();
        login.goToHomePage();
        Assertions.assertTrue(home.isThereInfoAboutWrongLoginOrPassword(), "Invalid email or password.");
        // TODO: 30.12.2023 pozmieniać treści messagów
    }

    @Test
    public void LoginByGoogle() {
        login = new LoginPage(driver);
        googlePage = new GooglePage(driver);
        home.clickWelcomeBannerDismiss();
        home.clickAccountIcon();
        home.clickLoginHomePage();
        login.loginInByGoogle();
        googlePage.clickCreateNewAccount();
        Assertions.assertTrue(googlePage.IsGoogleHeaderVisible());
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
        Assertions.assertTrue(home.checkIfYouAreLoggedAndYouAreOnHomePage());
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
        Assertions.assertTrue(home.isCookieMessageNotVisible());
    }
}
