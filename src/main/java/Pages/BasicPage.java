package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.log4testng.Logger;

public class BasicPage {

    private static final Logger LOGGER = Logger.getLogger(BasicPage.class);
    protected WebDriver driver;
    protected WebDriverWait wait;
    private static final int TIMEOUT = 5;

    public BasicPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, TIMEOUT);
        PageFactory.initElements(driver, this);
    }

    public void clickElement(WebElement webElement) {
        int i = 0;
        while (true) {
            try {
                wait.until(ExpectedConditions.visibilityOf(webElement));
                wait.until(ExpectedConditions.elementToBeClickable(webElement));
                webElement.click();
                break;
            } catch (StaleElementReferenceException | ElementClickInterceptedException e) {
                i++;
            }
            if (i >= 2) {
                throw new RuntimeException("Maximum tries reached!");
            }
        }
    }

    public void sendKeysToElement(WebElement webElement, String text) {
        int i = 0;
        while (true) {
            try {
                wait.until(ExpectedConditions.visibilityOf(webElement));
                wait.until(ExpectedConditions.elementToBeClickable(webElement));
                webElement.clear();
                webElement.sendKeys(text);
                break;
            } catch (ElementNotInteractableException | StaleElementReferenceException e) {
                i++;
            }
            if (i >= 2) {
                throw new RuntimeException("Maximum tries reached");
            }
        }
    }

    public boolean isElementVisible(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (NoSuchElementException | TimeoutException e) {

            LOGGER.error("Element is not visible  " + e.getMessage());
            return false;
        }

    }

    public boolean isElementEnabled(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            wait.until(ExpectedConditions.elementToBeClickable(element));
            return element.isEnabled();
        } catch (StaleElementReferenceException | ElementNotInteractableException | TimeoutException e) {
            LOGGER.error("Element is not enabled " + e.getMessage());
            return false;
        }
    }

    public boolean isElementSelected(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            wait.until(ExpectedConditions.elementToBeClickable(element));
            return element.isSelected();
        } catch (ElementNotVisibleException | ElementNotSelectableException | TimeoutException e) {
            LOGGER.error("Element is not selected " + e.getMessage());
            return false;
        }
    }
    public boolean isRadioButtonSelected(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return element.getAttribute("class").contains("mat-radio-checked");
    }

}

// TODO: 30.12.2023 Metody mające coś wspólnego click, sendkeys itd.(zrobione)
//
// TODO: 08.01.2024 Zrobic while z powtorzeniami oraz odpowiednie wyjątkli, try catch (zrobione)

// TODO: 14.01.2024 Zrobić metode do cheboxow na selected tak samo jak to radio buttonów.