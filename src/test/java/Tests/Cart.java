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
        Assertions.assertTrue(cart.isSubmitButtonEnabled());
        cart.submitButtonClick();
        cart.selectAddressClick();
        Assertions.assertTrue(cart.isAddressRadioButtonSelected());
    }

    // TODO: 30.12.2023 Dodać message do Assertów
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
        Assertions.assertTrue(cart.isSubmitButtonEnabled());
        cart.submitButtonClick();
        cart.selectAddressClick();
        Assertions.assertTrue(cart.isContinueButtonClickable());
        cart.continueButtonClick();
        Assertions.assertTrue(cart.isDeliveryMessageVisible());
        cart.randomDeliveryOption();
        Assertions.assertTrue(cart.isDeliveryOptionSelected(), "You haven't choose delivery option!");
        Assertions.assertTrue(cart.isContinueButtonClickable(), "Continue button is not clickable");
        // TODO: 30.12.2023 Zrobić asercję z selected (zrobione)
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
        Assertions.assertTrue(cart.isSubmitButtonEnabled());
        cart.submitButtonClick();
        cart.selectAddressClick();
        Assertions.assertTrue(cart.isContinueButtonClickable());
        cart.continueButtonClick();
        Assertions.assertTrue(cart.isDeliveryMessageVisible());
        cart.randomDeliveryOption();
        Assertions.assertTrue(cart.isContinueButtonClickable());
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
        Assertions.assertTrue(cart.isSuccessfullyAddedCardMessageVisible());
//        cart.randomName();
        // TODO: 30.12.2023 Asercja, że nowy numer karty widnieje na danej liście.
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
        Assertions.assertTrue(cart.isSubmitButtonEnabled());
        cart.submitButtonClick();
        cart.selectAddressClick();
        Assertions.assertTrue(cart.isContinueButtonClickable());
        cart.continueButtonClick();
        Assertions.assertTrue(cart.isDeliveryMessageVisible());
        cart.randomDeliveryOption();
        Assertions.assertTrue(cart.isContinueButtonClickable());
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
        Assertions.assertTrue(cart.isSuccessfullyAddedCardMessageVisible());
        cart.creditCardCheckoxCheck();
        Assertions.assertTrue(cart.isCreditCardCheckboxSelected());
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
        Assertions.assertTrue(cart.isSubmitButtonEnabled());
        cart.submitButtonClick();
        cart.selectAddressClick();
        Assertions.assertTrue(cart.isContinueButtonClickable());
        cart.continueButtonClick();
        Assertions.assertTrue(cart.isDeliveryMessageVisible());
        cart.randomDeliveryOption();
        Assertions.assertTrue(cart.isContinueButtonClickable());
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
        Assertions.assertTrue(cart.isSuccessfullyAddedCardMessageVisible());
        cart.creditCardCheckoxCheck();
        Assertions.assertTrue(cart.isCreditCardCheckboxSelected());
        cart.continueButtonClick();
        Assertions.assertTrue(cart.isOrderSummaryVisible());
        cart.purchaseProductsButtonClick();
        Assertions.assertTrue(cart.checkIfConfirmationMessageIsVisible());
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
        Assertions.assertTrue(cart.isSubmitButtonEnabled());
        cart.submitButtonClick();
        cart.selectAddressClick();
        Assertions.assertTrue(cart.isContinueButtonClickable());
        cart.continueButtonClick();
        Assertions.assertTrue(cart.isDeliveryMessageVisible());
        cart.randomDeliveryOption();
        Assertions.assertTrue(cart.isContinueButtonClickable());
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
    }// TODO: 30.12.2023 zrobić asercję z tekstem (zrobione)

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
// TODO: 08.01.2024 Odpalać testy przez TestNG




