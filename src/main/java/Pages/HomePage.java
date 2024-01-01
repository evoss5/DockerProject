package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasicPage {

    @FindBy(xpath = "//*[@aria-label='Open Sidenav']")
    private WebElement sideNavButton;
    @FindBy(xpath = ".//*[@aria-label='Back to homepage']")
    private WebElement mainPageLogo;
    @FindBy(xpath = ".//span/mat-icon[2]")
    private WebElement searchIcon;
    @FindBy(xpath = ".//*[@aria-label='Show/hide account menu']")
    private WebElement accountIcon;
    @FindBy(xpath = ".//*[@aria-label='Language selection menu']")
    private WebElement languageSelectionMenu;
    @FindBy(xpath = ".//a[@aria-label = 'dismiss cookie message']")
    private WebElement dismissCookieMessage;
    @FindBy(xpath = ".//*[@aria-label='Close Welcome Banner']")
    private WebElement welcomeBannerDismiss;
    @FindBy(xpath = ".//span[text()=' GitHub ']")
    private WebElement gitHubRef;
    @FindBy(xpath = "//label//span//input[@aria-label='Język Polski']/ancestor::label")
    private WebElement changeLanguageToPolish;
    @FindBy(xpath = "//label//span//input[@aria-label='Język Polski']/ancestor::label")
    private WebElement changeLanguageToPolish2;
    @FindBy(xpath = ".//button[@id='navbarLoginButton']")
    private WebElement loginHomePage;
    @FindBy(xpath = ".//span[text()=' Konto ']")
    private WebElement checkIfLanguageIsPolish;
    @FindBy(xpath = "//div[text()='Invalid email or password.']")
    private WebElement invalidEmailOrPasswordInfo;
    @FindBy(xpath = "//button[@aria-label='Show the shopping cart']")
    private WebElement yourBasketAfterLogin;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage sideNavButtonClick() {
        clickElement(sideNavButton);
        return this;
    }

    public HomePage clickMainLogoPage() {
        clickElement(mainPageLogo);
        return this;
    }

    public HomePage clickSearchIcon() {
       clickElement(searchIcon);
        return this;
    }

    public HomePage clickAccountIcon() {
        clickElement(accountIcon);
        return this;
    }

    public HomePage clickLanguageSelectionMenu() {
        clickElement(languageSelectionMenu);
        return this;
    }

    public HomePage clickDismissCookieMessage() {
        clickElement(dismissCookieMessage);
        return this;
    }

    public HomePage clickWelcomeBannerDismiss() {
        clickElement(welcomeBannerDismiss);
        return this;
    }
    public boolean isWelcomeBannerVisible() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(welcomeBannerDismiss)).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e){
            return false;
        }
    }

    public HomePage closeWelcomeBanner() {
        if (isWelcomeBannerVisible()) {
            clickWelcomeBannerDismiss();
        }
        return this;
    }

    public HomePage clickGitHub() {
        clickElement(gitHubRef);
        return this;
    }

    public HomePage clickChangeLanguageToPolish() {
        clickElement(changeLanguageToPolish);
        return this;
    }

    public HomePage clickLoginHomePage() {
        clickElement(loginHomePage);
        return this;
    }

    public boolean clickCheckIfLanguageIsPolish() {
        wait.until(ExpectedConditions.visibilityOf(checkIfLanguageIsPolish));
        return checkIfLanguageIsPolish.isDisplayed();
    }

    public boolean isThereInfoAboutWrongLoginOrPassword() {
        return wait.until(ExpectedConditions.visibilityOf(invalidEmailOrPasswordInfo)).isDisplayed();
    }

    public boolean isWelcomeMessageDismissed() {
        return wait.until(ExpectedConditions.visibilityOf(welcomeBannerDismiss)).isDisplayed();
    }

    public LoginPage goToLoginPage() {
        clickAccountIcon();
        clickLoginHomePage();
        return new LoginPage(driver);
    }

    public boolean checkIfYouAreLoggedAndYouAreOnHomePage() {
        return wait.until(ExpectedConditions.visibilityOf(yourBasketAfterLogin)).isDisplayed();
    }
}

// TODO: 30.12.2023 Zapoznać się z loggerem (maven)



