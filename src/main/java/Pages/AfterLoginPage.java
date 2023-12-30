package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AfterLoginPage extends BasicPage {
    @FindBy(xpath = "//img[@alt='Apple Juice (1000ml)']/../../following-sibling::div/button")
    private WebElement appleJuice;
    @FindBy(xpath = "//img[@alt='Melon Bike (Comeback-Product 2018 Edition)']/../../following-sibling::div/button")
    private WebElement melonBike;
    @FindBy(xpath = "//div[@id='price']")
    private WebElement totalPriceLayout;
    @FindBy(xpath = "//span[@class='fa-layers-counter fa-layers-top-right fa-3x warn-notification']")
    private WebElement cartLayout;
    public AfterLoginPage(WebDriver driver) {
        super(driver);
    }

    public AfterLoginPage addAppleJuiceToCart() {
        wait.until(ExpectedConditions.visibilityOf(appleJuice));
        wait.until(ExpectedConditions.elementToBeClickable(appleJuice));
        appleJuice.click();
        return this;
    }
    public boolean isTotalPriceLayoutVisible() {
        wait.until(ExpectedConditions.visibilityOf(totalPriceLayout));
        return totalPriceLayout.isDisplayed();
    }
    public CartPage goToCartPage() {
        wait.until(ExpectedConditions.visibilityOf(cartLayout));
        wait.until(ExpectedConditions.elementToBeClickable(cartLayout));
        cartLayout.click();
        return new CartPage(driver);
    }
    public boolean isCartLayoutVisible() {
         wait.until(ExpectedConditions.visibilityOf(cartLayout));
         return cartLayout.isDisplayed();
    }
}
// TODO: 30.12.2023 Sprawdzić czy mogę zrobić reużywalną metodę
