import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class Service {

    WebDriver driver;
    Service service;
    WebDriverWait webDriverWait;

    public Service(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getDriver() {
        return "C:/driver/chromedriver.exe";
    }

    public String getURL() {
        return "http://localhost:3000/";
    }
    public String getURL2() {
        return "http://localhost:3000/";
    }

    public String chromeDriverURL() {
        return "webdriver.chrome.driver";
    }

    @BeforeMethod
    public void beforeTest() {

        driver = new ChromeDriver();
        service = new Service(driver);
        System.setProperty(service.getDriver(), service.chromeDriverURL());
        driver.get(service.getURL());
        driver.manage().window().maximize();


    }
}
