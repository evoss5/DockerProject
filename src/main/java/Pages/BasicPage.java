package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasicPage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    private static final int TIMEOUT = 5;
    public BasicPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, TIMEOUT);
        PageFactory.initElements(driver, this);
    }
    public void clickElement(WebElement webElement){

    }
    // TODO: 30.12.2023 Metody mające coś wspólnego click, sendkeys itd.
    //
    }

