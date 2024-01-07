package Pages;

import org.openqa.selenium.*;
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
    @FindBy(xpath = "//span[@class='mat-radio-container']")
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
    @FindBy(xpath = "//div[@id='price']")
    private WebElement totalPriceText;
    @FindBy(xpath = "//input[@id='mat-input-3']")
    private WebElement nameFieldForDeluxeMembership;
    @FindBy(xpath = "//select[@id='mat-input-5']")
    private WebElement expiryMonthFieldForDeluxeMembership;


    private final Random random = new Random();

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public CartPage clickCheckoutButton() {
        clickElement(checkoutButton);
        return this;
    }

    public CartPage addNewAdress() {
        clickElement(newAdressButton);
        return this;
    }

    public CartPage inputCountryName(String country) {
        sendKeysElement(countryField, country);
        return this;
    }

    public CartPage inputName(String name) {
        sendKeysElement(nameField, name);
        return this;
    }

    public CartPage phoneNumber(String number) {
        sendKeysElement(phoneNumberField, number);
        return this;
    }

    public CartPage inputZipCode(String zipCode) {
        sendKeysElement(zipCodeField, zipCode);
        return this;
    }

    public CartPage inputCityName(String city) {
        sendKeysElement(cityField, city);
        return this;
    }

    public CartPage inputAddress(String address) {
        sendKeysElement(addressField, address);
        return this;
    }

    public boolean isSubmitButtonEnabled() {
        return submitButton.isEnabled();
    }

    public CartPage submitButtonClick() {
        clickElement(submitButton);
        return this;
    }

    public CartPage selectAddressClick() {
        clickElement(selectAddress);
        return this;
    }

    public CartPage continueButtonClick() {
        clickElement(continueButton);
        return this;
    }

    public boolean isContinueButtonClickable() {
        return continueButton.isEnabled();
    }

    public CartPage chooseDeliveryOption() {
        clickElement(deliveryOption);
        return this;
    }

    public CartPage inputCardNumber(String cardNumber) {
        sendKeysElement(cardNumberField, cardNumber);
        return this;
    }

    public CartPage addCreditCard() {
        clickElement(creditCardPanel);
        return this;
    }

    public CartPage chooseCreditCard() {
        clickElement(creditCardCheckbox);
        return this;
    }
    public CartPage chooseCreditCard2() {
        try {
            clickElement(creditCardCheckbox);
        } catch (StaleElementReferenceException e) {
            clickElement(creditCardCheckbox);
        }
        return this;
    }
    public boolean IsOrderSummarVisible() {
        return orderSummaryLayout.isDisplayed();
    }

    public CartPage purchaseProducts() {
        clickElement(placeYourOrderButton);
        return this;
    }

    public boolean checkIfConfirmationMessageIsVisible() {
        wait.until(ExpectedConditions.visibilityOf(confirmationMessage));
        return confirmationMessage.isDisplayed();
    }

    public CartPage inputPurchaserName(String name) {
        sendKeysElement(purchaserNameField, name);
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
        clickElement(expiryMonthField);
        return this;
    }

    private CartPage expiryYearDropdown() {
        clickElement(expiryYearField);
        return this;
        // TODO: 30.12.2023 Zrobić dwie metody w jednej. Jedną prywatną a drugą publiczną (zrobione)
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

    public boolean isAddressRadioButtonSelected() {
        wait.until(ExpectedConditions.visibilityOf(selectAddress)).isSelected();
        return true;
    }

    public boolean isDeliveryOptionSelected() {
        wait.until(ExpectedConditions.visibilityOf(deliveryOption)).isSelected();
        return true;
    }

    public boolean checkIfTheCardIsSelected() {
        wait.until(ExpectedConditions.visibilityOf(creditCardCheckbox)).isSelected();
        return true;
    }

    public boolean invalidSixteenDigitCardNumber() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//mat-error[text()=' Please enter a valid sixteen digit card number. ']")));
        return driver.findElement(By.xpath("//mat-error[text()=' Please enter a valid sixteen digit card number. ']")).isDisplayed();
    }

    public boolean doesTotalPriceShowsProperPrice(String element) {
        wait.until(ExpectedConditions.visibilityOf(totalPriceText));
        return driver.findElement(By.xpath("//div[@id='price' and contains(text(),'Total Price: " + element + "¤')]")).isDisplayed();
    }

    public CartPage inputNameForDeluxeMembership(String name) {
        sendKeysElement(nameFieldForDeluxeMembership, name);
        return this;
    }

    public CartPage randomExpiryMonthForDeluxeMembership() {
        List<WebElement> expiryMonthOptions = driver.findElements(By.xpath("//option[@value>'0' and @value<13]"));
        int maxOptionsSize = expiryMonthOptions.size();
        int randomOption = random.nextInt(maxOptionsSize);
        expiryMonthOptions.get(randomOption).click();
        return this;
    }
}







// TODO: 23.12.2023  Metody boolean = zmienić returny   (Zrobione)
// TODO: 23.12.2023 Waity w metodach click i sendkeys   (Zrobione)


