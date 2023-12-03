package Pages;

import org.openqa.selenium.By;
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

    @FindBy(xpath = ".//span[text()='Dalej']")
    WebElement nextStep;

    @FindBy(xpath = ".//select[@id='month']/option[3]")
    WebElement chooseMonth;

    @FindBy(xpath = ".//select[@id='month']")
    WebElement selectMonth;


    @FindBy(xpath = ".//select[@id='gender']")
    WebElement selectGender;

    @FindBy(xpath = ".//select[@id='gender']/option[3]")
    WebElement selectMan;

    @FindBy(xpath = ".//input[@type='text']")
    WebElement createUsername;

    @FindBy(xpath = ".//input[@name='Passwd']")
    WebElement setPassword;

    @FindBy(xpath = ".//input[@name='PasswdAgain']")
    WebElement repeatPassword;


    public void clickCreateNewAccount() {
        createNewAccount.click();
        inputName.sendKeys("Matthew");
        pageForwadrd.click();
        wait.until(ExpectedConditions.visibilityOf(birthDay));
        birthDay.sendKeys("10");
        yearDate.sendKeys("1991");
        selectMonth.click();
        chooseMonth.click();
        selectGender.click();
        selectMan.click();
        nextStep.click();
        wait.until(ExpectedConditions.elementToBeClickable(createUsername));
        createUsername.sendKeys("Mathewww123987");
        driver.findElement(By.xpath(".//span[text()='Dalej']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(setPassword));
        setPassword.sendKeys("RandomPassword1!");
        repeatPassword.sendKeys("RandomPassword1!");
        nextStep.click();
    }


}
