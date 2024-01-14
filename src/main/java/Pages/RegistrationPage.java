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

    public boolean isEmailFieldVisible() {
        return isElementVisible(emailField);
    }

    public RegistrationPage clickSecurityQuestionField() {
        wait.until(ExpectedConditions.visibilityOf(securityQuestionDropdownButton));
        securityQuestionDropdownButton.click();
        return this;
        // TODO: 14.01.2024 Oddzielna metoda i dynamiczny xpath
    }


    public RegistrationPage fillAnswerForSecurityQuestion(String answer) {
        sendKeysToElement(answerQuestionField, answer);
        return this;
    }

    public RegistrationPage clickRegister() {
        clickElement(registerButton);
        return this;
        // TODO: 14.01.2024 Przekierowanie do LoginPage
    }

    public boolean isRegistrationCompletedMessageVisible() {
        return isElementVisible(registrationCompletedMessage);
    }

    public boolean isPasswordDoNotMatchMessageVisible() {
        return isElementVisible(passwordDoNotMatchMessage);
    }

    public RegistrationPage chooseSecurityQuestion(String question) {
        WebElement option = driver.findElement(By.xpath("//div[@aria-label='Selection list for the security question']//span[contains(text(),'" + question + "')]"));
        clickElement(option);
        return this;
    }
}
