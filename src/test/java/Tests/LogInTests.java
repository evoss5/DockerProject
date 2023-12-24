package Tests;

import Pages.AfterLoginPage;
import Pages.GooglePage;
import Pages.HomePage;
import Pages.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

public class LogInTests extends BaseTest {

    LoginPage login;
    GooglePage googlePage;
    AfterLoginPage page;

    @Test
    public void LoginPageTest() {
        home = new HomePage(driver);
        login = new LoginPage(driver);
        home.clickWelcomeBannerDismiss();
        home.clickAccountIcon();
        home.clickLoginHomePage();
        login.inputLogin();
        login.inputPassword();
        login.checkPassword();
        login.loginInByStandardButton();
        Assertions.assertTrue(home.IsThereInfoAboutWrongLoginOrPassword(), "The message is wrong");
    }

    @Test
    public void LoginByGoogleTest() {
        home = new HomePage(driver);
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
        home = new HomePage(driver);
        login = new LoginPage(driver);
        service = new Service(driver);
        login = home.goToLoginPage();
        String loginPage = "http://localhost:3000/#/login";
        Assertions.assertEquals(loginPage, driver.getCurrentUrl(), "The page is not login page");
        String myLogin = service.getCredentialValue("myLogin");
        String myPassword = service.getCredentialValue("myPassword");
        login.insertMyLogin(myLogin);
        login.insertMyPassword(myPassword);
        home = login.goToHomePage();
        Assertions.assertTrue(page.IsCartLayoutVisible(), "You are not logged!");
    }
}
