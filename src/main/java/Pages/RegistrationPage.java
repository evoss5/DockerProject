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
    private  WebElement repeatPasswordField;

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
        return new RegistrationPage(driver);
    }

    public RegistrationPage insertPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        wait.until(ExpectedConditions.elementToBeClickable(passwordField));
        passwordField.clear();
        passwordField.sendKeys(password);
        repeatPasswordField.clear();
        repeatPasswordField.sendKeys(password);
        return new RegistrationPage(driver);
    }

    public boolean checkIfPageShowsEmailField() {
        wait.until(ExpectedConditions.visibilityOf(emailField));
        return true;
    }

    public void clickSecurityQuestionField() {
        wait.until(ExpectedConditions.visibilityOf(securityQuestionField));
        securityQuestionField.click();
        wait.until(ExpectedConditions.visibilityOf(securityQuestionOption));
        securityQuestionOption.click();

    }

    public RegistrationPage setAnswerForSecurityQuestion(String name) {
        wait.until(ExpectedConditions.visibilityOf(answerForSecurityQuestion));
        answerForSecurityQuestion.clear();
        answerForSecurityQuestion.sendKeys(name);
        return new RegistrationPage(driver);
    }

    public void clickRegister() {
        wait.until(ExpectedConditions.visibilityOf(registerButton));
        registerButton.click();
    }

    public boolean checkIfAccountIsCreatedSucessfuly() {
        wait.until(ExpectedConditions.visibilityOf(registrationIsCompleteInfo));
        return true;
    }




}
