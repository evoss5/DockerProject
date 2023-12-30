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

    public void loginInByGoogle() {
        googleLoginButton.click();
    }

    public void loginInByStandardButton() {   //poprawić
        standardLoginButton.click();
    }

    public LoginPage inputLogin() {
        emailField.sendKeys("admin");
        return this;
    }

    public LoginPage inputPassword() {
        passwordField.sendKeys("admin");
        return this;
    }

    public LoginPage checkPassword() {
        showPassword.click();
        return this;
    }

    public LoginPage returnToHomePageClick() {
        returnToHomePage.click();
        return this;
    }

    public RegistrationPage goToRegistrationPage() {
        wait.until(ExpectedConditions.visibilityOf(createAccountButton));
        wait.until(ExpectedConditions.elementToBeClickable(createAccountButton));
        createAccountButton.click();
        return new RegistrationPage(driver);
    }

    public LoginPage insertMyLogin(String myEmail) {
        wait.until(ExpectedConditions.visibilityOf(emailField));
        wait.until(ExpectedConditions.elementToBeClickable(emailField));
        emailField.clear();
        emailField.sendKeys(myEmail);
        return this;
    }

    public LoginPage insertMyPassword(String myPassword) {
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        wait.until(ExpectedConditions.elementToBeClickable(passwordField));
        passwordField.clear();
        passwordField.sendKeys(myPassword);
        return this;
    }

    public HomePage goToHomePage() {
        wait.until(ExpectedConditions.visibilityOf(standardLoginButton));
        wait.until(ExpectedConditions.elementToBeClickable(standardLoginButton));
        loginInByStandardButton();
        return new HomePage(driver);
    }
}

