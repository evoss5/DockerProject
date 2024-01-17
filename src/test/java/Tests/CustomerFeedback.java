package Tests;

import Pages.CartPage;
import Pages.CustomerFeedbackPage;
import Pages.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

public class CustomerFeedback extends BaseTest {
    private CustomerFeedbackPage customer;
    private LoginPage login;
    private CartPage cart;


    @Test
    public void becomeADeluxeMember() {
        login = home.goToLoginPage();
        String myLogin = service.getCredentialValue("myLogin");
        String myPassword = service.getCredentialValue("myPassword");
        login.fillMyLoginField(myLogin);
        login.fillMyPasswordField(myPassword);
        home = login.loginButtonClick();
        Assertions.assertTrue(home.isCartButtonVisible(), "You are not logged!");
//        home.sideNavButtonClick();
        home.deluxeMembershipButtonClick();
        home.becomeAMemberButtonClick();
        cart = new CartPage(driver);
        cart.creditCardDropdownClick();
        cart.fillCardNumberField(service.cardNumber());
        String digits = String.valueOf(service.cardNumber().length());
        Assertions.assertEquals("16", digits, "The card number has different digits than expected");
        String name = service.getRandomValue(service.namesList());
        cart.fillNameForDeluxeMembershipField(name);
        cart.randomExpiryMonthForDeluxeMembership("2");
        cart.expiryYearDropdownSelect("2082");
        cart.submitButtonClick();
        cart.creditCardCheckoxCheck();
        cart.continueButtonClick();
        Assertions.assertTrue(home.isDeluxeMembershipButtonVisible(), "You are not Deluxe Member yet");
    }
    @Test
    public void checkIfYouAreDeluxeMemberAlready() {
        login = home.goToLoginPage();
        String myLogin = service.getCredentialValue("myLogin");
        String myPassword = service.getCredentialValue("myPassword");
        login.fillMyLoginField(myLogin);
        login.fillMyPasswordField(myPassword);
        home = login.loginButtonClick();
        Assertions.assertTrue(home.isCartButtonVisible(), "You are not logged!");
        home.sideNavButtonClick();
        home.deluxeMembershipButtonClick();
        Assertions.assertTrue(home.isDeluxeMembershipButtonVisible(), "You are not Deluxe Member yet!");
    }
    @Test
    public void choosingRateOnSliderForCustomerFeedback() throws InterruptedException {
        login = home.goToLoginPage();
        String myLogin = service.getCredentialValue("myLogin");
        String myPassword = service.getCredentialValue("myPassword");
        login.fillMyLoginField(myLogin);
        login.fillMyPasswordField(myPassword);
        home = login.loginButtonClick();
        Assertions.assertTrue(home.isCartButtonVisible(), "You are not logged!");
        customer = home.goToCustomerPage();
        customer.fillCommentField("Hello!");
        int rating = 2;
        customer.chooseRating(rating);
        Assertions.assertEquals(String.valueOf(rating), customer.getRatingFromSliderBar(), "You haven't rated our page");
    }
}
