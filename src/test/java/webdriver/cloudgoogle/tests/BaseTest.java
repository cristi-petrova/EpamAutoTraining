package webdriver.cloudgoogle.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import webdriver.cloudgoogle.steps.CloudGoogleSteps;
import webdriver.cloudgoogle.steps.SearchResultsSteps;
import webdriver.utils.DriverFactory;
import webdriver.utils.PropertyReader;

public abstract class BaseTest {

    private static WebDriver driver;
    CloudGoogleSteps steps;
    SearchResultsSteps searchResultsSteps;

    public static WebDriver getDriver() {
        return driver;
    }

    @BeforeClass
    public void setUp() {
        driver = DriverFactory.createDriver(PropertyReader.getBrowser());
        driver.get(PropertyReader.getURL());
        steps = new CloudGoogleSteps();

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @AfterMethod
    public void continueSteps() {
        searchResultsSteps = new SearchResultsSteps();
    }

}
