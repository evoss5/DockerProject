package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

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

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void clickCheckoutButton() {
        wait.until(ExpectedConditions.visibilityOf(checkoutButton));
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton));
        checkoutButton.click();
    }

    public void addNewAdress() {
        wait.until(ExpectedConditions.elementToBeClickable(newAdressButton));
        newAdressButton.click();
    }

    public void inputCountryName(String country) {
        wait.until(ExpectedConditions.elementToBeClickable(countryField));
        countryField.sendKeys(country);
        System.out.println("Country name " + country);
        new CartPage(driver);
    }

    public void inputName(String name) {
        wait.until(ExpectedConditions.elementToBeClickable(nameField));
        nameField.sendKeys(name);
        System.out.println("Name " + name);
        new CartPage(driver);
    }

    public CartPage phoneNumber(String number) {
        phoneNumberField.sendKeys(number);
        return new CartPage(driver);
    }

    public void inputZipCode(String zipCode) {
        zipCodeField.sendKeys(zipCode);

    }

    public void inputCityName(String city) {
        cityField.sendKeys(city);
    }

    public void inputAdress(String adress) {
        adressField.sendKeys(adress);
    }

    public boolean isSubmitButtonEnabled() {
        submitButton.isEnabled();
        return true;
    }

    public void submitButtonClick() {
        submitButton.click();
    }

    public void selectAdressClick() {
        wait.until(ExpectedConditions.visibilityOf(selectAdress));
        wait.until(ExpectedConditions.elementToBeClickable(selectAdress));
        selectAdress.click();
    }

    public void continueButtonClick() {
        continueButton.click();
    }

    public boolean isContinueButtonClickable() {
        continueButton.isEnabled();
        return true;
    }

    public void chooseDeliveryOption() {
        deliveryOption.click();
    }

    public void inputCardNumber(String cardNumber) {
        wait.until(ExpectedConditions.visibilityOf(cardNumberField));
        cardNumberField.sendKeys(cardNumber);
    }

    public void addCreditCard() {
        creditCardPanel.click();
    }
    public void chooseCreditCard() {
        wait.until(ExpectedConditions.visibilityOf(creditCardCheckbox));
        wait.until(ExpectedConditions.elementToBeClickable(creditCardCheckbox));
        creditCardCheckbox.click();
    }
    public boolean IsOrderSummarVisible() {
        orderSummaryLayout.isDisplayed();
        return true;
    }
    public void purchaseProducts() {
        wait.until(ExpectedConditions.visibilityOf(placeYourOrderButton));
        placeYourOrderButton.click();
    }
    public boolean checkIfConfirmationMessageIsVisible() {
        wait.until(ExpectedConditions.visibilityOf(confirmationMessage));
        confirmationMessage.isDisplayed();
        return true;
    }
    }

