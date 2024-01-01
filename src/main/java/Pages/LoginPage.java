package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasicPage {
    @FindBy(xpath = ".//button[@id='loginButtonGoogle']")
    private WebElement googleLoginButton;
    @FindBy(xpath = ".//button[@id='loginButton']")
    private WebElement standardLoginButton;
    @FindBy(xpath = ".//input[@id='email']")
    private WebElement emailField;
    @FindBy(xpath = ".//input[@id='password']")
    private WebElement passwordField;
    @FindBy(xpath = ".//*[@aria-label='Eye']")
    private WebElement showPassword;
    @FindBy(xpath = ".//button[@aria-label='Back to homepage']")
    private WebElement returnToHomePage;
    @FindBy(xpath = "//div[@id='newCustomerLink']")
    private WebElement createAccountButton;

    public final String urlLogin = "http://localhost:3000/#/login";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage loginInByGoogle() {
        clickElement(googleLoginButton);
        return this;
    }

    public LoginPage inputLogin() {
        sendKeysElement(emailField, "admin");
        return this;
    }

    public LoginPage inputPassword() {
        sendKeysElement(passwordField, "admin");
        return this;
    }

    public LoginPage checkPassword() {
        clickElement(showPassword);
        return this;
    }

    public LoginPage returnToHomePageClick() {
        clickElement(returnToHomePage);
        return this;
    }

    public RegistrationPage goToRegistrationPage() {
        clickElement(createAccountButton);
        return new RegistrationPage(driver);
    }

    public LoginPage insertMyLogin(String myEmail) {
        sendKeysElement(emailField, myEmail);
        return this;
    }

    public LoginPage insertMyPassword(String myPassword) {
        sendKeysElement(passwordField, myPassword);
        return this;
    }

    public HomePage goToHomePage() {
        clickElement(standardLoginButton);
        return new HomePage(driver);
    }
}

