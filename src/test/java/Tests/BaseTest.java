package Tests;

import Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected static Service service;
    protected static WebDriver driver;
    protected HomePage home;

    @BeforeMethod
    public void beforeTest() {
        driver = new ChromeDriver();
        service = new Service(driver);
        System.setProperty(service.getDriver(), service.chromeDriverURL());
        driver.get(service.getURL());
        driver.manage().window().maximize();
        home = new HomePage(driver);
        home.welcomeBannerOkButtonClick();
    }
//    @AfterMethod
//    public void afterTest(){
//        driver.close();
//        driver.quit();
    }

