import Pages.*;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Tests {


    WebDriver driver;
    Service service;
    BasicPage basic;
    HomePage home;
    WebDriverWait wait;

    LoginPage login;
    GooglePage googlePage;
    RegistrationPage register;


    @BeforeMethod
    public void beforeTest() {

        driver = new ChromeDriver();
        service = new Service(driver);
        home = new HomePage(driver);
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
        Assertions.assertTrue(home.clickCheckIfLanguageIsPolish(), "Page is not in Polish");
    }

    @Test
    public void openSideMenuTest() {
        home = new HomePage(driver);
        home.clickWelcomeBannerDismiss();
        home.sideNavButtonClick();
        home.clickGitHub();
        String rightURL = "https://github.com/juice-shop/juice-shop";
        Assertions.assertEquals(rightURL, driver.getCurrentUrl(), "Page is not right one");


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

    }

    @Test
    public void LoginByGoogleTest2() {
        home = new HomePage(driver);
        login = new LoginPage(driver);
        googlePage = new GooglePage(driver);
        home.clickWelcomeBannerDismiss();
        Assertions.assertTrue(home.isWelcomeMessageDismissed(), "Welcome message is still there");
        home.clickAccountIcon();
        home.clickLoginHomePage();
        String loginPage = "http://localhost:3000/#/login";
        Assertions.assertEquals(loginPage, driver.getCurrentUrl(), "The page is not login page");
        login.loginInByGoogle();


    }

    @Test
    public void registerNewAccount() {
        home = new HomePage(driver);
        login = new LoginPage(driver);
        service = new Service(driver);
        googlePage = new GooglePage(driver);
//        home.clickWelcomeBannerDismiss();
        Assertions.assertTrue(home.isWelcomeMessageDismissed(), "Welcome message is still there");
        login = home.goToLoginPage();
        String loginPage = "http://localhost:3000/#/login";
        Assertions.assertEquals(loginPage, driver.getCurrentUrl(), "The page is not login page");
        register = login.goToRegistrationPage();
        Assertions.assertTrue(register.checkIfPageShowsEmailField(), "The page is not login page");
        String name = service.getRandomValue(service.namesList());
        String surname = service.getRandomValue((service.surnamesList()));
        String email = service.createEmailAddress(name, surname, service.randomNumber(), service.getRandomValue(service.eMailsDomenList()));
        register.insertEmail(email);
        String password = service.getRandomValue(service.randomPasswordList());
        service.createRandomPassword(password, service.randomNumber());
        register.insertPassword(password);
        register.clickSecurityQuestionField();
        String name2 = service.getRandomValue(service.namesList());
        register.setAnswerForSecurityQuestion(name2);
        register.clickRegister();
        Assertions.assertTrue(register.checkIfAccountIsCreatedSucessfuly(), "Account has not been created");

    }

    @Test
    public void logInToThePage() {
        home = new HomePage(driver);
        login = new LoginPage(driver);
        login = home.goToLoginPage();
        String loginPage = "http://localhost:3000/#/login";
        Assertions.assertEquals(loginPage, driver.getCurrentUrl(), "The page is not login page");
        String myEmail = "admin@gmail.com";
        login.insertMyLogin(myEmail);
        String myPassword = "admin";
        login.insertMyPassword(myPassword);
        home = login.goToHomePage();
        home.checkIfYouAreLoggedAndYouAreOnHomePage();
    }


    @Test
    public void logInToThePage2() {
        home = new HomePage(driver);
        login = new LoginPage(driver);
        service = new Service(driver);
        login = home.goToLoginPage();
        String loginPage = "http://localhost:3000/#/login";
        Assertions.assertEquals(loginPage, driver.getCurrentUrl(), "The page is not login page");
        String myLogin = service.getCredentialValue("myLogin");
        String myPassword = service.getCredentialValue("myPassword");
        login.insertMyLogin(myLogin);
    }

}


