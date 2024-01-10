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
    private WebElement securityQuestionField;
    @FindBy(xpath = ".//*[@id='mat-option-9']")
    private WebElement securityQuestionOption;
    @FindBy(xpath = "//input[@id='securityAnswerControl']")
    private WebElement answerForSecurityQuestion;
    @FindBy(xpath = "//button[@id='registerButton']")
    private WebElement registerButton;
    @FindBy(xpath = "//*[text()='Registration completed successfully. You can now log in.']")
    private WebElement registrationIsCompleteInfo;
    @FindBy(xpath = "//mat-error[@id='mat-error-10']")
    private WebElement passwordDoNotMatchMessage;
    @FindBy(xpath = "//mat-error[@id='mat-error-7']")
    private WebElement emailAddressIsNotValidText;
    @FindBy(xpath = "//mat-error[@id='mat-error-10']")
    private WebElement passwordsDoNotMatchText;
    @FindBy(xpath = "//mat-select[@aria-label='Selection list for the security question']/div/div/span/span[contains(text(),'Mother')]")
    private WebElement optionForSecurityQuestion;

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public RegistrationPage insertEmail(String email) {
        sendKeysToElement(emailField, email);
        return this;
    }

    public RegistrationPage insertPassword(String password) {
        sendKeysToElement(passwordField, password);
        return this;
    }

    public RegistrationPage insertRepeatPassword(String password) {
        sendKeysToElement(repeatPasswordField, password);
        return this;
    }

    public boolean checkIfPageShowsEmailField() {
        return isElementVisible(emailField);
    }

    public RegistrationPage clickSecurityQuestionField() {   //oddzielna metoda + dynamiczny xpath
        wait.until(ExpectedConditions.visibilityOf(securityQuestionField));
        securityQuestionField.click();
        return this;
    }

    public RegistrationPage chooseSecurityOption() {
        wait.until(ExpectedConditions.visibilityOf(securityQuestionOption));
        securityQuestionOption.click();
        return this;
    }

    public RegistrationPage setAnswerForSecurityQuestion(String name) {
        sendKeysToElement(answerForSecurityQuestion, name);
        return this;
    }

    public RegistrationPage clickRegister() {
        clickElement(registerButton);
        return this;
    }

    public boolean checkIfAccountIsCreatedSucessfuly() {
        return isElementVisible(registrationIsCompleteInfo);
    }

    public boolean checkIfRegisterButtonIsEnabled() {
        wait.until(ExpectedConditions.visibilityOf(registerButton));
        return registerButton.isEnabled();
    }

    public boolean checkIfThereIsPasswordNoMatchMessage() {
        return isElementVisible(passwordDoNotMatchMessage);
    }

    public boolean checkIfEmailAddressIsValid() {
        return isElementVisible(passwordDoNotMatchMessage);
    }

    public boolean checkIfThereIsMessageAboutPasswordsNotMatching() {
        return isElementVisible(passwordDoNotMatchMessage);
    }

    public void chooseSecurityQuestion(String question) {
        WebElement optionForSecurityQuestion = driver.findElement(By.xpath("//div[@aria-label='Selection list for the security question']//span[contains(text(),'" + question + "')]"));
        clickElement(optionForSecurityQuestion);
    }
}
