package Tests;

import Pages.AfterLoginPage;
import Pages.CartPage;
import Pages.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
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
        Assertions.assertTrue(cart.isAddressRadioButtonSelected());
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
        cart.continueButtonClick();
        Assertions.assertTrue(cart.isDeliveryMessageVisible());
        cart.randomDeliveryOption();
        Assertions.assertTrue(cart.isDeliveryOptionSelected(), "You haven't choose delivery option!");
        Assertions.assertTrue(cart.isContinueButtonClickable(), "Continue button is not clickable");
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
    public void choosingPaymentOption() {
        page = new AfterLoginPage(driver);
        login = home.goToLoginPage();
        String myLogin = service.getCredentialValue("myLogin");
        String myPassword = service.getCredentialValue("myPassword");
        login.insertMyLogin(myLogin);
        login.insertMyPassword(myPassword);
        home = login.goToHomePage();
        Assertions.assertTrue(page.isCartLayoutVisible(), "You are not logged!");
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
        cart.chooseCreditCard();
        Assertions.assertTrue(cart.checkIfTheCardIsSelected());
    }

    @Test
    public void finishPurchase() {
        page = new AfterLoginPage(driver);
        login = home.goToLoginPage();
        String myLogin = service.getCredentialValue("myLogin");
        String myPassword = service.getCredentialValue("myPassword");
        login.insertMyLogin(myLogin);
        login.insertMyPassword(myPassword);
        home = login.goToHomePage();
        Assertions.assertTrue(page.isCartLayoutVisible(), "You are not logged!");
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
        cart.chooseCreditCard();
        Assertions.assertTrue(cart.checkIfTheCardIsSelected());
        cart.continueButtonClick();
        Assertions.assertTrue(cart.isOrderSummaryVisible());
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
        Assertions.assertTrue(cart.invalidSixteenDigitCardNumber(), "Please enter a valid sixteen digit card number!");
    }// TODO: 30.12.2023 zrobić asercję z tekstem

    @Test
    public void isThePriceIsAppropriateAfterAddingProductToCart() {
        page = new AfterLoginPage(driver);
        login = home.goToLoginPage();
        String myLogin = service.getCredentialValue("myLogin");
        String myPassword = service.getCredentialValue("myPassword");
        login.insertMyLogin(myLogin);
        login.insertMyPassword(myPassword);
        home = login.goToHomePage();
        Assertions.assertTrue(page.isCartLayoutVisible(), "You are not logged!");
        page.chooseProductToAdd("Green Smoothie");
        cart = page.goToCartPage();
        Assertions.assertTrue(cart.doesTotalPriceShowsProperPrice("1.99"), "Total Price is different than expected");
    }

    @Test
    public void checkIfYouAreDeluxeMemberAlready() {
        page = new AfterLoginPage(driver);
        login = home.goToLoginPage();
        String myLogin = service.getCredentialValue("myLogin");
        String myPassword = service.getCredentialValue("myPassword");
        login.insertMyLogin(myLogin);
        login.insertMyPassword(myPassword);
        home = login.goToHomePage();
        Assertions.assertTrue(page.isCartLayoutVisible(), "You are not logged!");
        home.sideNavButtonClick();
        home.deluxeMembershipButtonClick();
        Assertions.assertTrue(home.isDeluxeMembershipAlreadyPurchased(), "You are not Deluxe Member yet!");
    }

    @Test
    public void becomeADeluxeMember() {
        page = new AfterLoginPage(driver);
        login = home.goToLoginPage();
        String myLogin = service.getCredentialValue("myLogin");
        String myPassword = service.getCredentialValue("myPassword");
        login.insertMyLogin(myLogin);
        login.insertMyPassword(myPassword);
        home = login.goToHomePage();
        Assertions.assertTrue(page.isCartLayoutVisible(), "You are not logged!");
        home.sideNavButtonClick();
        home.deluxeMembershipButtonClick();
        home.becomeAMemberButtonClick();
        cart = new CartPage(driver);
        cart.addCreditCard();
        cart.inputCardNumber(service.cardNumber());
        String digits = String.valueOf(service.cardNumber().length());
        Assertions.assertEquals("16", digits, "The card number has different digits than expected");
        String name = service.getRandomValue(service.namesList());
        cart.inputNameForDeluxeMembership(name);
        cart.randomItem();
        cart.randomExpiryYear();
        cart.submitButtonClick();
        cart.chooseCreditCard();
        cart.continueButtonClick();
        Assertions.assertTrue(home.isDeluxeMembershipAlreadyPurchased(), "You are not Deluxe Member yet");
    }

    @Test
    public void choosingRateOnSliderForCustomerFeedback() {
        page = new AfterLoginPage(driver);
        login = home.goToLoginPage();
        String myLogin = service.getCredentialValue("myLogin");
        String myPassword = service.getCredentialValue("myPassword");
        login.insertMyLogin(myLogin);
        login.insertMyPassword(myPassword);
        home = login.goToHomePage();
        Assertions.assertTrue(page.isCartLayoutVisible(), "You are not logged!");
        home.sideNavButtonClick();
        home.customerFeedbackButtonClick();
        home.clickignggg();
        home.chooseSliderRating(4);
        // TODO: 05.01.2024 dokończyć
       String sss =  driver.findElement(By.xpath("")).getText();
    }

}
// TODO: 08.01.2024 Odpalać testy przez TestNG




