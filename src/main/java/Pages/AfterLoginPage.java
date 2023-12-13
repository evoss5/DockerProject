package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AfterLoginPage extends BasicPage {
    @FindBy(xpath = "//img[@alt='Apple Juice (1000ml)']/../../following-sibling::div/button")
    WebElement AppleJuice;
    @FindBy(xpath = "//img[@alt='Melon Bike (Comeback-Product 2018 Edition)']/../../following-sibling::div/button")
    WebElement MelonBike;
    @FindBy(xpath = "//div[@id='price']")
    WebElement totalPriceLayout;
    @FindBy(xpath = "//span[text()=' Your Basket']")
    WebElement cartLayout;
    public AfterLoginPage(WebDriver driver) {
        super(driver);
    }

    public void addAppleJuiceToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(AppleJuice));
        AppleJuice.click();
    }
    public boolean IsTotalPriceLayoutVisible() {
        wait.until(ExpectedConditions.visibilityOf(totalPriceLayout));
        totalPriceLayout.isDisplayed();
        return true;

    }
    public CartPage goToCartPage() {
        wait.until(ExpectedConditions.visibilityOf(cartLayout));
        cartLayout.click();
        return new CartPage(driver);
    }
}
