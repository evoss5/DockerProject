//import Pages.*;
//import com.github.javafaker.Faker;
//import org.junit.jupiter.api.Assertions;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//public class Tests {
//
//
//    WebDriver driver;
//    BasicPage basic;
//    private HomePage home;
//    WebDriverWait wait;
//    Faker faker = new Faker();
//
//    Tests.Service service;
//    LoginPage login;
//    GooglePage googlePage;
//    RegistrationPage register;
//    AfterLoginPage afterLoginPage;
//    CartPage cart;
//
//
//    @BeforeMethod
//    public void beforeTest() {
//
//        driver = new ChromeDriver();
//        service = new Service(driver);
//        home = new HomePage(driver);
//        System.setProperty(service.getDriver(), service.chromeDriverURL());
//        driver.get(service.getURL());
//        driver.manage().window().maximize();
//        logInToThePageByCredentials();
//
//    }
//
//    @Test
//    public void languageChange() {
//        home = new HomePage(driver);
//        home.clickWelcomeBannerDismiss();
//        home.clickLanguageSelectionMenu();
//        home.clickChangeLanguageToPolish();
//        Assertions.assertTrue(home.clickCheckIfLanguageIsPolish(), "Page is not in Polish");
//    }
//
//    @Tests
//    public void openSideMenuTest() {
//        home = new HomePage(driver);
//        home.clickWelcomeBannerDismiss();
//        home.sideNavButtonClick();
//        home.clickGitHub();
//        String rightURL = "https://github.com/juice-shop/juice-shop";
//        Assertions.assertEquals(rightURL, driver.getCurrentUrl(), "Page is not right one");
//
//
//    }
//
//    @Test
//    public void LoginPageTest() {
//        home = new HomePage(driver);
//        login = new LoginPage(driver);
//        home.clickWelcomeBannerDismiss();
//        home.clickAccountIcon();
//        home.clickLoginHomePage();
//        login.inputLogin();
//        login.inputPassword();
//        login.checkPassword();
//        login.loginInByStandardButton();
//        Assertions.assertTrue(home.IsThereInfoAboutWrongLoginOrPassword(), "The message is wrong");
//    }
//
//    @Test
//    public void LoginByGoogleTest() {
//        home = new HomePage(driver);
//        login = new LoginPage(driver);
//        googlePage = new GooglePage(driver);
//        home.clickWelcomeBannerDismiss();
//        home.clickAccountIcon();
//        home.clickLoginHomePage();
//        login.loginInByGoogle();
//        googlePage.clickCreateNewAccount();
//
//    }
//
//    @Test
//    public void LoginByGoogleTest2() {
//        home = new HomePage(driver);
//        login = new LoginPage(driver);
//        googlePage = new GooglePage(driver);
//        home.clickWelcomeBannerDismiss();
//        Assertions.assertTrue(home.isWelcomeMessageDismissed(), "Welcome message is still there");
//        home.clickAccountIcon();
//        home.clickLoginHomePage();
//        String loginPage = "http://localhost:3000/#/login";
//        Assertions.assertEquals(loginPage, driver.getCurrentUrl(), "The page is not login page");
//        login.loginInByGoogle();
//
//
//    }
//
//    @Test
//    public void registerNewAccount() {
//        home = new HomePage(driver);
//        login = new LoginPage(driver);
//        service = new Service(driver);
//        googlePage = new GooglePage(driver);
//        home.clickWelcomeBannerDismiss();
//        Assertions.assertTrue(home.isWelcomeMessageDismissed(), "Welcome message is still there");
//        login = home.goToLoginPage();
//        String loginPage = "http://localhost:3000/#/login";
//        Assertions.assertEquals(loginPage, driver.getCurrentUrl(), "The page is not login page");
//        register = login.goToRegistrationPage();
//        Assertions.assertTrue(register.checkIfPageShowsEmailField(), "The page is not login page");
//        String name = service.getRandomValue(service.namesList());
//        String surname = service.getRandomValue((service.surnamesList()));
//        String email = service.createEmailAddress(name, surname, service.randomNumber(), service.getRandomValue(service.eMailsDomenList()));
//        register.insertEmail(email);
//        String password = service.getRandomValue(service.randomPasswordList());
//        service.createRandomPassword(password, service.randomNumber());
//        register.insertPassword(password);
//        register.clickSecurityQuestionField();
//        String name2 = service.getRandomValue(service.namesList());
//        register.setAnswerForSecurityQuestion(name2);
//        register.clickRegister();
//        Assertions.assertTrue(register.checkIfAccountIsCreatedSucessfuly(), "Account has not been created");
//
//    }
//
//    @Test
//    public void logInToThePage() {
//        home = new HomePage(driver);
//        login = new LoginPage(driver);
//        login = home.goToLoginPage();
//        String loginPage = "http://localhost:3000/#/login";
//        Assertions.assertEquals(loginPage, driver.getCurrentUrl(), "The page is not login page");
//        String myEmail = "admin@gmail.com";
//        login.insertMyLogin(myEmail);
//        String myPassword = "admin";
//        login.insertMyPassword(myPassword);
//        home = login.goToHomePage();
//        home.checkIfYouAreLoggedAndYouAreOnHomePage();
//    }
//
//    @Test
//    public void logInToThePageByCredentials() {
//        home = new HomePage(driver);
//        login = new LoginPage(driver);
//        service = new Service(driver);
//        login = home.goToLoginPage();
//        String loginPage = "http://localhost:3000/#/login";
//        Assertions.assertEquals(loginPage, driver.getCurrentUrl(), "The page is not login page");
//        String myLogin = service.getCredentialValue("myLogin");
//        String myPassword = service.getCredentialValue("myPassword");
//        login.insertMyLogin(myLogin);
//        login.insertMyPassword(myPassword);
//        home = login.goToHomePage();
//    }
//
//    @Test
//    public void addNewAdressInCart() {
//        home = new HomePage(driver);
//        afterLoginPage = new AfterLoginPage(driver);
//        afterLoginPage.addAppleJuiceToCart();
//        cart = afterLoginPage.goToCartPage();
//        Assertions.assertTrue(afterLoginPage.IsTotalPriceLayoutVisible());
//        cart.clickCheckoutButton();
//        cart.addNewAdress();
//        String randomCountry = service.getRandomValue(service.countriesList());
//        cart.inputCountryName(randomCountry);
//        String randomName = service.getRandomValue(service.namesList());
//        cart.inputName(randomName);
//        cart.phoneNumber(service.cellPhoneNumber());
//        cart.inputAdress(service.getRandomValue(service.randomCities()));
//        String zipCode = service.getRandomValue(service.randomzipCodes());
//        cart.inputZipCode(zipCode);
//        String city = service.getRandomValue(service.randomCities());
//        cart.inputCityName(city);
//        Assertions.assertTrue(cart.isSubmitButtonEnabled());
//        cart.submitButtonClick();
//        cart.selectAdressClick();
//    }
//
//    @Test
//    public void chooseDeliveryOptionTest() {
//        addNewAdressInCart();
//        Assertions.assertTrue(cart.isContinueButtonClickable());
//        cart.continueButtonClick();
//        WebElement deliveryMessage = driver.findElement(By.xpath("//*[@class='mat-card mat-focus-indicator mat-elevation-z6']//h1[1]"));
//        Assertions.assertEquals("Delivery Address", deliveryMessage.getText());
//        cart.chooseDeliveryOption();
//        Assertions.assertTrue(cart.isContinueButtonClickable());
//    }
//
//    @Test
//    public void addCardNumberTestForShipment() {
//        chooseDeliveryOptionTest();
//        cart.continueButtonClick();
//        cart.addCreditCard();
//        cart.inputCardNumber(service.cardNumber());
//        String digits = String.valueOf(service.cardNumber().length());
//        System.out.println(digits);
//        Assertions.assertEquals("16", digits, "The card number has different digits than expected");    //checking if card number has 16 digits
//        cart.chooseCreditCard();
//
//
//    }
//
//    @Test
//    public void finishPurchaseTest() {
//        addCardNumberTestForShipment();
//        Assertions.assertTrue(cart.isContinueButtonClickable());
//        cart.continueButtonClick();
//        Assertions.assertTrue(cart.IsOrderSummarVisible());
//        cart.purchaseProducts();
//        Assertions.assertTrue(cart.checkIfConfirmationMessageIsVisible());
//    }
//
//
//}
//// TODO: 23.12.2023 Usunięcie deklaracji BasicPage oraz WebdriverWait (Zrobione)
//// TODO: 23.12.2023 Stworzyć paczkę Tests i wrzucać tam testy (Zrobione)
//// TODO: 23.12.2023 Nie użwyać innych testów w testach (Zrobione)
//// TODO: 23.12.2023 W deklaracjach dodać modyfikatory dostępu "Private" (Zrobione)
//// TODO: 23.12.2023 Poprawić przejścia między stronami w testach logowania (Zrobione)
//// TODO: 23.12.2023 Zrobić "negatywne ścieżki" np. Wpisanie loginu bez domeny itd. (Zrobione)
//// TODO: 23.12.2023 Każdy test powinien się kończyć asercją (Zrobione)
//// TODO: 23.12.2023 Metoda getText powinna być zawarta w Pagu (Zrobione)
