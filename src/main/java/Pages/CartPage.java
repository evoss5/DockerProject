package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasicPage {
    @FindBy(xpath = "//button[contains(@class, 'checkout-button')]")
    private WebElement checkoutButton;
    @FindBy(xpath = "//span[text()='Add New Address']")
    private WebElement newAdressButton;
    @FindBy(xpath = "//input[@placeholder='Please provide a country.']")
    private WebElement countryField;
    @FindBy(xpath = "//input[@placeholder='Please provide a name.']")
    private WebElement nameField;


    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void clickCheckoutButton() {
        wait.until(ExpectedConditions.visibilityOf(checkoutButton));
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton));
        checkoutButton.click();
    }

    public void addNewAdress() {
        wait.until(ExpectedConditions.elementToBeClickable(newAdressButton));
        newAdressButton.click();
    }

    public void inputCountryName(String country) {
        wait.until(ExpectedConditions.elementToBeClickable(countryField));
        countryField.sendKeys(country);
        new CartPage(driver);
    }

    public void inputName(String name) {
        wait.until(ExpectedConditions.elementToBeClickable(nameField));
        nameField.sendKeys(name);
        new CartPage(driver);
    }
}
