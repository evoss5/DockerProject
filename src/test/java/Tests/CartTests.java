package Tests;

import Pages.AfterLoginPage;
import Pages.CartPage;
import Pages.HomePage;
import Pages.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.security.Provider;

public class CartTests extends BaseTest {

    LoginPage login;
    AfterLoginPage page;
    CartPage cart;


    @Test
    public void addProductToCart() {
        home = new HomePage(driver);
        page = new AfterLoginPage(driver);
        login = home.goToLoginPage();
        String myLogin = service.getCredentialValue("myLogin");
        String myPassword = service.getCredentialValue("myPassword");
        login.insertMyLogin(myLogin);
        login.insertMyPassword(myPassword);
        home = login.goToHomePage();
        Assertions.assertTrue(page.IsCartLayoutVisible(), "You are not logged!");
        page.addAppleJuiceToCart();
        cart = page.goToCartPage();
        Assertions.assertTrue(page.IsTotalPriceLayoutVisible());
        cart.clickCheckoutButton();
        cart.addNewAdress();
        String randomCountry = service.getRandomValue(service.countriesList());
        cart.inputCountryName(randomCountry);
        String randomName = service.getRandomValue(service.namesList());
        cart.inputName(randomName);
        cart.phoneNumber(service.cellPhoneNumber());
        cart.inputAdress(service.getRandomValue(service.randomCities()));
        String zipCode = service.getRandomValue(service.randomzipCodes());
        cart.inputZipCode(zipCode);
        String city = service.getRandomValue(service.randomCities());
        cart.inputCityName(city);
        Assertions.assertTrue(cart.isSubmitButtonEnabled());
        cart.submitButtonClick();
        cart.selectAdressClick();
        Assertions.assertTrue(cart.isContinueButtonClickable());
    }
    @Test
    public void choosingDeliveryOption() {
        home = new HomePage(driver);
        page = new AfterLoginPage(driver);
        login = home.goToLoginPage();
        String myLogin = service.getCredentialValue("myLogin");
        String myPassword = service.getCredentialValue("myPassword");
        login.insertMyLogin(myLogin);
        login.insertMyPassword(myPassword);
        home = login.goToHomePage();
        Assertions.assertTrue(page.IsCartLayoutVisible(), "You are not logged!");
        page.addAppleJuiceToCart();
        cart = page.goToCartPage();
        Assertions.assertTrue(page.IsTotalPriceLayoutVisible());
        cart.clickCheckoutButton();
        cart.addNewAdress();
        String randomCountry = service.getRandomValue(service.countriesList());
        cart.inputCountryName(randomCountry);
        String randomName = service.getRandomValue(service.namesList());
        cart.inputName(randomName);
        cart.phoneNumber(service.cellPhoneNumber());
        cart.inputAdress(service.getRandomValue(service.randomCities()));
        String zipCode = service.getRandomValue(service.randomzipCodes());
        cart.inputZipCode(zipCode);
        String city = service.getRandomValue(service.randomCities());
        cart.inputCityName(city);
        Assertions.assertTrue(cart.isSubmitButtonEnabled());
        cart.submitButtonClick();
        cart.selectAdressClick();
        Assertions.assertTrue(cart.isContinueButtonClickable());
        cart.continueButtonClick();
        WebElement deliveryMessage = driver.findElement(By.xpath("//*[@class='mat-card mat-focus-indicator mat-elevation-z6']//h1[1]"));
        Assertions.assertEquals("Delivery Address", deliveryMessage.getText());
        cart.chooseDeliveryOption();
        Assertions.assertTrue(cart.isContinueButtonClickable());
    }
    @Test
    public void addingCardNumber() {
        home = new HomePage(driver);
        page = new AfterLoginPage(driver);
        login = home.goToLoginPage();
        String myLogin = service.getCredentialValue("myLogin");
        String myPassword = service.getCredentialValue("myPassword");
        login.insertMyLogin(myLogin);
        login.insertMyPassword(myPassword);
        home = login.goToHomePage();
        Assertions.assertTrue(page.IsCartLayoutVisible(), "You are not logged!");
        page.addAppleJuiceToCart();
        cart = page.goToCartPage();
        Assertions.assertTrue(page.IsTotalPriceLayoutVisible());
        cart.clickCheckoutButton();
        cart.addNewAdress();
        String randomCountry = service.getRandomValue(service.countriesList());
        cart.inputCountryName(randomCountry);
        String randomName = service.getRandomValue(service.namesList());
        cart.inputName(randomName);
        cart.phoneNumber(service.cellPhoneNumber());
        cart.inputAdress(service.getRandomValue(service.randomCities()));
        String zipCode = service.getRandomValue(service.randomzipCodes());
        cart.inputZipCode(zipCode);
        String city = service.getRandomValue(service.randomCities());
        cart.inputCityName(city);
        Assertions.assertTrue(cart.isSubmitButtonEnabled());
        cart.submitButtonClick();
        cart.selectAdressClick();
        Assertions.assertTrue(cart.isContinueButtonClickable());
        cart.continueButtonClick();
        WebElement deliveryMessage = driver.findElement(By.xpath("//*[@class='mat-card mat-focus-indicator mat-elevation-z6']//h1[1]"));
        Assertions.assertEquals("Delivery Address", deliveryMessage.getText());
        cart.chooseDeliveryOption();
        Assertions.assertTrue(cart.isContinueButtonClickable());
        cart.continueButtonClick();
        cart.addCreditCard();
        cart.inputCardNumber(service.cardNumber());
        String digits = String.valueOf(service.cardNumber().length());
        System.out.println(digits);
        Assertions.assertEquals("16", digits, "The card number has different digits than expected");    //checking if card number has 16 digits
        cart.inputPurchaserName(randomName);
        driver.findElement(By.xpath("//select[@id='mat-input-12']")).click();
        cart.randomItem();
        driver.findElement(By.xpath("//select[@id='mat-input-13']")).click();
        cart.randomExpiryYear();
        cart.submitButtonClick();
        cart.randomCard();
    }
    @Test
    public void finishPurchaseTest() {
        Assertions.assertTrue(cart.isContinueButtonClickable());
        cart.continueButtonClick();
        Assertions.assertTrue(cart.IsOrderSummarVisible());
        cart.purchaseProducts();
        Assertions.assertTrue(cart.checkIfConfirmationMessageIsVisible());
    }
}


