package Tests;

import Pages.LoginPage;
import Pages.RegistrationPage;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

public class Registration extends BaseTest {
    private LoginPage login;
    private RegistrationPage register;


    @Test
    public void registerNewAccount() {
        login = home.goToLoginPage();
        Assertions.assertEquals(login.urlLogin, driver.getCurrentUrl(), "The page is not login page");
        register = login.goToRegistrationPage();
        Assertions.assertTrue(register.isEmailFieldVisible(), "The page is not login page");
        String name = service.getRandomValue(service.namesList());
        String surname = service.getRandomValue((service.surnamesList()));
        String email = service.createEmailAddress(name, surname, service.randomNumber(), service.getRandomValue(service.eMailsDomenList()));
        String password = service.getRandomValue(service.randomPasswordList());
        service.createRandomPassword(password, service.randomNumber());
        register.registerAccount(email, password, "Your eldest siblings middle name?", "Evo");
        login = register.goToLoginPage();
        Assertions.assertTrue(register.isRegistrationCompletedMessageVisible(), "Account has not been created");


    }
@Test
    public void registerNewAccountByCredentials() {
        login = home.goToLoginPage();
        Assertions.assertEquals(login.urlLogin, driver.getCurrentUrl(), "The page is not login page");
        register = login.goToRegistrationPage();
        Assertions.assertTrue(register.isEmailFieldVisible(), "The page is not login page");
        register.registerAccount(service.getCredentialValue("myLogin"), service.getCredentialValue("myPassword"), "Your eldest siblings middle name?", "Evo");
        login = register.goToLoginPage();
        Assertions.assertTrue(register.isRegistrationCompletedMessageVisible(), "Account has not been created");

    }

    @Test
    public void unsuccessfulRegistrationBecauseOfNoDomen() {
        login = home.goToLoginPage();
        Assertions.assertEquals(login.urlLogin, driver.getCurrentUrl(), "The page is not login page");
        register = login.goToRegistrationPage();
        Assertions.assertTrue(register.isEmailFieldVisible(), "The page is not login page");
        String name = service.getRandomValue(service.namesList());
        String surname = service.getRandomValue((service.surnamesList()));
        String email = service.createEmailAddress(name, surname, service.randomNumber());
        register.fillEmailField(email);
        String password = service.getRandomValue(service.randomPasswordList());
        service.createRandomPassword(password, service.randomNumber());
        register.fillPasswordField(password);
        register.fillRepeatPasswordField(password);
        register.securityQuestionFieldClick();
        register.fillAnswerForSecurityQuestion(name);
        Assertions.assertTrue(register.isPasswordDoNotMatchMessageVisible(), "Email address is invalid");
    }

    @Test
    public void unsuccessfulRegistrationBecauseOfWrongRepeatedPassword() {
        Assertions.assertTrue(home.isWelcomeBannerOkButtonVisible(), "Welcome message is still there");
        login = home.goToLoginPage();
        Assertions.assertEquals(login.urlLogin, driver.getCurrentUrl(), "The page is not login page");
        register = login.goToRegistrationPage();
        Assertions.assertTrue(register.isEmailFieldVisible(), "The page is not login page");
        String name = service.getRandomValue(service.namesList());
        String surname = service.getRandomValue((service.surnamesList()));
        String email = service.createEmailAddress(name, surname, service.randomNumber(), service.getRandomValue(service.eMailsDomenList()));
        register.fillEmailField(email);
        String password = service.getRandomValue(service.randomPasswordList());
        service.createRandomPassword(password, service.randomNumber());
        register.fillPasswordField(password);
        register.fillRepeatPasswordField(password);
        register.securityQuestionFieldClick();
        register.securityQuestionChooseClick("Mother");
        Assertions.assertTrue(register.isPasswordDoNotMatchMessageVisible());
        register.fillAnswerForSecurityQuestion(name);
        Assertions.assertTrue(register.isPasswordDoNotMatchMessageVisible(), "Passwords do not match!");
    }
}
