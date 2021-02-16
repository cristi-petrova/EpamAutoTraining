package webdriver.cloudgoogle.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchResultsPage extends BasePage {

    @FindBy(xpath = "//div[@class='gs-title']")
    List<WebElement> searchResults;

    @FindBy(xpath = "//div[@class='gsc-expansionArea']")
    WebElement resultsArea;

    @FindBy(xpath = "//div[@class='gsc-expansionArea']//*[contains(text(), 'Google Cloud Platform Pricing Calculator')]")
    WebElement requiredSearchResult;

    public void clickRequiredSearchElement() {
        requiredSearchResult.click();
    }

    public void assertThatSearchResultsAreDisplayed(String expectedResult) throws InterruptedException {
        isElementFound(By.xpath("//div[@class='gs-title']"), 5);
        assertThat(searchResults.size()).as("There are no results with [" + expectedResult +
                "] request.").isGreaterThanOrEqualTo(1);
    }

    public void assertThatSearchResultsHaveRequiredQuery(String searchQuery) {
        assertThat(resultsArea.findElements(By.xpath("//*[contains(text(), '" + searchQuery + "')]"))).size()
                .as("Expected search result [" + searchQuery + "] doesn't exist").isNotZero();
    }

}
