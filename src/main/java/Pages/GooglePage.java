package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GooglePage extends BasicPage {
    public GooglePage(WebDriver driver) {
        super(driver);

    }

    @FindBy(xpath = "//span[text()='Utwórz konto']")
    WebElement createNewAccount;

    @FindBy(xpath = "//input[@aria-label=\"Imię\"]")
    WebElement inputName;

    @FindBy(xpath = "//span[text()='Dalej']")
    WebElement pageForwadrd;

    @FindBy(xpath = "//input[@aria-label='Dzień']")
    WebElement birthDay;

    @FindBy(xpath = "//input[@aria-label='Rok']")
    WebElement yearDate;

    public void clickCreateNewAccount() {
        createNewAccount.click();
        inputName.sendKeys("Matthew");
        pageForwadrd.click();
        wait.until(ExpectedConditions.visibilityOf(birthDay));
        birthDay.sendKeys("10");
        yearDate.sendKeys("1991");
    }


}
