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

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void loginInByGoogle() {
        googleLoginButton.click();
    }

    public void loginInByStandardButton() {
        standardLoginButton.click();
    }

    public void inputLogin() {
        emailField.sendKeys("admin");
    }

    public void inputPassword() {
        passwordField.sendKeys("admin");
    }

    public void checkPassword() {
        showPassword.click();
    }

    public void returnToHomePageClick() {
        returnToHomePage.click();
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
        return new LoginPage(driver);
    }

    public LoginPage insertMyPassword(String myPassword) {
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        wait.until(ExpectedConditions.elementToBeClickable(passwordField));
        passwordField.clear();
        passwordField.sendKeys(myPassword);
        return new LoginPage(driver);
    }

    public HomePage goToHomePage() {
        wait.until(ExpectedConditions.visibilityOf(standardLoginButton));
        loginInByStandardButton();
        return new HomePage(driver);
    }
}

