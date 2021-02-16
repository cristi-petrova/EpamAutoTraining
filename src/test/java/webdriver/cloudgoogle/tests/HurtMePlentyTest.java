package webdriver.cloudgoogle.tests;

import org.testng.annotations.Test;

public class HurtMePlentyTest extends BaseTest {

    @Test
    public void executeSearchAndVerifyResults() throws InterruptedException {

        String searchRequest = "Google Cloud Platform Pricing Calculator";

        steps.executeSearch(searchRequest)
                .verifyThatSearchResultsAreCorrect(searchRequest);

    }

    @Test
    public void openGoogleCloudPlatformPricingCalculator() throws InterruptedException {
        searchResultsSteps.openRequiredSearchResult()
                .selectComputeEngineTab()
                .fillInRequiredFields("4")
                .pressAddToEstimateButton()
                .verifyEstimatedResults("2,920 total hours per month",
                        "VM class: regular",
                        "Instance type: e2-standard-8",
                        "Region: Frankfurt",
                        "Commitment term: 1 Year")
                .verifyTotalSum("USD 635.29");
    }

}
