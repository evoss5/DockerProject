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
    @FindBy(xpath = "//mat-error[@id='mat-error-1']")
    private WebElement pleaseProvideAPasswordMessage;
    @FindBy(xpath = "//mat-checkbox[@id='rememberMe']/label")
    private WebElement rememberMeCheckbox;
    @FindBy(xpath = "//input[@aria-checked='true']")
    private WebElement rememberMeCheckboxTicked;

    public final String urlLogin = "http://localhost:3000/#/login";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage loginInByGoogle() {
        clickElement(googleLoginButton);
        return this;
    }

    public LoginPage inputLogin(String login) {
        sendKeysToElement(emailField, login);
        return this;
    }

    public LoginPage inputPassword(String passwsord) {
        sendKeysToElement(passwordField, passwsord);
        return this;
    }// TODO: 08.01.2024 poprawić zmienną !

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
        sendKeysToElement(emailField, myEmail);
        return this;
    }

    public LoginPage insertMyPassword(String myPassword) {
        sendKeysToElement(passwordField, myPassword);
        return this;
    }

    public HomePage goToHomePage() {
        clickElement(standardLoginButton);
        return new HomePage(driver);
    }
    public LoginPage passwordFieldClick() {
        clickElement(passwordField);
        return this;
    }
    public LoginPage logInButtonClick() {
        wait.until(ExpectedConditions.visibilityOf(standardLoginButton)).click();
        return this;
    }
    public boolean isThereNoPasswordInsert() {
        return isElementVisible(pleaseProvideAPasswordMessage);
    }
    public LoginPage rememberMeCheckboxClick() {
        clickElement(rememberMeCheckbox);
        return this;
    }
    public boolean isTheRememberMeCheckoxTicked() {
        return isElementVisible(rememberMeCheckboxTicked);
    }
    public String passwordMessageText() {
        return pleaseProvideAPasswordMessage.getText();
        // TODO: 08.01.2024 zrobić metodę w basicpagu na gettext oraz try catch
    }
}

