package Tests;

import Pages.CartPage;
import Pages.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

public class Cart extends BaseTest {

    private LoginPage login;

    private CartPage cart;


    @Test
    public void addProductToCart() {
        login = home.goToLoginPage();
        String myLogin = service.getCredentialValue("myLogin");
        String myPassword = service.getCredentialValue("myPassword");
        login.logToThePage(myLogin, myPassword);
        Assertions.assertTrue(home.isCartButtonVisible(), "You are not logged!");
        home.chooseProductToAdd("Green Smoothie");
        cart = home.goToCartPage();
        Assertions.assertTrue(home.isTotalPriceFieldVisible(), "Total Price is not visible.");
        cart.checkoutButtonClick();
        cart.addNewAdress();
        String randomName = service.getRandomValue(service.namesList());
        String zipCode = service.getRandomValue(service.randomzipCodes());
        String city = service.getRandomValue(service.randomCities());
        String address = service.getRandomValue(service.randomCities());
        String country = service.getRandomValue(service.countriesList());
        cart.fillPurchaserData(randomName, city, country, zipCode, service.cellPhoneNumber(), address);
        cart.submitButtonClick();
        cart.selectAddressClick();
        Assertions.assertTrue(cart.isAddressRadioButtonSelected(), "Address Radio Button is not selected");
    }

    @Test
    public void choosingDeliveryOption() {
        login = home.goToLoginPage();
        String myLogin = service.getCredentialValue("myLogin");
        String myPassword = service.getCredentialValue("myPassword");
        login.logToThePage(myLogin, myPassword);
        Assertions.assertTrue(home.isCartButtonVisible(), "You are not logged!");
        home.chooseProductToAdd("Green Smoothie");
        cart = home.goToCartPage();
        Assertions.assertTrue(home.isTotalPriceFieldVisible(), "Total Price is not visible.");
        cart.checkoutButtonClick();
        cart.addNewAdress();
        String randomName = service.getRandomValue(service.namesList());
        String zipCode = service.getRandomValue(service.randomzipCodes());
        String city = service.getRandomValue(service.randomCities());
        String address = service.getRandomValue(service.randomCities());
        String country = service.getRandomValue(service.countriesList());
        cart.fillPurchaserData(randomName, city, country, zipCode, service.cellPhoneNumber(), address);
        cart.submitButtonClick();
        cart.selectAddressClick();
        Assertions.assertTrue(cart.isContinueButtonClickable(), "Continue button is not clickable.");
        cart.continueButtonClick();
        Assertions.assertTrue(cart.isDeliveryMessageVisible(), "Delivery message is not visible.");
        cart.randomDeliveryOption();
        Assertions.assertTrue(cart.isDeliveryOptionSelected(), "You haven't choose delivery option!");
        Assertions.assertTrue(cart.isContinueButtonClickable(), "Continue button is not clickable");
    }

    @Test
    public void addingCardNumber() {
        login = home.goToLoginPage();
        String myLogin = service.getCredentialValue("myLogin");
        String myPassword = service.getCredentialValue("myPassword");
        login.logToThePage(myLogin, myPassword);
        Assertions.assertTrue(home.isCartButtonVisible(), "You are not logged!");
        home.chooseProductToAdd("Green Smoothie");
        cart = home.goToCartPage();
        Assertions.assertTrue(home.isTotalPriceFieldVisible(), "Total price is not visible.");
        cart.checkoutButtonClick();
        cart.addNewAdress();
        String randomName = service.getRandomValue(service.namesList());
        String zipCode = service.getRandomValue(service.randomzipCodes());
        String city = service.getRandomValue(service.randomCities());
        String address = service.getRandomValue(service.randomCities());
        String country = service.getRandomValue(service.countriesList());
        cart.fillPurchaserData(randomName, city, country, zipCode, service.cellPhoneNumber(), address);
        cart.submitButtonClick();
        cart.selectAddressClick();
        Assertions.assertTrue(cart.isContinueButtonClickable(), "Continue button is not clickable.");
        cart.continueButtonClick();
        Assertions.assertTrue(cart.isDeliveryMessageVisible(), "Delivery message is not visible.");
        cart.randomDeliveryOption();
        Assertions.assertTrue(cart.isContinueButtonClickable(), "Continue button is not clickable.");
        cart.continueButtonClick();
        cart.creditCardDropdownClick();
        cart.fillCardNumberField(service.cardNumber());
        String digits = String.valueOf(service.cardNumber().length());
        cart.fillPurchaserCardData(service.cardNumber(), randomName);
        Assertions.assertEquals("16", digits, "The card number has different digits than expected");    //checking if card number has 16 digits
        cart.submitButtonClick();
        Assertions.assertTrue(cart.isSuccessfullyAddedCardMessageVisible(), "Successfully added card message is not visible.");
    }

    @Test
    public void choosingPaymentOption() {
        login = home.goToLoginPage();
        String myLogin = service.getCredentialValue("myLogin");
        String myPassword = service.getCredentialValue("myPassword");
        login.logToThePage(myLogin, myPassword);
        Assertions.assertTrue(home.isCartButtonVisible(), "You are not logged!");
        home.chooseProductToAdd("Green Smoothie");
        cart = home.goToCartPage();
        Assertions.assertTrue(home.isTotalPriceFieldVisible());
        cart.checkoutButtonClick();
        cart.addNewAdress();
        String randomName = service.getRandomValue(service.namesList());
        String zipCode = service.getRandomValue(service.randomzipCodes());
        String city = service.getRandomValue(service.randomCities());
        String address = service.getRandomValue(service.randomCities());
        String country = service.getRandomValue(service.countriesList());
        cart.fillPurchaserData(randomName, city, country, zipCode, service.cellPhoneNumber(), address);
        cart.submitButtonClick();
        cart.selectAddressClick();
        Assertions.assertTrue(cart.isContinueButtonClickable(), "Continue button is not clickable.");
        cart.continueButtonClick();
        Assertions.assertTrue(cart.isDeliveryMessageVisible(), "Delivery message is not visible.");
        cart.randomDeliveryOption();
        Assertions.assertTrue(cart.isContinueButtonClickable(), "Continue button is not clickable.");
        cart.continueButtonClick();
        cart.creditCardDropdownClick();
        cart.fillCardNumberField(service.cardNumber());
        String digits = String.valueOf(service.cardNumber().length());
        cart.fillPurchaserCardData(service.cardNumber(), randomName);
        Assertions.assertEquals("16", digits, "The card number has different digits than expected");    //checking if card number has 16 digits
        cart.submitButtonClick();
        Assertions.assertTrue(cart.isSuccessfullyAddedCardMessageVisible(), "Successfully added card message is not visible.");
        cart.creditCardCheckoxCheck();
        Assertions.assertTrue(cart.isCreditCardCheckboxSelected(), "Credit card checkbox is not selected.");
    }

    @Test
    public void finishPurchase() {
        login = home.goToLoginPage();
        String myLogin = service.getCredentialValue("myLogin");
        String myPassword = service.getCredentialValue("myPassword");
        login.logToThePage(myLogin, myPassword);
        Assertions.assertTrue(home.isCartButtonVisible(), "You are not logged!");
        home.chooseProductToAdd("Green Smoothie");
        cart = home.goToCartPage();
        Assertions.assertTrue(home.isTotalPriceFieldVisible());
        cart.checkoutButtonClick();
        cart.addNewAdress();
        String randomName = service.getRandomValue(service.namesList());
        String zipCode = service.getRandomValue(service.randomzipCodes());
        String city = service.getRandomValue(service.randomCities());
        String address = service.getRandomValue(service.randomCities());
        String country = service.getRandomValue(service.countriesList());
        cart.fillPurchaserData(randomName, city, country, zipCode, service.cellPhoneNumber(), address);
        cart.submitButtonClick();
        cart.selectAddressClick();
        Assertions.assertTrue(cart.isContinueButtonClickable(), "Continue button is not clickable.");
        cart.continueButtonClick();
        Assertions.assertTrue(cart.isDeliveryMessageVisible(), "Delivery message is not visible.");
        cart.randomDeliveryOption();
        Assertions.assertTrue(cart.isContinueButtonClickable(), "Continue button is not clickable.");
        cart.continueButtonClick();
        cart.creditCardDropdownClick();
        cart.fillCardNumberField(service.cardNumber());
        String digits = String.valueOf(service.cardNumber().length());
        cart.fillPurchaserCardData(service.cardNumber(), randomName);
        Assertions.assertEquals("16", digits, "The card number has different digits than expected");    //checking if card number has 16 digits
        cart.submitButtonClick();
        Assertions.assertTrue(cart.isSuccessfullyAddedCardMessageVisible(), "Successfully added card message is not visible.");
        cart.creditCardCheckoxCheck();
        Assertions.assertTrue(cart.isCreditCardCheckboxSelected(), "Credit card checkbox is not selected.");
        cart.continueButtonClick();
        Assertions.assertTrue(cart.isOrderSummaryVisible(), "Order summary is not visible.");
        cart.purchaseProductsButtonClick();
        Assertions.assertTrue(cart.checkIfConfirmationMessageIsVisible(), "Confirmation message is not visible.");
    }

    @Test
    public void checkingIfNon16DigitNumberCardAllowToContinueProcess() {
        login = home.goToLoginPage();
        String myLogin = service.getCredentialValue("myLogin");
        String myPassword = service.getCredentialValue("myPassword");
        login.logToThePage(myLogin, myPassword);
        Assertions.assertTrue(home.isCartButtonVisible(), "You are not logged!");
        home.chooseProductToAdd("Green Smoothie");
        cart = home.goToCartPage();
        Assertions.assertTrue(home.isTotalPriceFieldVisible(), "Total price is not visible.");
        cart.checkoutButtonClick();
        cart.addNewAdress();
        String randomName = service.getRandomValue(service.namesList());
        String zipCode = service.getRandomValue(service.randomzipCodes());
        String city = service.getRandomValue(service.randomCities());
        String address = service.getRandomValue(service.randomCities());
        String country = service.getRandomValue(service.countriesList());
        cart.fillPurchaserData(randomName, city, country, zipCode, service.cellPhoneNumber(), address);
        cart.submitButtonClick();
        cart.selectAddressClick();
        Assertions.assertTrue(cart.isContinueButtonClickable(), "Continue button is not clickable.");
        cart.continueButtonClick();
        Assertions.assertTrue(cart.isDeliveryMessageVisible(), "Delivery Message is not visible.");
        cart.randomDeliveryOption();
        Assertions.assertTrue(cart.isContinueButtonClickable(), "Continue button is not clickable.");
        cart.continueButtonClick();
        cart.creditCardDropdownClick();
        String digits = String.valueOf(service.cardNumber2().length());
        cart.fillPurchaserCardData(service.cardNumber2(), randomName);
        Assertions.assertNotEquals("16", digits, "Please enter a valid sixteen digit card number");    //checking if card number has 16 digits
        Assertions.assertEquals("Please enter a valid sixteen digit card number.", cart.invalidSixteenDigitCardNumber());
    }

    @Test
    public void isThePriceIsAppropriateAfterAddingProductToCart() {
        login = home.goToLoginPage();
        String myLogin = service.getCredentialValue("myLogin");
        String myPassword = service.getCredentialValue("myPassword");
        login.logToThePage(myLogin, myPassword);
        home = login.loginButtonClick();
        Assertions.assertTrue(home.isCartButtonVisible(), "You are not logged!");
        home.chooseProductToAdd("Green Smoothie");
        cart = home.goToCartPage();
        Assertions.assertTrue(cart.doesTotalPriceShowsProperPrice("1.99"), "Total Price is different than expected");
    }
}





