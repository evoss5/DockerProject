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
        Assertions.assertTrue(home.isWelcomeBannerOkButtonVisible(), "Welcome message is still there");
        login = home.goToLoginPage();
        Assertions.assertEquals(login.urlLogin, driver.getCurrentUrl(), "The page is not login page");
        register = login.goToRegistrationPage();
        Assertions.assertTrue(register.isEmailFieldVisible(), "The page is not login page");
        String name = service.getRandomValue(service.namesList());
        String surname = service.getRandomValue((service.surnamesList()));
        String email = service.createEmailAddress(name, surname, service.randomNumber(), service.getRandomValue(service.eMailsDomenList()));
        register.insertEmail(email);
        String password = service.getRandomValue(service.randomPasswordList());
        service.createRandomPassword(password, service.randomNumber());
        register.insertPassword(password);
        register.insertRepeatPassword(password);
        register.clickSecurityQuestionField();
        register.fillAnswerForSecurityQuestion(name);
        register.clickRegister();
        Assertions.assertTrue(register.isRegistrationCompletedMessageVisible(), "Account has not been created");
    }

    @Test
    public void registerNewAccountByCredentials() {
        login = home.goToLoginPage();
        Assertions.assertEquals(login.urlLogin, driver.getCurrentUrl(), "The page is not login page");
        register = login.goToRegistrationPage();
        Assertions.assertTrue(register.isEmailFieldVisible(), "The page is not login page");
        register.insertEmail(service.getCredentialValue("myLogin"));
        register.insertPassword(service.getCredentialValue("myPassword"));
        register.insertRepeatPassword(service.getCredentialValue("myPassword"));
        register.clickSecurityQuestionField();
        register.fillAnswerForSecurityQuestion(Faker.instance().internet().domainName());
        register.clickRegister();
        Assertions.assertTrue(register.isRegistrationCompletedMessageVisible(), "Account has not been created");

        // TODO: 30.12.2023 Asercja!(zrobione)
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
        register.insertEmail(email);
        String password = service.getRandomValue(service.randomPasswordList());
        service.createRandomPassword(password, service.randomNumber());
        register.insertPassword(password);
        register.insertRepeatPassword(password);
        register.clickSecurityQuestionField();
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
        register.insertEmail(email);
        String password = service.getRandomValue(service.randomPasswordList());
        service.createRandomPassword(password, service.randomNumber());
        register.insertPassword(password);
        register.insertRepeatPassword(password);
        register.clickSecurityQuestionField();
        register.chooseSecurityQuestion("Mother");
        Assertions.assertTrue(register.isPasswordDoNotMatchMessageVisible());
        register.fillAnswerForSecurityQuestion(name);
        Assertions.assertTrue(register.isPasswordDoNotMatchMessageVisible(), "Passwords do not match!");
    }
}
// TODO: 25.12.2023 Usunać home z testów (zrobione)
// TODO: 30.12.2023 Dynamiczny xpath (zrobione)
