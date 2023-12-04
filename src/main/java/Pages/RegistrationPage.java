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

    public boolean checkIfPageShowsEmailField() {
        wait.until(ExpectedConditions.visibilityOf(emailField));
        return true;
    }


}
