package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Random;

public class CartPage extends BasicPage {
    @FindBy(xpath = "//button[contains(@class, 'checkout-button')]")
    private WebElement checkoutButton;
    @FindBy(xpath = "//span[text()='Add New Address']")
    private WebElement newAdressButton;
    @FindBy(xpath = "//input[@placeholder='Please provide a country.']")
    private WebElement countryField;
    @FindBy(xpath = "//input[@placeholder='Please provide a name.']")
    private WebElement nameField;
    @FindBy(xpath = "//input[@type='number']")
    private WebElement phoneNumberField;
    @FindBy(xpath = "//input[@id='mat-input-6']")
    private WebElement zipCodeField;
    @FindBy(xpath = "//input[@id='mat-input-8']")
    private WebElement cityField;
    @FindBy(xpath = "//textarea[@id='address']")
    private WebElement adressField;
    @FindBy(xpath = "//button[@id='submitButton']")
    private WebElement submitButton;
    @FindBy(xpath = "//mat-table[@class='mat-table cdk-table ng-star-inserted']/mat-row[4]")
    private WebElement selectAdress;
    @FindBy(xpath = "//span[text()='Continue']")
    private WebElement continueButton;
    @FindBy(xpath = "//*[@class='mat-card mat-focus-indicator mat-elevation-z6']//h1[1]")
    private WebElement deliveryAdressMessage;
    @FindBy(xpath = "//mat-table[@class='mat-table cdk-table']/mat-row[2]")
    private WebElement deliveryOption;
    @FindBy(xpath = "//input[@type='number']")
    private WebElement cardNumberField;
    @FindBy(xpath = ".//*[@class='mat-expansion-panel mat-elevation-z0 ng-tns-c41-24 ng-star-inserted']")
    private WebElement creditCardPanel;
    @FindBy(xpath = "//label[@class='mat-radio-label']")
    private WebElement creditCardCheckbox;
    @FindBy(xpath = "//div[@class='order-summary']")
    private WebElement orderSummaryLayout;
    @FindBy(xpath = "//button[@id='checkoutButton']")
    private WebElement placeYourOrderButton;
    @FindBy(xpath = "//h1[@class='confirmation']")
    private WebElement confirmationMessage;
    @FindBy(xpath = "//input[@id='mat-input-10']")
    private WebElement purchaserNameField;
    @FindBy(xpath = "//option[@value>'0' and @value<13]")
    private WebElement expiryMonthDate;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void clickCheckoutButton() {
        wait.until(ExpectedConditions.visibilityOf(checkoutButton));
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton));
        checkoutButton.click();
    }

    public void addNewAdress() {
        wait.until(ExpectedConditions.visibilityOf(newAdressButton));
        wait.until(ExpectedConditions.elementToBeClickable(newAdressButton));
        newAdressButton.click();
    }

    public void inputCountryName(String country) {
        wait.until(ExpectedConditions.visibilityOf(countryField));
        wait.until(ExpectedConditions.elementToBeClickable(countryField));
        countryField.sendKeys(country);
        System.out.println("Country name " + country);
        new CartPage(driver);
    }

    public CartPage inputName(String name) {
        wait.until(ExpectedConditions.visibilityOf(nameField));
        wait.until(ExpectedConditions.elementToBeClickable(nameField));
        nameField.clear();
        nameField.sendKeys(name);
        System.out.println("Name " + name);
        return this;
    }

    public CartPage phoneNumber(String number) {
        wait.until(ExpectedConditions.visibilityOf(phoneNumberField));
        wait.until(ExpectedConditions.elementToBeClickable(phoneNumberField));
        phoneNumberField.clear();
        phoneNumberField.sendKeys(number);
        return new CartPage(driver);
    }

    public void inputZipCode(String zipCode) {
        wait.until(ExpectedConditions.visibilityOf(zipCodeField));
        wait.until(ExpectedConditions.elementToBeClickable(zipCodeField));
        zipCodeField.clear();
        zipCodeField.sendKeys(zipCode);
    }

    public CartPage inputCityName(String city) {
        wait.until(ExpectedConditions.visibilityOf(cityField));
        wait.until(ExpectedConditions.elementToBeClickable(cityField));
        cityField.clear();
        cityField.sendKeys(city);
        return this;
    }

    public void inputAdress(String adress) {
        wait.until(ExpectedConditions.visibilityOf(adressField));
        wait.until(ExpectedConditions.elementToBeClickable(adressField));
        adressField.clear();
        adressField.sendKeys(adress);
    }

    public boolean isSubmitButtonEnabled() {
        return submitButton.isEnabled();
    }

    public void submitButtonClick() {
        wait.until(ExpectedConditions.visibilityOf(submitButton));
        wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        submitButton.click();
    }

    public void selectAdressClick() {
        wait.until(ExpectedConditions.visibilityOf(selectAdress));
        wait.until(ExpectedConditions.elementToBeClickable(selectAdress));
        selectAdress.click();
    }

    public void continueButtonClick() {
        wait.until(ExpectedConditions.visibilityOf(continueButton));
        wait.until(ExpectedConditions.elementToBeClickable(continueButton));
        continueButton.click();
    }

    public boolean isContinueButtonClickable() {
        return continueButton.isEnabled();
    }

    public void chooseDeliveryOption() {
        wait.until(ExpectedConditions.visibilityOf(deliveryOption));
        wait.until(ExpectedConditions.elementToBeClickable(deliveryOption));
        deliveryOption.click();
    }

    public void inputCardNumber(String cardNumber) {
        wait.until(ExpectedConditions.visibilityOf(cardNumberField));
        cardNumberField.clear();
        cardNumberField.sendKeys(cardNumber);
    }

    public void addCreditCard() {
        wait.until(ExpectedConditions.visibilityOf(creditCardPanel));
        wait.until(ExpectedConditions.elementToBeClickable(creditCardPanel));
        creditCardPanel.click();
    }

    public void chooseCreditCard() {
        wait.until(ExpectedConditions.visibilityOf(creditCardCheckbox));
        wait.until(ExpectedConditions.elementToBeClickable(creditCardCheckbox));
        creditCardCheckbox.click();
    }

    public boolean IsOrderSummarVisible() {
        return orderSummaryLayout.isDisplayed();
    }

    public void purchaseProducts() {
        wait.until(ExpectedConditions.visibilityOf(placeYourOrderButton));
        wait.until(ExpectedConditions.elementToBeClickable(placeYourOrderButton));
        placeYourOrderButton.click();
    }

    public boolean checkIfConfirmationMessageIsVisible() {
        wait.until(ExpectedConditions.visibilityOf(confirmationMessage));
        return confirmationMessage.isDisplayed();
    }
    public CartPage inputPurchaserName(String name) {
        purchaserNameField.sendKeys(name);
        return this;
    }
    public void randomItem() {
        List<WebElement> expiryMonthOptions = driver.findElements(By.xpath("//option[@value>'0' and @value<13]"));
        int maxOptionsSize = expiryMonthOptions.size();
        Random random = new Random();
        int randomOption = random.nextInt(maxOptionsSize);
        expiryMonthOptions.get(randomOption).click();
    }
    public void randomExpiryYear(){
        List<WebElement>expiryYearsOptions = driver.findElements(By.xpath("//option[@value>=2080]"));
        int yearsOptionsSize = expiryYearsOptions.size();
        Random random = new Random();
        int randomYearOption = random.nextInt(yearsOptionsSize);
        expiryYearsOptions.get(randomYearOption).click();
    }
    public void randomCard() {

        List<WebElement>cardOptions = driver.findElements(By.xpath("//input[contains(@id,'mat-radio')]"));
        int cardOptionsSize = cardOptions.size();
        Random random = new Random();
        int randomCardOption = random.nextInt(cardOptionsSize);
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//input[contains(@id,'mat-radio')]"), 0));
        cardOptions.get(randomCardOption).click();
    }



}

// TODO: 23.12.2023  Metody boolean = zmienić returny   (Zrobione)
// TODO: 23.12.2023 Waity w metodach click i sendkeys   (Zrobione)

