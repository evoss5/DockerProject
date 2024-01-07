package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasicPage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    private static final int TIMEOUT = 5;

    public BasicPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, TIMEOUT);
        PageFactory.initElements(driver, this);
    }

    public void clickElement(WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();

    }

    public void sendKeysElement(WebElement webElement, String text) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.clear();
        webElement.sendKeys(text);
    }
}
// TODO: 30.12.2023 Metody mające coś wspólnego click, sendkeys itd.(zrobione)
//


