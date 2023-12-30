package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Random;

public class CartPage extends BasicPage {

    private static final By CELL_NAME = By.xpath("//mat-cell[contains(@class,'column-Name')]");
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
    private WebElement addressField;
    @FindBy(xpath = "//button[@id='submitButton']")
    private WebElement submitButton;
    @FindBy(xpath = "//mat-table[@class='mat-table cdk-table //mat-row")  // to samo
    private WebElement selectAddress;
    @FindBy(xpath = "//span[text()='Continue']")
    private WebElement continueButton;
    @FindBy(xpath = "//mat-row")
    private WebElement deliveryOption;
    @FindBy(xpath = "//input[@type='number']")
    private WebElement cardNumberField;
    @FindBy(xpath = "//mat-panel-description[text()=' Add a credit or debit card ']")
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
    @FindBy(xpath = "//h1[text()='Delivery Address']")
    private WebElement deliveryMessage;
    @FindBy(xpath = "//select[@id='mat-input-12']")
    private WebElement expiryMonthField;
    @FindBy(xpath = "//select[@id='mat-input-13']")
    private WebElement expiryYearField;
    @FindBy(xpath = "//*[starts-with(text(),'Your card ending with')]")
    private WebElement successfulAddedCardMessage;

    private final Random random = new Random();

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public CartPage clickCheckoutButton() {
        wait.until(ExpectedConditions.visibilityOf(checkoutButton));
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton));
        checkoutButton.click();
        return this;
    }

    public CartPage addNewAdress() {
        wait.until(ExpectedConditions.visibilityOf(newAdressButton));
        wait.until(ExpectedConditions.elementToBeClickable(newAdressButton));
        newAdressButton.click();
        return this;
    }

    public CartPage inputCountryName(String country) {
        wait.until(ExpectedConditions.visibilityOf(countryField));
        wait.until(ExpectedConditions.elementToBeClickable(countryField));
        countryField.sendKeys(country);
        return this;
    }

    public CartPage inputName(String name) {
        wait.until(ExpectedConditions.visibilityOf(nameField));
        wait.until(ExpectedConditions.elementToBeClickable(nameField));
        nameField.clear();
        nameField.sendKeys(name);
        return this;
    }

    public CartPage phoneNumber(String number) {
        wait.until(ExpectedConditions.visibilityOf(phoneNumberField));
        wait.until(ExpectedConditions.elementToBeClickable(phoneNumberField));
        phoneNumberField.clear();
        phoneNumberField.sendKeys(number);
        return this;
    }

    public CartPage inputZipCode(String zipCode) {
        wait.until(ExpectedConditions.visibilityOf(zipCodeField));
        wait.until(ExpectedConditions.elementToBeClickable(zipCodeField));
        zipCodeField.clear();
        zipCodeField.sendKeys(zipCode);
        return this;
    }

    public CartPage inputCityName(String city) {
        wait.until(ExpectedConditions.visibilityOf(cityField));
        wait.until(ExpectedConditions.elementToBeClickable(cityField));
        cityField.clear();
        cityField.sendKeys(city);
        return this;
    }

    public CartPage inputAddress(String address) {
        wait.until(ExpectedConditions.visibilityOf(addressField));
        wait.until(ExpectedConditions.elementToBeClickable(addressField));
        addressField.clear();
        addressField.sendKeys(address);
        return this;
    }

    public boolean isSubmitButtonEnabled() {
        return submitButton.isEnabled();
    }

    public CartPage submitButtonClick() {
        wait.until(ExpectedConditions.visibilityOf(submitButton));
        wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        submitButton.click();
        return this;
    }

    public CartPage selectAddressClick() {
        wait.until(ExpectedConditions.visibilityOf(selectAddress));
        wait.until(ExpectedConditions.elementToBeClickable(selectAddress));
        selectAddress.click();
        return this;
    }

    public CartPage continueButtonClick() {
        wait.until(ExpectedConditions.visibilityOf(continueButton));
        wait.until(ExpectedConditions.elementToBeClickable(continueButton));
        continueButton.click();
        return this;
    }

    public boolean isContinueButtonClickable() {
        return continueButton.isEnabled();
    }

    public CartPage chooseDeliveryOption() {
        wait.until(ExpectedConditions.visibilityOf(deliveryOption));
        wait.until(ExpectedConditions.elementToBeClickable(deliveryOption));
        deliveryOption.click();
        return this;
    }

    public CartPage inputCardNumber(String cardNumber) {
        wait.until(ExpectedConditions.visibilityOf(cardNumberField));
        wait.until(ExpectedConditions.elementToBeClickable(cardNumberField));
        cardNumberField.clear();
        cardNumberField.sendKeys(cardNumber);
        return this;
    }

    public CartPage addCreditCard() {
        wait.until(ExpectedConditions.visibilityOf(creditCardPanel));
        wait.until(ExpectedConditions.elementToBeClickable(creditCardPanel));
        creditCardPanel.click();
        return this;
    }

    public CartPage chooseCreditCard() {
        wait.until(ExpectedConditions.visibilityOf(creditCardCheckbox));
        wait.until(ExpectedConditions.elementToBeClickable(creditCardCheckbox));
        creditCardCheckbox.click();
        return this;
    }

    public boolean IsOrderSummarVisible() {
        return orderSummaryLayout.isDisplayed();
    }

    public CartPage purchaseProducts() {
        wait.until(ExpectedConditions.visibilityOf(placeYourOrderButton));
        wait.until(ExpectedConditions.elementToBeClickable(placeYourOrderButton));
        placeYourOrderButton.click();
        return this;
    }

    public boolean checkIfConfirmationMessageIsVisible() {
        wait.until(ExpectedConditions.visibilityOf(confirmationMessage));
        return confirmationMessage.isDisplayed();
    }

    public CartPage inputPurchaserName(String name) {
        wait.until(ExpectedConditions.visibilityOf(purchaserNameField));
        wait.until(ExpectedConditions.elementToBeClickable(purchaserNameField));
        purchaserNameField.clear();
        purchaserNameField.sendKeys(name);
        return this;
    }

    public CartPage randomItem() {
        List<WebElement> expiryMonthOptions = driver.findElements(By.xpath("//option[@value>'0' and @value<13]"));
        int maxOptionsSize = expiryMonthOptions.size();
        int randomOption = random.nextInt(maxOptionsSize);
        expiryMonthOptions.get(randomOption).click();
        return this;
    }

    public CartPage randomExpiryYear() {
        expiryYearDropdown();
        List<WebElement> expiryYearsOptions = driver.findElements(By.xpath("//option[@value>=2080]"));
        int yearsOptionsSize = expiryYearsOptions.size();
        int randomYearOption = random.nextInt(yearsOptionsSize);
        expiryYearsOptions.get(randomYearOption).click();
        return this;
    }

    public CartPage randomCard() {
        List<WebElement> cardOptions = driver.findElements(By.xpath("//input[contains(@id,'mat-radio')]"));
        int cardOptionsSize = cardOptions.size();
        int randomCardOption = random.nextInt(cardOptionsSize);
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//input[contains(@id,'mat-radio')]"), 0));
        cardOptions.get(randomCardOption).click();
        return this;

    }

    public CartPage randomName() {
        List<WebElement> nameOptions = driver.findElements(CELL_NAME);
        int randomNameOption = nameOptions.size();
        int randomName2 = random.nextInt(randomNameOption);
        nameOptions.get(randomName2).click();
        return this;
    }

    public CartPage randomDeliveryOption() {
        List<WebElement> deliveryOptions = driver.findElements(By.xpath("//mat-row"));
        int randomDeliveryOption = deliveryOptions.size();
        int randomDelivery = random.nextInt(randomDeliveryOption);
        deliveryOptions.get(randomDelivery).click();
        return this;
    }

    public boolean isDeliveryMessageVisible() {
        wait.until(ExpectedConditions.visibilityOf(deliveryMessage));
        return deliveryMessage.isDisplayed();
    }

    public CartPage expiryMonthFieldClick() {
        wait.until(ExpectedConditions.visibilityOf(expiryMonthField));
        wait.until(ExpectedConditions.elementToBeClickable(expiryMonthField));
        expiryMonthField.click();
        return this;
    }

    private CartPage expiryYearDropdown() {
        wait.until(ExpectedConditions.visibilityOf(expiryYearField));
        wait.until(ExpectedConditions.elementToBeClickable(expiryYearField));
        expiryYearField.click();
        return this;
        // TODO: 30.12.2023 Zrobić dwie metody w jednej. Jedną prywatną a drugą publiczną
    }

    public boolean isThereMessageAboutSuccessfulAddedCard() {
        wait.until(ExpectedConditions.visibilityOf(successfulAddedCardMessage));
        return successfulAddedCardMessage.isDisplayed();
    }

    public CartPage selectRandomAddress() {
        List<WebElement> randomAdresses = driver.findElements(By.xpath("//label[@class='mat-radio-label']/.."));
        int Adress = randomAdresses.size();
        int randomAdress = random.nextInt(Adress);
        try {
            randomAdresses.get(randomAdress).click();
            return this;
        } catch (IllegalArgumentException | TimeoutException e) {
            throw new RuntimeException(e);
        }
    }
}







// TODO: 23.12.2023  Metody boolean = zmienić returny   (Zrobione)
// TODO: 23.12.2023 Waity w metodach click i sendkeys   (Zrobione)


