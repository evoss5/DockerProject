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

    public void sideNavButtonClick() {
        wait.until(ExpectedConditions.visibilityOf(sideNavButton));
        wait.until(ExpectedConditions.elementToBeClickable(sideNavButton));
        sideNavButton.click();
    }

    public void clickMainLogoPage() {
        wait.until(ExpectedConditions.visibilityOf(mainPageLogo));
        wait.until(ExpectedConditions.elementToBeClickable(mainPageLogo));
        mainPageLogo.click();
    }

    public void clickSearchIcon() {
        wait.until(ExpectedConditions.visibilityOf(searchIcon));
        wait.until(ExpectedConditions.elementToBeClickable(searchIcon));
        searchIcon.click();
    }

    public void clickAccountIcon() {
        wait.until(ExpectedConditions.visibilityOf(accountIcon));
        wait.until(ExpectedConditions.elementToBeClickable(accountIcon));
        accountIcon.click();
    }

    public void clickLanguageSelectionMenu() {
        wait.until(ExpectedConditions.visibilityOf(languageSelectionMenu));
        wait.until(ExpectedConditions.elementToBeClickable(languageSelectionMenu));
        languageSelectionMenu.click();
    }

    public void clickDismissCookieMessage() {
        wait.until(ExpectedConditions.visibilityOf(dismissCookieMessage));
        wait.until(ExpectedConditions.elementToBeClickable(dismissCookieMessage));
        dismissCookieMessage.click();
    }

    public HomePage clickWelcomeBannerDismiss() {
        wait.until(ExpectedConditions.visibilityOf(welcomeBannerDismiss));
        wait.until(ExpectedConditions.elementToBeClickable(welcomeBannerDismiss));
        welcomeBannerDismiss.click();
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
        wait.until(ExpectedConditions.visibilityOf(gitHubRef));
        wait.until(ExpectedConditions.elementToBeClickable(gitHubRef));
        gitHubRef.click();
        return this;
    }

    public HomePage clickChangeLanguageToPolish() {
        wait.until(ExpectedConditions.visibilityOf(changeLanguageToPolish));
        wait.until(ExpectedConditions.elementToBeClickable(changeLanguageToPolish));
        changeLanguageToPolish.click();
        return this;
    }

    public HomePage clickLoginHomePage() {
        wait.until(ExpectedConditions.visibilityOf(loginHomePage));
        wait.until(ExpectedConditions.elementToBeClickable(loginHomePage));
        loginHomePage.click();
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



