package webdriver.pastebin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.assertj.core.api.Assertions.assertThat;

public class PasteResultPage extends BasePage {

    @FindBy(xpath = "//div[@class='left']//a")
    WebElement syntaxElement;
    @FindBy(xpath = "//textarea[@class='textarea']")
    WebElement textArea;
    @FindBy(xpath = "//body")
    private WebElement pageBody;

    public void assertThatSyntaxHighlightingHasCorrectText(String text) throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOf(syntaxElement));
        assertThat(syntaxElement.getText().contains(text)).as("Syntax Highlighting should be [" + text + "]").isTrue();
    }

    public void assertThatPageTitleHasCorrectText(String text) {
        assertThat(pageBody.findElements(By.xpath("//h1[contains(text(), '" + "')]"))).size()
                .as("Expected page title [" + text + "] was not found on the page.").isNotZero();
    }

    public void assertThatCodeIsCorrect(String code) {
        assertThat(textArea.getText().contains(code)).isTrue().as("Textarea doesn't contain expected code: " + code);
    }
}
