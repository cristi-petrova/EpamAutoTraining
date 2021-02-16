package webdriver.pastebin.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import webdriver.pastebin.steps.NewPasteSteps;
import webdriver.utils.DriverFactory;
import webdriver.utils.PropertyReader;

public abstract class BaseTest {

    private static WebDriver driver;
    NewPasteSteps steps;

    public static WebDriver getDriver() {
        return driver;
    }

    @BeforeClass
    public void setUp() {
        driver = DriverFactory.createDriver(PropertyReader.getBrowser());
        driver.get(PropertyReader.getURL());
        steps = new NewPasteSteps();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @AfterMethod
    public void goBack() {
        driver.navigate().back();
    }

}
