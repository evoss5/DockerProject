package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GooglePage extends BasicPage {
    @FindBy(xpath = "//span[text()='Utwórz konto']")
    private WebElement createNewAccountButton;
    @FindBy(xpath = "//input[@aria-label=\"Imię\"]")
    private WebElement inputName;
    @FindBy(xpath = "//span[text()='Dalej']")
    private WebElement pageForwadrd;
    @FindBy(xpath = "//input[@aria-label='Dzień']")
    private WebElement birthDay;
    @FindBy(xpath = "//input[@aria-label='Rok']")
    private WebElement yearDate;
    @FindBy(xpath = ".//span[text()='Dalej']")
    private WebElement nextStep;
    @FindBy(xpath = ".//select[@id='month']/option[3]")
    private WebElement chooseMonth;
    @FindBy(xpath = ".//select[@id='month']")
    private WebElement selectMonth;
    @FindBy(xpath = ".//select[@id='gender']")
    private WebElement selectGender;
    @FindBy(xpath = ".//select[@id='gender']/option[3]")
    private WebElement selectMan;
    @FindBy(xpath = ".//input[@type='text']")
    private WebElement createUsername;
    @FindBy(xpath = ".//input[@name='Passwd']")
    private WebElement setPassword;
    @FindBy(xpath = ".//input[@name='PasswdAgain']")
    private WebElement repeatPassword;

    public GooglePage(WebDriver driver) {
        super(driver);
    }

    public void clickCreateNewAccount() {
        wait.until(ExpectedConditions.visibilityOf(createNewAccountButton));
        createNewAccountButton.click();
    }

    public void inputNameAndClickForward() {
        inputName.sendKeys("Matthew");
        pageForwadrd.click();
    }

    public boolean doesPageShowInsertaBithdayWindow() {
        wait.until(ExpectedConditions.visibilityOf(selectMonth));
        return true;
    }

    public void insertDateAndGender() {
        wait.until(ExpectedConditions.visibilityOf(birthDay));
        birthDay.sendKeys("10");
        yearDate.sendKeys("1991");
        selectMonth.click();
        chooseMonth.click();
        selectGender.click();
        selectMan.click();
        nextStep.click();
    }

    public boolean checkIfThereIsUsernameWindow() {
        wait.until(ExpectedConditions.visibilityOf(createUsername));
        return true;
    }

    public void createUsernameAndClickForward() {
        createUsername.sendKeys("Mathewww123987");
        driver.findElement(By.xpath(".//span[text()='Dalej']")).click();
    }

    public boolean checkIfThereIsPasswordToInsert() {
        wait.until(ExpectedConditions.visibilityOf(setPassword));
        return true;
    }

    public void setPassword(String password) {
        wait.until(ExpectedConditions.elementToBeClickable(setPassword));
        setPassword.sendKeys(password);
        repeatPassword.sendKeys(password);
    }
}
