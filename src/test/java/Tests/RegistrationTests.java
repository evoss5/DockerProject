package Tests;

import Pages.GooglePage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.RegistrationPage;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

public class RegistrationTests extends BaseTest {
    LoginPage login;
    GooglePage googlePage;
    RegistrationPage register;

    @Test
    public void registerNewAccount() {
        home = new HomePage(driver);
        login = new LoginPage(driver);
        service = new Service(driver);
        googlePage = new GooglePage(driver);
        home.clickWelcomeBannerDismiss();
        Assertions.assertTrue(home.isWelcomeMessageDismissed(), "Welcome message is still there");
        login = home.goToLoginPage();
        String loginPage = "http://localhost:3000/#/login";
        Assertions.assertEquals(loginPage, driver.getCurrentUrl(), "The page is not login page");
        register = login.goToRegistrationPage();
        Assertions.assertTrue(register.checkIfPageShowsEmailField(), "The page is not login page");
        String name = service.getRandomValue(service.namesList());
        String surname = service.getRandomValue((service.surnamesList()));
        String email = service.createEmailAddress(name, surname, service.randomNumber(), service.getRandomValue(service.eMailsDomenList()));
        register.insertEmail(email);
        String password = service.getRandomValue(service.randomPasswordList());
        service.createRandomPassword(password, service.randomNumber());
        register.insertPassword(password);
        register.clickSecurityQuestionField();
        String name2 = service.getRandomValue(service.namesList());
        register.setAnswerForSecurityQuestion(name2);
        register.clickRegister();
        Assertions.assertTrue(register.checkIfAccountIsCreatedSucessfuly(), "Account has not been created");
    }

    @Test
    public void registerNewAccountByCredentials() {
        home = new HomePage(driver);
        login = new LoginPage(driver);
        service = new Service(driver);
        googlePage = new GooglePage(driver);
        home.clickWelcomeBannerDismiss();
        Assertions.assertTrue(home.isWelcomeMessageDismissed(), "Welcome message is still there");
        login = home.goToLoginPage();
        String loginPage = "http://localhost:3000/#/login";
        Assertions.assertEquals(loginPage, driver.getCurrentUrl(), "The page is not login page");
        register = login.goToRegistrationPage();
        Assertions.assertTrue(register.checkIfPageShowsEmailField(), "The page is not login page");
        register.insertEmail(service.getCredentialValue("myLogin"));
        register.insertPassword(service.getCredentialValue("myPassword"));
        register.clickSecurityQuestionField();
        register.setAnswerForSecurityQuestion(Faker.instance().internet().domainName());
        register.clickRegister();
    }
}
