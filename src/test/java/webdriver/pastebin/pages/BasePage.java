package webdriver.pastebin.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static webdriver.pastebin.tests.BaseTest.getDriver;

public abstract class BasePage {

    WebDriver driver;
    JavascriptExecutor js;
    WebDriverWait wait;

    public BasePage() {
        this.driver = getDriver();
        PageFactory.initElements(driver, this);
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, 10);

    }

    public void scroll(int x, int y) {
        js.executeScript("window.scrollBy(" + x + "," + y + ")");
    }

}
