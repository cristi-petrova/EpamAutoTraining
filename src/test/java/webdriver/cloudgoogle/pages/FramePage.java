package webdriver.cloudgoogle.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static webdriver.cloudgoogle.tests.BaseTest.getDriver;

public class FramePage {

    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;

    WebElement frame;
    WebElement innerFrame;

    String frameXpath = "//article[@id='cloud-site']//iframe";
    String innerFrameXpath = "//*[@id='myFrame']";

    public FramePage() {
        this.driver = getDriver();
        wait = new WebDriverWait(driver, 15);
        js = (JavascriptExecutor) driver;

        //driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        int size = driver.findElements(By.tagName("iframe")).size();
        System.out.println("Total Frames - " + size);

        frame = driver.findElement(By.xpath(frameXpath));
        driver.switchTo().frame(frame);
        innerFrame = driver.findElement(By.xpath(innerFrameXpath));
        driver.switchTo().frame(innerFrame);
        PageFactory.initElements(driver, this);

    }


    private void scroll(int x, int y) {
        js.executeScript("window.scrollBy(" + x + "," + y + ")");
    }

    public void scrollDown() {
        driver.switchTo().defaultContent();
        scroll(0, 500);
        frame = driver.findElement(By.xpath(frameXpath));
        driver.switchTo().frame(frame);
        innerFrame = driver.findElement(By.xpath(innerFrameXpath));
        driver.switchTo().frame(innerFrame);
    }

    void clickWithJavaScript(WebElement element) {
        js.executeScript("arguments[0].click", element);
    }

}
