package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class CustomerFeedbackPage extends BasicPage{

    @FindBy(xpath = "//div[@class='mat-slider-thumb']")
    private WebElement sliderThumb;
    @FindBy(xpath = "//mat-slider[@id='rating']")
    private WebElement sliderBar;
    @FindBy(xpath = "//textarea[@id='comment']")
    private WebElement commentTextArea;
    public CustomerFeedbackPage(WebDriver driver) {
        super(driver);
    }

    private int getSliderMaxValue(WebElement ratingSlider) {
        return Integer.parseInt(ratingSlider.getAttribute("max"));
    }

    private int getSliderMinValue(WebElement ratingSlider) {
        return Integer.parseInt(ratingSlider.getAttribute("min"));
    }

    private int getSliderWidth(WebElement ratingSlider) {
        return ratingSlider.getSize().getWidth();
    }

    private int calculateOffset(WebElement slider, int desiredValue) {
        return getSliderWidth(slider) * (desiredValue - getSliderMinValue(slider)) / (getSliderMaxValue(slider) - getSliderMinValue(slider));
    }

    public void moveSlider(WebElement sliderThumb, WebElement slider, int desiredValue) {
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(sliderThumb, calculateOffset(slider, desiredValue), 0).perform();
    }

    public CustomerFeedbackPage commentTextArea(String text) {
        sendKeysToElement(commentTextArea, "text");
        return this;
    }
    public String getRatingFromSliderBar(){
        return sliderBar.getAttribute("aria-valuenow");
    }
    public void chooseSliderRating() throws InterruptedException {
        Thread.sleep(3000);
        moveSlider(sliderThumb, sliderBar, 2);
    }
}
