package webdriver.cloudgoogle.steps;

import webdriver.cloudgoogle.pages.SearchResultsPage;

public class SearchResultsSteps {

    SearchResultsPage searchResultsPage = new SearchResultsPage();

    public SearchResultsSteps verifyThatSearchResultsAreCorrect(String text) throws InterruptedException {
        searchResultsPage.assertThatSearchResultsAreDisplayed(text);
        searchResultsPage.assertThatSearchResultsHaveRequiredQuery(text);
        return this;
    }

    public CalculatorSteps openRequiredSearchResult() {
        searchResultsPage.clickRequiredSearchElement();
        return new CalculatorSteps();
    }


}
