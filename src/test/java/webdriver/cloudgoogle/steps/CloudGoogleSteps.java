package webdriver.cloudgoogle.steps;

import webdriver.cloudgoogle.pages.CloudGooglePage;

public class CloudGoogleSteps {

    private CloudGooglePage cloudGooglePage = new CloudGooglePage();

    public SearchResultsSteps executeSearch(String text) {
        cloudGooglePage.clickSearchButton();
        cloudGooglePage.fillInSearchFieldAndPressEnter(text);
        return new SearchResultsSteps();
    }
}
