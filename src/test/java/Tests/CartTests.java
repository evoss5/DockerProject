package Tests;

import Pages.AfterLoginPage;
import Pages.CartPage;
import Pages.HomePage;
import Pages.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.security.Provider;

public class CartTests extends BaseTest {

    LoginPage login;
    AfterLoginPage page;
    CartPage cart;

    @BeforeMethod
    public void logInByCredtentals() {
        home = new HomePage(driver);
        login = new LoginPage(driver);
        service = new Service(driver);
        login = home.goToLoginPage();
        String loginPage = "http://localhost:3000/#/login";
        Assertions.assertEquals(loginPage, driver.getCurrentUrl(), "The page is not login page");
        String myLogin = service.getCredentialValue("myLogin");
        String myPassword = service.getCredentialValue("myPassword");
        login.insertMyLogin(myLogin);
        login.insertMyPassword(myPassword);
        home = login.goToHomePage();
        Assertions.assertTrue(page.IsCartLayoutVisible(), "You are not logged!");
    }

    @Test
    public void addProductToCart() {
        home = new HomePage(driver);
        page = new AfterLoginPage(driver);
        page.addAppleJuiceToCart();
        cart = page.goToCartPage();
        Assertions.assertTrue(page.IsTotalPriceLayoutVisible());
        cart.clickCheckoutButton();
        cart.addNewAdress();
        String randomCountry = service.getRandomValue(service.countriesList());
        cart.inputCountryName(randomCountry);
        String randomName = service.getRandomValue(service.namesList());
        cart.inputName(randomName);
        cart.phoneNumber(service.cellPhoneNumber());
        cart.inputAdress(service.getRandomValue(service.randomCities()));
        String zipCode = service.getRandomValue(service.randomzipCodes());
        cart.inputZipCode(zipCode);
        String city = service.getRandomValue(service.randomCities());
        cart.inputCityName(city);
        Assertions.assertTrue(cart.isSubmitButtonEnabled());
        cart.submitButtonClick();
        cart.selectAdressClick();
    }

}


