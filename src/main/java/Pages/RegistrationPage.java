package Pages;

import org.openqa.selenium.By;
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
    private WebElement securityQuestionDropdownButton;
    @FindBy(xpath = "//input[@id='securityAnswerControl']")
    private WebElement answerQuestionField;
    @FindBy(xpath = "//button[@id='registerButton']")
    private WebElement registerButton;
    @FindBy(xpath = "//*[text()='Registration completed successfully. You can now log in.']")
    private WebElement registrationCompletedMessage;
    @FindBy(xpath = "//mat-error[@id='mat-error-10']")
    private WebElement passwordDoNotMatchMessage;


    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public RegistrationPage fillEmailField(String email) {
        sendKeysToElement(emailField, email);
        return this;
    }

    public RegistrationPage fillPasswordField(String password) {
        sendKeysToElement(passwordField, password);
        return this;
    }

    public RegistrationPage fillRepeatPasswordField(String password) {
        sendKeysToElement(repeatPasswordField, password);
        return this;
    }

    public boolean isEmailFieldVisible() {
        return isElementVisible(emailField);
    }

    public RegistrationPage securityQuestionFieldClick() {
        wait.until(ExpectedConditions.visibilityOf(securityQuestionDropdownButton));
        securityQuestionDropdownButton.click();
        return this;
    }


    public RegistrationPage fillAnswerForSecurityQuestion(String answer) {
        sendKeysToElement(answerQuestionField, answer);
        return this;
    }

    public LoginPage goToLoginPage() {
        clickElement(registerButton);
        return new LoginPage(driver);
    }

    public boolean isRegistrationCompletedMessageVisible() {
        return isElementVisible(registrationCompletedMessage);
    }

    public boolean isPasswordDoNotMatchMessageVisible() {
        return isElementVisible(passwordDoNotMatchMessage);
    }

    public RegistrationPage securityQuestionChooseClick(String question) {
        WebElement option = driver.findElement(By.xpath("//div[@aria-label='Selection list for the security question']//span[contains(text(),'" + question + "')]"));
        clickElement(option);
        return this;
    }
}
