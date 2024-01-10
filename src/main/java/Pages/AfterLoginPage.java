package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AfterLoginPage extends BasicPage {

    @FindBy(xpath = "//button[@aria-label='Add to Basket']")
    private WebElement addToBasketButton;
    @FindBy(xpath = "//div[@id='price']")
    private WebElement totalPriceField;
    @FindBy(xpath = "//span[@class='fa-layers-counter fa-layers-top-right fa-3x warn-notification']")
    private WebElement cartButton;
    public AfterLoginPage(WebDriver driver) {
        super(driver);
    }

    public AfterLoginPage chooseProductToAdd(String product) {
       WebElement element = driver.findElement(By.xpath("//button[@aria-label='Add to Basket']/../../div/div/img[@alt='"+ product +"']/../../following-sibling::div/button"));
       element.click();
       return this;
    }
    public boolean isTotalPriceLayoutVisible() {
        return isElementVisible(totalPriceField);
    }
    public CartPage goToCartPage() {
        clickElement(cartButton);
        return new CartPage(driver);
    }
    public boolean isCartLayoutVisible() {
         return isElementVisible(cartButton);
    }
}
// TODO: 30.12.2023 Sprawdzić czy mogę zrobić reużywalną metodę (zrobione)
