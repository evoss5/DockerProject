package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationPage extends BasicPage {

    @FindBy(xpath = "//input[@id='emailControl']")
    private WebElement emailField;
    @FindBy(xpath = "//input[@id='passwordControl']")
    private WebElement passwordField;
    @FindBy(xpath = "//input[@id='repeatPasswordControl']")
    private WebElement repeatPasswordField;
    @FindBy(xpath = "//*[@id='mat-select-2']")
    private WebElement securityQuestionField;
    @FindBy(xpath = ".//*[@id=\'mat-option-9\']")
    private WebElement securityQuestionOption;
    @FindBy(xpath = "//input[@id='securityAnswerControl']")
    private WebElement answerForSecurityQuestion;
    @FindBy(xpath = "//button[@id='registerButton']")
    WebElement registerButton;
    @FindBy(xpath = "//*[text()='Registration completed successfully. You can now log in.']")
    private WebElement registrationIsCompleteInfo;

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public RegistrationPage insertEmail(String email) {
        wait.until(ExpectedConditions.visibilityOf(emailField));
        wait.until(ExpectedConditions.elementToBeClickable(emailField));
        emailField.clear();
        emailField.sendKeys(email);
        return this;
    }

    public RegistrationPage insertPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        wait.until(ExpectedConditions.elementToBeClickable(passwordField));
        passwordField.clear();
        passwordField.sendKeys(password);
        repeatPasswordField.clear();
        repeatPasswordField.sendKeys(password);
        return this;
    }

    public boolean checkIfPageShowsEmailField() {
        return wait.until(ExpectedConditions.visibilityOf(emailField)).isDisplayed();
    }

    public RegistrationPage clickSecurityQuestionField() {
        wait.until(ExpectedConditions.visibilityOf(securityQuestionField));
        securityQuestionField.click();
        wait.until(ExpectedConditions.visibilityOf(securityQuestionOption));
        securityQuestionOption.click();
        return this;

    }

    public RegistrationPage setAnswerForSecurityQuestion(String name) {
        wait.until(ExpectedConditions.visibilityOf(answerForSecurityQuestion));
        answerForSecurityQuestion.clear();
        answerForSecurityQuestion.sendKeys(name);
        return this;
    }

    public RegistrationPage clickRegister() {
        wait.until(ExpectedConditions.visibilityOf(registerButton));
        wait.until(ExpectedConditions.elementToBeClickable(registerButton));
        registerButton.click();
        return this;
    }

    public boolean checkIfAccountIsCreatedSucessfuly() {
        return wait.until(ExpectedConditions.visibilityOf(registrationIsCompleteInfo)).isDisplayed();
    }
    public boolean checkIfRegisterButtonIsEnabled() {
        wait.until(ExpectedConditions.visibilityOf(registerButton));
        return registerButton.isEnabled();
    }
}
