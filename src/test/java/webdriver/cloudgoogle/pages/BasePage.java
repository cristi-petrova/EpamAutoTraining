package webdriver.cloudgoogle.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static webdriver.cloudgoogle.tests.BaseTest.getDriver;

public abstract class BasePage {

    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor executor;

    public BasePage() {
        this.driver = getDriver();
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 15);
        executor = (JavascriptExecutor) driver;
    }

    boolean isElementFound(By by, int timeout) throws InterruptedException {
        List<WebElement> elements = driver.findElements(by);
        for (int i = 0; (i < timeout) && (elements.size() == 0); i++) {
            Thread.sleep(1000);
            elements = driver.findElements(by);
        }
        return elements.size() > 0;
    }

    void clickWithJavaScript(WebElement element) {
        executor.executeScript("arguments[0].click", element);
    }

}
