package webdriver.pastebin.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewPastePage extends BasePage {

    @FindBy(id = "postform-text")
    WebElement newPasteField;

    @FindBy(id = "postform-name")
    WebElement pasteNameField;

    @FindBy(id = "select2-postform-format-container")
    WebElement syntaxHighlightingDropDown;

    @FindBy(id = "select2-postform-expiration-container")
    WebElement pasteExpirationDropDown;

    @FindBy(xpath = "//li[text()='Bash']")
    WebElement syntaxHighlightingBashElement;

    @FindBy(xpath = "//li[text()='10 Minutes']")
    WebElement pasteExpirationTenMinutesElement;

    @FindBy(xpath = "//button[normalize-space()='Create New Paste']")
    WebElement createNewPasteButton;

    public void sendKeysToNewPasteField(String text) {
        newPasteField.clear();
        newPasteField.sendKeys(text);
    }

    public void sendKeysToPasteNameField(String text) {
        pasteNameField.clear();
        pasteNameField.sendKeys(text);
    }

    public void chooseTenMinutesInPasteExpirationDropdown() {
        pasteExpirationDropDown.click();
        pasteExpirationTenMinutesElement.click();
    }

    public void chooseBashElementInSyntaxHighlightingDropdown() {
        syntaxHighlightingDropDown.click();
        syntaxHighlightingBashElement.click();
    }

    public void createNewPaste() {
        createNewPasteButton.click();
    }

    public void scrollDown() {
        scroll(0, 500);
    }


}
