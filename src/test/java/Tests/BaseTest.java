package Tests;

import Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected Service service;
    protected WebDriver driver;
    protected HomePage home;

    @BeforeMethod
    public void beforeTest() {
        driver = new ChromeDriver();
        service = new Service(driver);
        System.setProperty(service.getDriver(), service.chromeDriverURL());
        driver.get(service.getURL());
        driver.manage().window().maximize();
        home = new HomePage(driver);
        home.closeWelcomeBanner();
    }
}
