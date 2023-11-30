package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasicPage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }






    @FindBy(xpath = ".//button[@id='loginButtonGoogle']")
    WebElement googleLoginButton;

    @FindBy(xpath = ".//button[@id='loginButton']")
    WebElement standardLoginButton;

    @FindBy(xpath = ".//input[@id='email']")
    WebElement emailField;

    @FindBy(xpath = ".//input[@id='password']")
    WebElement passwordField;

    @FindBy(xpath = ".//*[@aria-label='Eye']")
    WebElement showPassword;

    @FindBy(xpath = ".//button[@aria-label='Back to homepage']")
    WebElement returnToHomePage;


    public void loginInByGoogle(){
        googleLoginButton.click();
    }
    public void loginInByStandardButton() {
        standardLoginButton.click();
    }

    public void inputLogin() {
        emailField.sendKeys("admin");
    }
    public void inputPassword() {
        passwordField.sendKeys("admin");
    }
    public void checkPassword() {
        showPassword.click();
    }
    public void returnToHomePageClick() {
        returnToHomePage.click();
    }


}

