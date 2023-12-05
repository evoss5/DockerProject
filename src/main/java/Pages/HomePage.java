package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasicPage {




    @FindBy(xpath = "//*[@aria-label='Open Sidenav']")
    WebElement sideNavButton;

    @FindBy(xpath = ".//*[@aria-label='Back to homepage']")
    WebElement mainPageLogo;
    @FindBy(xpath = ".//span/mat-icon[2]")
    WebElement searchIcon;

    @FindBy(xpath = ".//*[@aria-label='Show/hide account menu']")
    WebElement accountIcon;

    @FindBy(xpath = ".//*[@aria-label='Language selection menu']")
    WebElement languageSelectionMenu;

    @FindBy(xpath = ".//a[@aria-label = 'dismiss cookie message']")
    WebElement dismissCookieMessage;

    @FindBy(xpath = ".//*[@aria-label=\"Close Welcome Banner\"]")

    WebElement welcomeBannerDismiss;

    @FindBy(xpath = ".//span[text()=' GitHub ']")
    WebElement gitHubRef;

    @FindBy(xpath = "//label//span//input[@aria-label=\"Język Polski\"]/ancestor::label")
    WebElement changeLanguageToPolish;

    @FindBy(xpath = "//label//span//input[@aria-label=\"Język Polski\"]/ancestor::label")
    WebElement changeLanguageToPolish2;


    @FindBy(xpath = ".//button[@id='navbarLoginButton']")
    WebElement loginHomePage;

    @FindBy(xpath = ".//span[text()=' Konto ']")
    WebElement checkIfLanguageisPolish;

    @FindBy(xpath = "//div[text()='Invalid email or password.']")
    WebElement invalidEmailOrPasswordInfo;
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@aria-label='Show the shopping cart']")
    private WebElement yourBasketAfterLogin;


    public void sideNavButtonClick() {
        wait.until(ExpectedConditions.visibilityOf(sideNavButton));
        sideNavButton.click();
    }

    public void clickMainLogoPage() {
        mainPageLogo.click();
    }

    public void clickSearchIcon() {
        searchIcon.click();
    }

    public void clickAccountIcon() {
        accountIcon.click();
    }

    public void clickLanguageSelectionMenu() {
        languageSelectionMenu.click();


    }

    public void clickDismissCookieMessage() {
        dismissCookieMessage.click();


    }

    public void clickWelcomeBannerDismiss() {
        welcomeBannerDismiss.click();
    }

    public void clickGitHub() {
        wait.until(ExpectedConditions.visibilityOf(gitHubRef));
        gitHubRef.click();
    }

    public void clickChangeLanguageToPolish() {
        wait.until(ExpectedConditions.visibilityOf(changeLanguageToPolish));
        changeLanguageToPolish.click();
    }

    public void clickLoginHomePage() {
        loginHomePage.click();
    }

    public boolean clickCheckIfLanguageIsPolish() {
        wait.until(ExpectedConditions.visibilityOf(checkIfLanguageisPolish));
        return true;


    }
    public boolean IsThereInfoAboutWrongLoginOrPassword(){
        wait.until(ExpectedConditions.visibilityOf(invalidEmailOrPasswordInfo));
        return true;

    }
    public boolean isWelcomeMessageDismissed() {
        return wait.until(ExpectedConditions.visibilityOf(welcomeBannerDismiss)).isDisplayed();

    }



    public LoginPage goToLoginPage(){
        clickAccountIcon();
        clickLoginHomePage();
        return new LoginPage(driver);
    }

    public boolean checkIfYouAreLoggedAndYouAreOnHomePage() {
        wait.until(ExpectedConditions.visibilityOf(yourBasketAfterLogin));
        return true;
    }



}






