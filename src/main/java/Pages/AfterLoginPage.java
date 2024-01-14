package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AfterLoginPage extends BasicPage {

    @FindBy(xpath = "//div[@id='price']")
    private WebElement totalPriceField;
    @FindBy(xpath = "//span[@class='fa-layers-counter fa-layers-top-right fa-3x warn-notification']")
    private WebElement cartButton;

    public AfterLoginPage(WebDriver driver) {
        super(driver);
    }

    public AfterLoginPage chooseProductToAdd(String product) {
        WebElement productName = driver.findElement(By.xpath("//button[@aria-label='Add to Basket']/../../div/div/img[@alt='" + product + "']/../../following-sibling::div/button"));
        clickElement(productName);
        return this;
    }

    public boolean isTotalPriceFieldVisible() {
        return isElementVisible(totalPriceField);
    }

    public CartPage goToCartPage() {
        clickElement(cartButton);
        return new CartPage(driver);
    }

    public boolean isCartButtonVisible() {
        return isElementVisible(cartButton);
    }
}
// TODO: 30.12.2023 Sprawdzić czy mogę zrobić reużywalną metodę (zrobione)
