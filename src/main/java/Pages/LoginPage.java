package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasicPage {
    @FindBy(xpath = ".//button[@id='loginButton']")
    private WebElement loginButton;
    @FindBy(xpath = ".//input[@id='email']")
    private WebElement emailField;
    @FindBy(xpath = ".//input[@id='password']")
    private WebElement passwordField;
    @FindBy(xpath = ".//*[@aria-label='Eye']")
    private WebElement showPasswordButton;
    @FindBy(xpath = "//div[@id='newCustomerLink']")
    private WebElement createAccountButton;
    @FindBy(xpath = "//mat-error[@id='mat-error-1']")
    private WebElement pleaseProvidePasswordMessage;
    @FindBy(xpath = "//mat-checkbox[@id='rememberMe']/label")
    private WebElement rememberMeCheckbox;
    @FindBy(xpath = "//input[@aria-checked='true']")
    private WebElement rememberMeCheckboxTicked;
    // TODO: 14.01.2024 Zrobić metodę checked w BasiccPage
    @FindBy(xpath = "//span[text()=' Your Basket']")
    private WebElement yourBasketText;
    // TODO: 14.01.2024 Przenieść basketHEADER to innego paga i nazwać webelement "allProductHeader" !

    public final String urlLogin = "http://localhost:3000/#/login";

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public LoginPage inputLogin(String login) {
        sendKeysToElement(emailField, login);
        return this;
        // TODO: 14.01.2024 Do zweryfikowania czy potrzbna metoda i nie powiela się

    }

    public LoginPage inputPassword(String password) {
        sendKeysToElement(passwordField, password);
        return this;
    }// TODO: 08.01.2024 poprawić zmienną !

    public LoginPage clickShowHidePasswordButton() {
        clickElement(showPasswordButton);
        return this;
    }

    public RegistrationPage goToRegistrationPage() {
        clickElement(createAccountButton);
        return new RegistrationPage(driver);
    }

    public LoginPage insertMyLogin(String myEmail) {
        sendKeysToElement(emailField, myEmail);
        return this;
    }

    public LoginPage insertMyPassword(String myPassword) {
        sendKeysToElement(passwordField, myPassword);
        return this;
    }

    public HomePage clickLoginButton() {
        clickElement(loginButton);
        return new HomePage(driver);
    }

    public boolean isProvidePasswordMessageVisible() {
        return isElementVisible(pleaseProvidePasswordMessage);
    }

    public LoginPage rememberMeCheckboxCheck() {
        clickElement(rememberMeCheckbox);
        return this;
    }

    public boolean isTheRememberMeCheckoxChecked() {
        return isElementVisible(rememberMeCheckboxTicked);
    }

    // TODO: 14.01.2024 Zrobić metodę ktora zaznacza checkboxa i odznacza, oraz wyciągnać atrybut aria checked

    public String passwordMessageText() {
        return pleaseProvidePasswordMessage.getText();
        // TODO: 08.01.2024 zrobić metodę w basicpagu na gettext oraz try catch
    }

    public boolean isLanguageChanged() {
        return isElementVisible(yourBasketText);
    }
    // TODO: 14.01.2024 przykład isAllProductsVisible i wrzucić do klasy enum + dynamiczny xpath

}

