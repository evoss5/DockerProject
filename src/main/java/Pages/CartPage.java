package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class CartPage extends BasicPage {

    private static final By CELL_NAME = By.xpath("//mat-cell[contains(@class,'column-Name')]");
    @FindBy(xpath = "//button[contains(@class, 'checkout-button')]")
    private WebElement checkoutButton;
    @FindBy(xpath = "//span[text()='Add New Address']")
    private WebElement addNewAddressButton;
    @FindBy(xpath = "//input[@placeholder='Please provide a country.']")
    private WebElement countryField;
    @FindBy(xpath = "//input[@placeholder='Please provide a name.']")
    private WebElement nameField;
    @FindBy(xpath = "//input[@type='number']")
    private WebElement phoneNumberField;
    @FindBy(xpath = "//input[@id='mat-input-6']")
    private WebElement zipCodeField;
    @FindBy(xpath = "//input[@id='mat-input-8']")
    private WebElement cityNameField;
    @FindBy(xpath = "//textarea[@id='address']")
    private WebElement addressField;
    @FindBy(xpath = "//button[@id='submitButton']")
    private WebElement submitButton;
    @FindBy(xpath = "//span[@class='mat-radio-container']")
    private WebElement selectAddress;
    @FindBy(xpath = "//span[text()='Continue']")
    private WebElement continueButton;
    @FindBy(xpath = "//mat-row")
    private WebElement deliveryOptionRadioButton;
    @FindBy(xpath = "//input[@type='number']")
    private WebElement cardNumberField;
    @FindBy(xpath = "//mat-panel-description[text()=' Add a credit or debit card ']")
    private WebElement creditCardDropdown;
    @FindBy(xpath = "//span[@class='mat-radio-container']/../..")
    private WebElement creditCardCheckbox;
    @FindBy(xpath = "//div[@class='order-summary']")
    private WebElement orderSummaryField;
    @FindBy(xpath = "//button[@id='checkoutButton']")
    private WebElement placeYourOrderButton;
    @FindBy(xpath = "//h1[@class='confirmation']")
    private WebElement confirmationMessage;
    @FindBy(xpath = "//input[@id='mat-input-10']")
    private WebElement purchaserNameField;
    @FindBy(xpath = "//h1[text()='Delivery Address']")
    private WebElement deliveryAddressPageHeader;
    @FindBy(xpath = "//select[@id='mat-input-12']")
    private WebElement expiryMonthField;
    @FindBy(xpath = "//select[@id='mat-input-6']")
    private WebElement expiryYearField;
    @FindBy(xpath = "//*[starts-with(text(),'Your card ending with')]")
    private WebElement successfulAddedCardMessage;
    @FindBy(xpath = "//div[@id='price']")
    private WebElement totalPriceValue;
    @FindBy(xpath = "//input[@id='mat-input-3']")
    private WebElement cardOwnerNameField;
    @FindBy(xpath = "//select[@id='mat-input-5']")
    private WebElement cardExpiryDateField;
    @FindBy(xpath = "//mat-error[@id='mat-error-19']")
    private WebElement invalidCardNumberMessage;


    private final Random random = new Random();

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public CartPage checkoutButtonClick() {
        clickElement(checkoutButton);
        return this;
    }

    public CartPage addNewAdress() {
        clickElement(addNewAddressButton);
        return this;
    }

    public CartPage fillCountryNameField(String country) {
        sendKeysToElement(countryField, country);
        return this;
    }

    public CartPage fillNameField(String name) {
        sendKeysToElement(nameField, name);
        return this;
    }

    public CartPage fillPhoneNumberField(String number) {
        sendKeysToElement(phoneNumberField, number);
        return this;
    }

    public CartPage fillZipCodeField(String zipCode) {
        sendKeysToElement(zipCodeField, zipCode);
        return this;
    }

    public CartPage fillCityNameField(String city) {
        sendKeysToElement(cityNameField, city);
        return this;
    }

    public CartPage fillAddressField(String address) {
        sendKeysToElement(addressField, address);
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
        return isElementEnabled(continueButton);
    }

    public CartPage fillCardNumberField(String cardNumber) {
        sendKeysToElement(cardNumberField, cardNumber);
        return this;
    }

    public CartPage creditCardDropdownClick() {
        clickElement(creditCardDropdown);
        return this;
    }

    public CartPage creditCardCheckoxCheck() {
        clickElement(creditCardCheckbox);
        return this;
    }

    public boolean isOrderSummaryVisible() {
        return isElementVisible(orderSummaryField);
    }

    public CartPage purchaseProductsButtonClick() {
        clickElement(placeYourOrderButton);
        return this;
    }

    public boolean checkIfConfirmationMessageIsVisible() {
        return isElementVisible(confirmationMessage);
    }

    public CartPage fillPurchaserNameField(String name) {
        sendKeysToElement(purchaserNameField, name);
        return this;
    }

    public CartPage randomExpiryMonth() {
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

    public CartPage randomDeliveryOption() {
        List<WebElement> deliveryOptions = driver.findElements(By.xpath("//mat-row"));
        int randomDeliveryOption = deliveryOptions.size();
        int randomDelivery = random.nextInt(randomDeliveryOption);
        deliveryOptions.get(randomDelivery).click();
        return this;
        // TODO: 08.01.2024 Spróbować to zrobić na dwie metody : Jedną prywatną na wyciągnięcie rozmaiaru, a drugą losową publiczną
    }

    public boolean isDeliveryMessageVisible() {
        return isElementVisible(deliveryAddressPageHeader);
    }

    public CartPage expiryMonthFieldClick() {
        clickElement(expiryMonthField);
        return this;
    }

    // TODO: 30.12.2023 Zrobić dwie metody w jednej. Jedną prywatną a drugą publiczną (zrobione)

    public boolean isSuccessfullyAddedCardMessageVisible() {
        return isElementVisible(successfulAddedCardMessage);
    }

    public boolean isAddressRadioButtonSelected() {
        return isElementSelected(selectAddress);
    }

    public boolean isDeliveryOptionSelected() {
        return isElementSelected(deliveryOptionRadioButton);
    }

    public boolean isCreditCardCheckboxSelected() {
        return isRadioButtonSelected(creditCardCheckbox);
    }

    public String invalidSixteenDigitCardNumber() {
        wait.until(ExpectedConditions.visibilityOf(invalidCardNumberMessage));
        return invalidCardNumberMessage.getText();
        // TODO: 08.01.2024 Do poprawy (zrobione)
    }

    public boolean doesTotalPriceShowsProperPrice(String element) {
        wait.until(ExpectedConditions.visibilityOf(totalPriceValue));
        return driver.findElement(By.xpath("//div[@id='price' and contains(text(),'Total Price: " + element + "¤')]")).isDisplayed();
    }

    public CartPage fillNameForDeluxeMembershipField(String name) {
        sendKeysToElement(cardOwnerNameField, name);
        return this;
    }

    public CartPage randomExpiryMonthForDeluxeMembership(String month) {
        Select dropdown = new Select(cardExpiryDateField);
        dropdown.selectByValue(month);
        return this;
    }

    public CartPage expiryYearDropdownSelect(String year) {
        Select dropdown = new Select(expiryYearField);
        dropdown.selectByValue(year);
        return this;
    }
}



