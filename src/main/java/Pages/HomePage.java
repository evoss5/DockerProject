package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
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
    private WebElement cookieMessage;
    @FindBy(xpath = ".//*[@aria-label='Close Welcome Banner']")
    private WebElement welcomeBannerDismiss;
    @FindBy(xpath = ".//span[text()=' GitHub ']")
    private WebElement gitHubRef;
    @FindBy(xpath = "//label//span//input[@aria-label='Język Polski']/ancestor::label")  // TODO: 08.01.2024 Zrobić dynamiczny xpath na zmianę języka
    private WebElement changeLanguageToPolish;
    @FindBy(xpath = ".//button[@id='navbarLoginButton']")
    private WebElement loginHomePage;
    @FindBy(xpath = ".//span[text()=' Konto ']")
    private WebElement checkIfLanguageIsPolish;
    @FindBy(xpath = "//div[text()='Invalid email or password.']")
    private WebElement invalidEmailOrPasswordInfo;
    @FindBy(xpath = "//button[@aria-label='Add to Basket']")
    private WebElement addToCardButton;
    @FindBy(xpath = "//span[text()=' Deluxe Membership ']")
    private WebElement deluxeMembershipButton;
    @FindBy(xpath = "//span[text()=' Customer Feedback ']")
    private WebElement customerFeedbackButton;
    @FindBy(xpath = "//mat-slider[@id='rating' and @aria-valuenow='3']")
    private WebElement ratingSlider;
    @FindBy(xpath = "//span[text()='Become a member']")
    private WebElement becomeAMemberButton;
    @FindBy(xpath = "//button[@id='navbarLogoutButton']")
    private WebElement logOutButton;
    @FindBy(xpath = "//button[@aria-label='Show the shopping cart']")
    private WebElement shoppingCartButton;

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
        clickElement(cookieMessage);
        return this;
    }

    public HomePage clickWelcomeBannerDismiss() {
        clickElement(welcomeBannerDismiss);
        return this;
    }

    public boolean isWelcomeBannerVisible() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(welcomeBannerDismiss)).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    public boolean isCookieMessageVisible() {
        return wait.until(ExpectedConditions.visibilityOf(cookieMessage)).isDisplayed();
    }

    public boolean isCookieMessageNotVisible() {
        return wait.until(ExpectedConditions.invisibilityOf(cookieMessage));
    }

    public HomePage closeCookieMessage() {
        if (isCookieMessageVisible()) {
            clickDismissCookieMessage();
        }
        return this;
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
    public boolean isLogInButtonAvailable() {
        wait.until(ExpectedConditions.visibilityOf(loginHomePage));
        wait.until(ExpectedConditions.elementToBeClickable(loginHomePage)).isDisplayed();
        return true;
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
        return wait.until(ExpectedConditions.visibilityOf(addToCardButton)).isDisplayed();
    }

    public HomePage deluxeMembershipButtonClick() {
        clickElement(deluxeMembershipButton);
        return this;
    }
    public boolean isDeluxeMembershipAlreadyPurchased() {
        wait.until(ExpectedConditions.visibilityOf(deluxeMembershipButton)).isDisplayed();
        return true;
    }
    public HomePage customerFeedbackButtonClick() {
        clickElement(customerFeedbackButton);
        return this;
    }
    public HomePage chooseSliderRating(int rate) {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(ratingSlider).perform();
        wait.until(ExpectedConditions.elementToBeClickable(ratingSlider));
        WebElement slider =driver.findElement(By.xpath("//mat-slider[@aria-valuenow='" + rate + "']"));
        slider.click();
        return this;
        // TODO: 08.01.2024 Poprawic slidera
    }
    public void clickignggg() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='mat-slider-thumb-label']")));
        driver.findElement(By.xpath("//div[@class='mat-slider-thumb-label']")).click();
    }
    public HomePage becomeAMemberButtonClick() {
        clickElement(becomeAMemberButton);
        return this;
    }
    public HomePage logOutFromAccount() {
        clickElement(logOutButton);
        return this;
    }
    public boolean isShoppingCartButtonVisible() {
//        wait.until(ExpectedConditions.visibilityOf(shoppingCartButton)).isDisplayed();
        wait.until(ExpectedConditions.invisibilityOf(shoppingCartButton));
        return true;
    }
    }


// TODO: 30.12.2023 Zapoznać się z loggerem (maven)



