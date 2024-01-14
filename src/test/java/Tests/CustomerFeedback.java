package Tests;

import Pages.AfterLoginPage;
import Pages.CartPage;
import Pages.CustomerFeedbackPage;
import Pages.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

public class CustomerFeedback extends BaseTest {
    private CustomerFeedbackPage customer;
    private AfterLoginPage page;
    private LoginPage login;
    private CartPage cart;


    @Test
    public void becomeADeluxeMember() {
        page = new AfterLoginPage(driver);
        login = home.goToLoginPage();
        String myLogin = service.getCredentialValue("myLogin");
        String myPassword = service.getCredentialValue("myPassword");
        login.insertMyLogin(myLogin);
        login.insertMyPassword(myPassword);
        home = login.clickLoginButton();
        Assertions.assertTrue(page.isCartButtonVisible(), "You are not logged!");
//        home.sideNavButtonClick();
        home.clickDeluxeMembershipButton();
        home.becomeAMemberButtonClick();
        cart = new CartPage(driver);
        cart.addCreditCard();
        cart.inputCardNumber(service.cardNumber());
        String digits = String.valueOf(service.cardNumber().length());
        Assertions.assertEquals("16", digits, "The card number has different digits than expected");
        String name = service.getRandomValue(service.namesList());
        cart.inputNameForDeluxeMembership(name);
        cart.randomExpiryMonthForDeluxeMembership("2");
        cart.expiryYearDropdown("2082");
        cart.submitButtonClick();
        cart.chooseCreditCard();
        cart.continueButtonClick();
        Assertions.assertTrue(home.isDeluxeMembershipButtonVisible(), "You are not Deluxe Member yet");
    }
    @Test
    public void checkIfYouAreDeluxeMemberAlready() {
        page = new AfterLoginPage(driver);
        login = home.goToLoginPage();
        String myLogin = service.getCredentialValue("myLogin");
        String myPassword = service.getCredentialValue("myPassword");
        login.insertMyLogin(myLogin);
        login.insertMyPassword(myPassword);
        home = login.clickLoginButton();
        Assertions.assertTrue(page.isCartButtonVisible(), "You are not logged!");
        home.sideNavButtonClick();
        home.clickDeluxeMembershipButton();
        Assertions.assertTrue(home.isDeluxeMembershipButtonVisible(), "You are not Deluxe Member yet!");
    }
    @Test
    public void choosingRateOnSliderForCustomerFeedback() throws InterruptedException {
        page = new AfterLoginPage(driver);
        login = home.goToLoginPage();
        String myLogin = service.getCredentialValue("myLogin");
        String myPassword = service.getCredentialValue("myPassword");
        login.insertMyLogin(myLogin);
        login.insertMyPassword(myPassword);
        home = login.clickLoginButton();
        Assertions.assertTrue(page.isCartButtonVisible(), "You are not logged!");
        customer = home.goToCustomerPage();
        customer.commentField("Hello!");
        int rating = 2;
        customer.chooseRating(rating);
        Assertions.assertEquals(String.valueOf(rating), customer.getRatingFromSliderBar(), "You haven't rated our page");
        // TODO: 05.01.2024 dokończyć (zrobione)
    }
}
