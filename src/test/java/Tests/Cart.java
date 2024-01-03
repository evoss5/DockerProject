package Tests;

import Pages.AfterLoginPage;
import Pages.CartPage;
import Pages.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

public class Cart extends BaseTest {

    private LoginPage login;
    private AfterLoginPage page;
    private CartPage cart;


    @Test
    public void addProductToCart() {
        page = new AfterLoginPage(driver);
        login = home.goToLoginPage();
        String myLogin = service.getCredentialValue("myLogin");
        String myPassword = service.getCredentialValue("myPassword");
        login.insertMyLogin(myLogin);
        login.insertMyPassword(myPassword);
        home = login.goToHomePage();
        Assertions.assertTrue(page.isCartLayoutVisible(), "You are not logged!");
//        page.addAppleJuiceToCart();
        page.chooseProductToAdd("Green Smoothie");
        cart = page.goToCartPage();
        Assertions.assertTrue(page.isTotalPriceLayoutVisible());
        cart.clickCheckoutButton();
        cart.addNewAdress();
        String randomCountry = service.getRandomValue(service.countriesList());
        cart.inputCountryName(randomCountry);
        String randomName = service.getRandomValue(service.namesList());
        cart.inputName(randomName);
        cart.phoneNumber(service.cellPhoneNumber());
        cart.inputAddress(service.getRandomValue(service.randomCities()));
        String zipCode = service.getRandomValue(service.randomzipCodes());
        cart.inputZipCode(zipCode);
        String city = service.getRandomValue(service.randomCities());
        cart.inputCityName(city);
        Assertions.assertTrue(cart.isSubmitButtonEnabled());
        cart.submitButtonClick();
        cart.selectAddressClick();
        Assertions.assertTrue(cart.isContinueButtonClickable());
    }

    // TODO: 30.12.2023 Dodać message do Assertów
    @Test
    public void choosingDeliveryOption() {
        page = new AfterLoginPage(driver);
        login = home.goToLoginPage();
        String myLogin = service.getCredentialValue("myLogin");
        String myPassword = service.getCredentialValue("myPassword");
        login.insertMyLogin(myLogin);
        login.insertMyPassword(myPassword);
        home = login.goToHomePage();
        Assertions.assertTrue(page.isCartLayoutVisible(), "You are not logged!");
        page.chooseProductToAdd("Apple Juice");
        cart = page.goToCartPage();
        Assertions.assertTrue(page.isTotalPriceLayoutVisible());
        cart.clickCheckoutButton();
        cart.addNewAdress();
        String randomCountry = service.getRandomValue(service.countriesList());
        cart.inputCountryName(randomCountry);
        String randomName = service.getRandomValue(service.namesList());
        cart.inputName(randomName);
        cart.phoneNumber(service.cellPhoneNumber());
        cart.inputAddress(service.getRandomValue(service.randomCities()));
        String zipCode = service.getRandomValue(service.randomzipCodes());
        cart.inputZipCode(zipCode);
        String city = service.getRandomValue(service.randomCities());
        cart.inputCityName(city);
        Assertions.assertTrue(cart.isSubmitButtonEnabled());
        cart.submitButtonClick();
        cart.selectRandomAddress();
        Assertions.assertTrue(cart.isContinueButtonClickable());
        cart.continueButtonClick();
//        Assertions.assertEquals("Delivery Address", cart.isDeliveryMessageVisible());
        Assertions.assertTrue(cart.isDeliveryMessageVisible());
        cart.randomDeliveryOption();
        Assertions.assertTrue(cart.isContinueButtonClickable());
        // TODO: 30.12.2023 Zrobić asercję z selected
    }

    @Test
    public void addingCardNumber() {
        page = new AfterLoginPage(driver);
        login = home.goToLoginPage();
        String myLogin = service.getCredentialValue("myLogin");
        String myPassword = service.getCredentialValue("myPassword");
        login.insertMyLogin(myLogin);
        login.insertMyPassword(myPassword);
        home = login.goToHomePage();
        Assertions.assertTrue(page.isCartLayoutVisible(), "You are not logged!");
        page.chooseProductToAdd("Apple Juice");
        cart = page.goToCartPage();
        Assertions.assertTrue(page.isTotalPriceLayoutVisible());
        cart.clickCheckoutButton();
        cart.addNewAdress();
        String randomCountry = service.getRandomValue(service.countriesList());
        cart.inputCountryName(randomCountry);
        String randomName = service.getRandomValue(service.namesList());
        cart.inputName(randomName);
        cart.phoneNumber(service.cellPhoneNumber());
        cart.inputAddress(service.getRandomValue(service.randomCities()));
        String zipCode = service.getRandomValue(service.randomzipCodes());
        cart.inputZipCode(zipCode);
        String city = service.getRandomValue(service.randomCities());
        cart.inputCityName(city);
        Assertions.assertTrue(cart.isSubmitButtonEnabled());
        cart.submitButtonClick();
        cart.selectAddressClick();
        Assertions.assertTrue(cart.isContinueButtonClickable());
        cart.continueButtonClick();
        Assertions.assertTrue(cart.isDeliveryMessageVisible());
        cart.randomDeliveryOption();
        Assertions.assertTrue(cart.isContinueButtonClickable());
        cart.continueButtonClick();
        cart.addCreditCard();
        cart.inputCardNumber(service.cardNumber());
        String digits = String.valueOf(service.cardNumber().length());
        Assertions.assertEquals("16", digits, "The card number has different digits than expected");    //checking if card number has 16 digits
        cart.inputPurchaserName(randomName);
        cart.expiryMonthFieldClick();
        cart.randomItem();
        cart.randomExpiryYear();
        cart.submitButtonClick();
        Assertions.assertTrue(cart.isThereMessageAboutSuccessfulAddedCard());
//        cart.randomName();
        // TODO: 30.12.2023 Asercja, że nowy numer karty widnieje na danej liście.
    }

    @Test
    public void finishPurchaseTest() {
        Assertions.assertTrue(cart.isContinueButtonClickable());
        cart.continueButtonClick();
        Assertions.assertTrue(cart.IsOrderSummarVisible());
        cart.purchaseProducts();
        Assertions.assertTrue(cart.checkIfConfirmationMessageIsVisible());
    }

    @Test
    public void checkingIfNon16DigitNumberCardAllowToContinueProcess() {
        page = new AfterLoginPage(driver);
        login = home.goToLoginPage();
        String myLogin = service.getCredentialValue("myLogin");
        String myPassword = service.getCredentialValue("myPassword");
        login.insertMyLogin(myLogin);
        login.insertMyPassword(myPassword);
        home = login.goToHomePage();
        Assertions.assertTrue(page.isCartLayoutVisible(), "You are not logged!");
        page.chooseProductToAdd("Apple Juice");
        cart = page.goToCartPage();
        Assertions.assertTrue(page.isTotalPriceLayoutVisible());
        cart.clickCheckoutButton();
        cart.addNewAdress();
        String randomCountry = service.getRandomValue(service.countriesList());
        cart.inputCountryName(randomCountry);
        String randomName = service.getRandomValue(service.namesList());
        cart.inputName(randomName);
        cart.phoneNumber(service.cellPhoneNumber());
        cart.inputAddress(service.getRandomValue(service.randomCities()));
        String zipCode = service.getRandomValue(service.randomzipCodes());
        cart.inputZipCode(zipCode);
        String city = service.getRandomValue(service.randomCities());
        cart.inputCityName(city);
        Assertions.assertTrue(cart.isSubmitButtonEnabled());
        cart.submitButtonClick();
        //;
        cart.selectRandomAddress();
        Assertions.assertTrue(cart.isContinueButtonClickable());
        cart.continueButtonClick();
        Assertions.assertTrue(cart.isDeliveryMessageVisible());
        cart.randomDeliveryOption();
        Assertions.assertTrue(cart.isContinueButtonClickable());
        cart.continueButtonClick();
        cart.addCreditCard();
        cart.inputCardNumber(service.cardNumber2());
        String digits = String.valueOf(service.cardNumber2().length());
        Assertions.assertNotEquals("16", digits, "The card number has different digits than expected");    //checking if card number has 16 digits
        cart.inputPurchaserName(randomName);
        cart.expiryMonthFieldClick();
        cart.randomItem();
        cart.randomExpiryYear();
        Assertions.assertFalse(cart.isSubmitButtonEnabled()); //checking if Submit Button is clickable after giving too short card number
    }// TODO: 30.12.2023 zrobić asercję z tekstem
}


