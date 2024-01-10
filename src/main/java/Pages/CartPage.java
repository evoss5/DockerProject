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
    private WebElement inputName;
    @FindBy(xpath = "//input[@type='number']")
    private WebElement inputPhoneNumber;
    @FindBy(xpath = "//input[@id='mat-input-6']")
    private WebElement inputZipCode;
    @FindBy(xpath = "//input[@id='mat-input-8']")
    private WebElement inputCityName;
    @FindBy(xpath = "//textarea[@id='address']")
    private WebElement inputAddress;
    @FindBy(xpath = "//button[@id='submitButton']")
    private WebElement submitButton;
    @FindBy(xpath = "//span[@class='mat-radio-container']")
    private WebElement selectAddress;
    @FindBy(xpath = "//span[text()='Continue']")
    private WebElement continueButton;
    @FindBy(xpath = "//mat-row")
    private WebElement deliveryOption;
    @FindBy(xpath = "//input[@type='number']")
    private WebElement inputCardNumber;
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
    @FindBy(xpath = "//select[@id='mat-input-6']")
    private WebElement expiryYearField;
    @FindBy(xpath = "//*[starts-with(text(),'Your card ending with')]")
    private WebElement successfulAddedCardMessage;
    @FindBy(xpath = "//div[@id='price']")
    private WebElement totalPriceText;
    @FindBy(xpath = "//input[@id='mat-input-3']")
    private WebElement nameFieldForDeluxeMembership;
    @FindBy(xpath = "//select[@id='mat-input-5']")
    private WebElement expiryMonthFieldForDeluxeMembership;
    @FindBy(xpath = "//mat-error[@id='mat-error-19']")
    private WebElement invalidCardNumberMessage;


    private final Random random = new Random();

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public CartPage clickCheckoutButton() {
        clickElement(checkoutButton);
        return this;
    }

    public CartPage addNewAdress() {
        clickElement(addNewAddressButton);
        return this;
    }
    // TODO: 08.01.2024 Pozmieniać nazwy metod, żeby były bardziej intuicyjne

    public CartPage inputCountryName(String country) {
        sendKeysToElement(countryField, country);
        return this;
    }

    public CartPage inputName(String name) {
        sendKeysToElement(inputName, name);
        return this;
    }

    public CartPage phoneNumber(String number) {
        sendKeysToElement(inputPhoneNumber, number);
        return this;
    }

    public CartPage inputZipCode(String zipCode) {
        sendKeysToElement(inputZipCode, zipCode);
        return this;
    }

    public CartPage inputCityName(String city) {
        sendKeysToElement(inputCityName, city);
        return this;
    }

    public CartPage inputAddress(String address) {
        sendKeysToElement(inputAddress, address);
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

    public CartPage chooseDeliveryOptionButtonClick() {
        clickElement(deliveryOption);
        return this;
    }

    public CartPage inputCardNumber(String cardNumber) {
        sendKeysToElement(inputCardNumber, cardNumber);
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

    public boolean isOrderSummaryVisible() {
        return isElementVisible(orderSummaryLayout);
    }

    public CartPage purchaseProducts() {
        clickElement(placeYourOrderButton);
        return this;
    }

    public boolean checkIfConfirmationMessageIsVisible() {
        return isElementVisible(confirmationMessage);
    }

    // TODO: 08.01.2024 Pozamieniac wszystkie metody visible(zrobione)
    public CartPage inputPurchaserName(String name) {
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
        // TODO: 08.01.2024 Spróbować to zrobić na dwie metody : Jedną prywatną na wyciągnięcie rozmaiaru, a drugą losową publiczną
    }

    public boolean isDeliveryMessageVisible() {
        return isElementVisible(deliveryMessage);
    }

    public CartPage expiryMonthFieldClick() {
        clickElement(expiryMonthField);
        return this;
    }

    // TODO: 30.12.2023 Zrobić dwie metody w jednej. Jedną prywatną a drugą publiczną (zrobione)

    public boolean isThereMessageAboutSuccessfulAddedCard() {
        return isElementVisible(successfulAddedCardMessage);
    }

    public boolean isAddressRadioButtonSelected() {
        return isElementSelected(selectAddress);
    }

    public boolean isDeliveryOptionSelected() {
        return isElementSelected(deliveryOption);
    }

    public boolean checkIfTheCardIsSelected() {
        return isElementSelected(creditCardCheckbox);
    }

    public String invalidSixteenDigitCardNumber() {
        wait.until(ExpectedConditions.visibilityOf(invalidCardNumberMessage));
        return invalidCardNumberMessage.getText();
        // TODO: 08.01.2024 Do poprawy
    }

    public boolean doesTotalPriceShowsProperPrice(String element) {
        wait.until(ExpectedConditions.visibilityOf(totalPriceText));
        return driver.findElement(By.xpath("//div[@id='price' and contains(text(),'Total Price: " + element + "¤')]")).isDisplayed();
    }

    public CartPage inputNameForDeluxeMembership(String name) {
        sendKeysToElement(nameFieldForDeluxeMembership, name);
        return this;
    }

    public CartPage randomExpiryMonthForDeluxeMembership(String month) {
        WebElement field = driver.findElement(By.xpath("//select[@id='mat-input-5']"));
        Select dropdown = new Select(field);
        dropdown.selectByValue(month);
        return this;
    }

    public CartPage expiryYearDropdown(String year) {
//        clickElement(expiryYearField);
        Select dropdown = new Select(expiryYearField);
        dropdown.selectByValue(year);
        return this;
    }
}


// TODO: 23.12.2023  Metody boolean = zmienić returny   (Zrobione)
// TODO: 23.12.2023 Waity w metodach click i sendkeys   (Zrobione)
// TODO: 08.01.2024 Użyć klasę select oraz action (Zrobione)
// TODO: 10.01.2024 Zrobić kolejnego paga do customer feedback


