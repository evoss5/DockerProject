package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasicPage {

    @FindBy(xpath = "//*[@aria-label='Open Sidenav']")
    private WebElement sideNavButton;
    @FindBy(xpath = ".//*[@aria-label='Show/hide account menu']")
    private WebElement accountIcon;
    @FindBy(xpath = ".//*[@aria-label='Language selection menu']")
    private WebElement languageSelectionMenuButton;
    @FindBy(xpath = ".//a[@aria-label = 'dismiss cookie message']")
    private WebElement cookieMessageButton;
    @FindBy(xpath = ".//*[@aria-label='Close Welcome Banner']")
    private WebElement welcomeBannerDismissButton;
    @FindBy(xpath = ".//button[@id='navbarLoginButton']")
    private WebElement loginHomePageButton;
    @FindBy(xpath = "//button[@aria-label='Add to Basket']")
    private WebElement addToCardButton;
    @FindBy(xpath = "//span[text()=' Deluxe Membership ']")
    private WebElement deluxeMembershipButton;
    @FindBy(xpath = "//span[text()=' Customer Feedback ']")
    private WebElement customerFeedbackButton;
    @FindBy(xpath = "//span[text()='Become a member']")
    private WebElement becomeAMemberButton;
    @FindBy(xpath = "//button[@id='navbarLogoutButton']")
    private WebElement logOutButton;
    @FindBy (xpath = "//div[@class='heading mat-elevation-z6']/div[text()='All Products']")
    private WebElement allProductsHeader;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage sideNavButtonClick() {
        clickElement(sideNavButton);
        return this;
    }

    public HomePage accountIconClick() {
        clickElement(accountIcon);
        return this;
    }

    public HomePage languageSelectionMenuButtonClick() {
        clickElement(languageSelectionMenuButton);
        return this;
    }

    public HomePage dismissCookieMessageButtonClick() {
        clickElement(cookieMessageButton);
        return this;
    }

    public HomePage welcomeBannerDismissButtonClick() {
        clickElement(welcomeBannerDismissButton);
        return this;
    }

    public boolean isWelcomeBannerOkButtonVisible() {
        return isElementVisible(welcomeBannerDismissButton);
    }

    public boolean isCookieAcceptButtonVisible() {
        return isElementVisible(cookieMessageButton);
    }

    public HomePage acceptCookieButtonClick() {
        if (isCookieAcceptButtonVisible()) {
            dismissCookieMessageButtonClick();
        }
        return this;
    }

    public HomePage welcomeBannerOkButtonClick() {
        if (isWelcomeBannerOkButtonVisible()) {
            welcomeBannerDismissButtonClick();
        }
        return this;
    }

    public HomePage selectLanguage(String language) {
        WebElement changeLanguageTo = driver.findElement(By.xpath("//label//span//input[@aria-label='" + language + "']/ancestor::label"));
        clickElement(changeLanguageTo);
        return this;
    }

    private HomePage loginHomePageButtonClick() {
        clickElement(loginHomePageButton);
        return this;
    }

    public boolean isLogInButtonVisible() {
        return isElementVisible(loginHomePageButton);
    }


    public LoginPage goToLoginPage() {
        accountIconClick();
        loginHomePageButtonClick();
        return new LoginPage(driver);
    }

    public CustomerFeedbackPage goToCustomerPage() {
        sideNavButtonClick();
        customerFeedbackButtonClick();
        return new CustomerFeedbackPage(driver);
    }

    public boolean isAddToCartButtonVisible() {
        return isElementVisible(addToCardButton);
    }

    public HomePage deluxeMembershipButtonClick() {
        clickElement(deluxeMembershipButton);
        return this;
    }

    public boolean isDeluxeMembershipButtonVisible() {
        return isElementVisible(deluxeMembershipButton);
    }

    private HomePage customerFeedbackButtonClick() {
        clickElement(customerFeedbackButton);
        return this;
    }

    public HomePage becomeAMemberButtonClick() {
        clickElement(becomeAMemberButton);
        return this;
    }

    public HomePage logOutButtonClick() {
        clickElement(logOutButton);
        return this;
    }
    public boolean isLanguageChanged() {
        return isElementVisible(allProductsHeader);
    }
}




