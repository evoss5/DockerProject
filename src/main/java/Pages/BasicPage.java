package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasicPage {
    protected WebDriver driver;
    protected WebDriverWait webDriverWait;
    private static final int TIMEOUT = 10;

    public BasicPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}

