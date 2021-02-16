package webdriver.cloudgoogle.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CloudGooglePage extends BasePage {

    @FindBy(xpath = "//div[@class='devsite-searchbox']")
    WebElement searchBoxButton;

    @FindBy(name = "q")
    WebElement inputBox;

    public void clickSearchButton() {
        searchBoxButton.click();
    }

    public void fillInSearchFieldAndPressEnter(String text) {
        inputBox.sendKeys(text);
        inputBox.sendKeys(Keys.RETURN);
    }
}
