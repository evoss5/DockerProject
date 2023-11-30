import Pages.BasicPage;
import Pages.FirstPage;
import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Tests {


    WebDriver driver;
    Service service;
    FirstPage page;
    BasicPage basic;
    HomePage home;
    WebDriverWait wait;

    LoginPage login;



    @BeforeMethod
    public void beforeTest() {

        driver = new ChromeDriver();
        service = new Service(driver);
        System.setProperty(service.getDriver(), service.chromeDriverURL());
        driver.get(service.getURL());
        driver.manage().window().maximize();

    }

    @Test
    public void languageChange() {
        home = new HomePage(driver);
        home.clickWelcomeBannerDismiss();
        home.clickLanguageSelectionMenu();
        home.clickChangeLanguageToPolish();

    }

    @Test
    public void openSideMenuTest() {
        home = new HomePage(driver);
        home.clickWelcomeBannerDismiss();
        home.sideNavButtonClick();
        home.clickGitHub();



    }

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
    }
}
