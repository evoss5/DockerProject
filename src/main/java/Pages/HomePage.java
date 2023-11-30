package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasicPage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = ".//*[@aria-label='Open Sidenav']")
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



    public void sideNavButtonClick() {
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
        gitHubRef.click();
    }



}

