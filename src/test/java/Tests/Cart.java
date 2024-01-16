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
        login.fillMyLoginField(myLogin);
        login.fillMyPasswordField(myPassword);
        home = login.loginButtonClick();
        Assertions.assertTrue(page.isCartButtonVisible(), "You are not logged!");
        page.chooseProductToAdd("Green Smoothie");
        cart = page.goToCartPage();
        Assertions.assertTrue(page.isTotalPriceFieldVisible(), "Total Price is not visible.");
        cart.checkoutButtonClick();
        cart.addNewAdress();
        String randomCountry = service.getRandomValue(service.countriesList());
        cart.fillCountryNameField(randomCountry);
        String randomName = service.getRandomValue(service.namesList());
        cart.fillNameField(randomName);
        cart.fillPhoneNumberField(service.cellPhoneNumber());
        cart.fillAddressField(service.getRandomValue(service.randomCities()));
        String zipCode = service.getRandomValue(service.randomzipCodes());
        cart.fillZipCodeField(zipCode);
        String city = service.getRandomValue(service.randomCities());
        cart.fillCityNameField(city);
        Assertions.assertTrue(cart.isSubmitButtonEnabled(), "Submit Button is not Enabled.");
        cart.submitButtonClick();
        cart.selectAddressClick();
        Assertions.assertTrue(cart.isAddressRadioButtonSelected());
    }

    @Test
    public void choosingDeliveryOption() {
        page = new AfterLoginPage(driver);
        login = home.goToLoginPage();
        String myLogin = service.getCredentialValue("myLogin");
        String myPassword = service.getCredentialValue("myPassword");
        login.fillMyLoginField(myLogin);
        login.fillMyPasswordField(myPassword);
        home = login.loginButtonClick();
        Assertions.assertTrue(page.isCartButtonVisible(), "You are not logged!");
        page.chooseProductToAdd("Green Smoothie");
        cart = page.goToCartPage();
        Assertions.assertTrue(page.isTotalPriceFieldVisible(), "Total Price is not visible.");
        cart.checkoutButtonClick();
        cart.addNewAdress();
        String randomCountry = service.getRandomValue(service.countriesList());
        cart.fillCountryNameField(randomCountry);
        String randomName = service.getRandomValue(service.namesList());
        cart.fillNameField(randomName);
        cart.fillPhoneNumberField(service.cellPhoneNumber());
        cart.fillAddressField(service.getRandomValue(service.randomCities()));
        String zipCode = service.getRandomValue(service.randomzipCodes());
        cart.fillZipCodeField(zipCode);
        String city = service.getRandomValue(service.randomCities());
        cart.fillCityNameField(city);
        Assertions.assertTrue(cart.isSubmitButtonEnabled(), "Submit Button is not visible.");
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
        page = new AfterLoginPage(driver);
        login = home.goToLoginPage();
        String myLogin = service.getCredentialValue("myLogin");
        String myPassword = service.getCredentialValue("myPassword");
        login.fillMyLoginField(myLogin);
        login.fillMyPasswordField(myPassword);
        home = login.loginButtonClick();
        Assertions.assertTrue(page.isCartButtonVisible(), "You are not logged!");
        page.chooseProductToAdd("Green Smoothie");
        cart = page.goToCartPage();
        Assertions.assertTrue(page.isTotalPriceFieldVisible(), "Total price is not visible.");
        cart.checkoutButtonClick();
        cart.addNewAdress();
        String randomCountry = service.getRandomValue(service.countriesList());
        cart.fillCountryNameField(randomCountry);
        String randomName = service.getRandomValue(service.namesList());
        cart.fillNameField(randomName);
        cart.fillPhoneNumberField(service.cellPhoneNumber());
        cart.fillAddressField(service.getRandomValue(service.randomCities()));
        String zipCode = service.getRandomValue(service.randomzipCodes());
        cart.fillZipCodeField(zipCode);
        String city = service.getRandomValue(service.randomCities());
        cart.fillCityNameField(city);
        Assertions.assertTrue(cart.isSubmitButtonEnabled(), "Submit button is not enabled.");
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
        Assertions.assertEquals("16", digits, "The card number has different digits than expected");    //checking if card number has 16 digits
        cart.fillPurchaserNameField(randomName);
        cart.expiryMonthFieldClick();
        cart.randomExpiryMonth();
        cart.randomExpiryYear();
        cart.submitButtonClick();
        Assertions.assertTrue(cart.isSuccessfullyAddedCardMessageVisible(), "Successfully added card message is not visible.");
    }

    @Test
    public void choosingPaymentOption() {
        page = new AfterLoginPage(driver);
        login = home.goToLoginPage();
        String myLogin = service.getCredentialValue("myLogin");
        String myPassword = service.getCredentialValue("myPassword");
        login.fillMyLoginField(myLogin);
        login.fillMyPasswordField(myPassword);
        home = login.loginButtonClick();
        Assertions.assertTrue(page.isCartButtonVisible(), "You are not logged!");
        page.chooseProductToAdd("Green Smoothie");
        cart = page.goToCartPage();
        Assertions.assertTrue(page.isTotalPriceFieldVisible());
        cart.checkoutButtonClick();
        cart.addNewAdress();
        String randomCountry = service.getRandomValue(service.countriesList());
        cart.fillCountryNameField(randomCountry);
        String randomName = service.getRandomValue(service.namesList());
        cart.fillNameField(randomName);
        cart.fillPhoneNumberField(service.cellPhoneNumber());
        cart.fillAddressField(service.getRandomValue(service.randomCities()));
        String zipCode = service.getRandomValue(service.randomzipCodes());
        cart.fillZipCodeField(zipCode);
        String city = service.getRandomValue(service.randomCities());
        cart.fillCityNameField(city);
        Assertions.assertTrue(cart.isSubmitButtonEnabled(), "Submit button is not enabled.");
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
        Assertions.assertEquals("16", digits, "The card number has different digits than expected");    //checking if card number has 16 digits
        cart.fillPurchaserNameField(randomName);
        cart.expiryMonthFieldClick();
        cart.randomExpiryMonth();
        cart.randomExpiryYear();
        cart.submitButtonClick();
        Assertions.assertTrue(cart.isSuccessfullyAddedCardMessageVisible(), "Successfully added card message is not visible.");
        cart.creditCardCheckoxCheck();
        Assertions.assertTrue(cart.isCreditCardCheckboxSelected(), "Credit card checkbox is not selected.");
    }

    @Test
    public void finishPurchase() {
        page = new AfterLoginPage(driver);
        login = home.goToLoginPage();
        String myLogin = service.getCredentialValue("myLogin");
        String myPassword = service.getCredentialValue("myPassword");
        login.fillMyLoginField(myLogin);
        login.fillMyPasswordField(myPassword);
        home = login.loginButtonClick();
        Assertions.assertTrue(page.isCartButtonVisible(), "You are not logged!");
        page.chooseProductToAdd("Green Smoothie");
        cart = page.goToCartPage();
        Assertions.assertTrue(page.isTotalPriceFieldVisible());
        cart.checkoutButtonClick();
        cart.addNewAdress();
        String randomCountry = service.getRandomValue(service.countriesList());
        cart.fillCountryNameField(randomCountry);
        String randomName = service.getRandomValue(service.namesList());
        cart.fillNameField(randomName);
        cart.fillPhoneNumberField(service.cellPhoneNumber());
        cart.fillAddressField(service.getRandomValue(service.randomCities()));
        String zipCode = service.getRandomValue(service.randomzipCodes());
        cart.fillZipCodeField(zipCode);
        String city = service.getRandomValue(service.randomCities());
        cart.fillCityNameField(city);
        Assertions.assertTrue(cart.isSubmitButtonEnabled(), "Submit button is not enabled.");
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
        Assertions.assertEquals("16", digits, "The card number has different digits than expected");    //checking if card number has 16 digits
        cart.fillPurchaserNameField(randomName);
        cart.expiryMonthFieldClick();
        cart.randomExpiryMonth();
        cart.randomExpiryYear();
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
        page = new AfterLoginPage(driver);
        login = home.goToLoginPage();
        String myLogin = service.getCredentialValue("myLogin");
        String myPassword = service.getCredentialValue("myPassword");
        login.fillMyLoginField(myLogin);
        login.fillMyPasswordField(myPassword);
        home = login.loginButtonClick();
        Assertions.assertTrue(page.isCartButtonVisible(), "You are not logged!");
        page.chooseProductToAdd("Green Smoothie");
        cart = page.goToCartPage();
        Assertions.assertTrue(page.isTotalPriceFieldVisible(), "Total price is not visible.");
        cart.checkoutButtonClick();
        cart.addNewAdress();
        String randomCountry = service.getRandomValue(service.countriesList());
        cart.fillCountryNameField(randomCountry);
        String randomName = service.getRandomValue(service.namesList());
        cart.fillNameField(randomName);
        cart.fillPhoneNumberField(service.cellPhoneNumber());
        cart.fillAddressField(service.getRandomValue(service.randomCities()));
        String zipCode = service.getRandomValue(service.randomzipCodes());
        cart.fillZipCodeField(zipCode);
        String city = service.getRandomValue(service.randomCities());
        cart.fillCityNameField(city);
        Assertions.assertTrue(cart.isSubmitButtonEnabled(), "Submit button is not enabled.");
        cart.submitButtonClick();
        cart.selectAddressClick();
        Assertions.assertTrue(cart.isContinueButtonClickable(), "Continue button is not clickable.");
        cart.continueButtonClick();
        Assertions.assertTrue(cart.isDeliveryMessageVisible(), "Delivery Message is not visible.");
        cart.randomDeliveryOption();
        Assertions.assertTrue(cart.isContinueButtonClickable(), "Continue button is not clickable.");
        cart.continueButtonClick();
        cart.creditCardDropdownClick();
        cart.fillCardNumberField(service.cardNumber2());
        String digits = String.valueOf(service.cardNumber2().length());
        Assertions.assertNotEquals("16", digits, "Please enter a valid sixteen digit card number");    //checking if card number has 16 digits
        cart.fillPurchaserNameField(randomName);
        cart.expiryMonthFieldClick();
        cart.randomExpiryMonth();
        cart.randomExpiryYear();
        Assertions.assertEquals("Please enter a valid sixteen digit card number.", cart.invalidSixteenDigitCardNumber());
    }

    @Test
    public void isThePriceIsAppropriateAfterAddingProductToCart() {
        page = new AfterLoginPage(driver);
        login = home.goToLoginPage();
        String myLogin = service.getCredentialValue("myLogin");
        String myPassword = service.getCredentialValue("myPassword");
        login.fillMyLoginField(myLogin);
        login.fillMyPasswordField(myPassword);
        home = login.loginButtonClick();
        Assertions.assertTrue(page.isCartButtonVisible(), "You are not logged!");
        page.chooseProductToAdd("Green Smoothie");
        cart = page.goToCartPage();
        Assertions.assertTrue(cart.doesTotalPriceShowsProperPrice("1.99"), "Total Price is different than expected");
    }
}





