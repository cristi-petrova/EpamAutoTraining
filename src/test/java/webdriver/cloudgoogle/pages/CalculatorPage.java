package webdriver.cloudgoogle.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;


public class CalculatorPage extends FramePage {

    @FindBy(css = "b.ng-binding")
    WebElement totalSumText;

    @FindBy(xpath = "//div[@class='md-list-item-text ng-binding']")
    List<WebElement> estimatedResults;

    @FindBy(xpath = "//button[contains(text(), 'Add to Estimate')]")
    WebElement addToEstimateButton;

    @FindBy(id = "select_value_label_62")
    WebElement committedUsageField;

    @FindBy(id = "select_option_97")
    WebElement oneYearElement;

    @FindBy(xpath = "//*[@id='select_option_205']//div[@class='md-text ng-binding']")
    WebElement frankfurtDatacenterLocationElement;

    @FindBy(id = "select_value_label_61")
    WebElement dataCenterLocationDropbox;

    @FindBy(xpath = "//div[@class='hexagon-in2']")
    WebElement computeEngineButton;

    @FindBy(id = "input_63")
    WebElement numberOfInstancesField;

    @FindBy(id = "input_64")
    WebElement whatAreTheseInstancesForField;

    @FindBy(id = "select_76")
    WebElement operatingSystemDropbox;

    @FindBy(xpath = "//md-option[@id='select_option_65']")
    WebElement freeDebianCentOSCoreOSUbuntuElement;

    @FindBy(xpath = "//div[@class='md-container.md-ink-ripple']//*[contains(text(), 'Add GPUs')]")
    WebElement addGPUsCheckbox;

    @FindBy(id = "select_value_label_57")
    WebElement machineClassDropbox;

    @FindBy(xpath = "//md-option[@id='select_option_78']")
    WebElement regularElement;

    @FindBy(id = "select_value_label_60")
    WebElement machineTypeDropbox;

    @FindBy(xpath = "//*[@id='select_option_236']")
    WebElement e2Standart8Element;


    public void assertThatTotalSumIsCorrect(String expectedResult) {
        assertThat(totalSumText.getText()).as("Total sum doesn't equal " + expectedResult).contains(expectedResult);
    }

    public void assertThatEstimatedResultsHaveCorrectText(String expectedResult) {
        wait.until(ExpectedConditions.visibilityOfAllElements(estimatedResults));
        assertThat(estimatedResults.stream().map(element -> element.getText()).collect(Collectors.toList()).toString())
                .as("Estimated results have incorrect text").contains(expectedResult);
    }

    public void clickAddToEstimateButtonInTheFirstBlock() {
        addToEstimateButton.click();
    }

    public void setOneYearToCommittedUsageDropbox() {
        committedUsageField.click();
        oneYearElement.click();

    }

    public void setE2Standart8ToMachineTypeDropbox() {
        machineTypeDropbox.click();
        e2Standart8Element.click();
    }

    public void setRegularToMachineClassDropbox() {
        if (!machineClassDropbox.getText().equals("Regular")) {
            machineClassDropbox.click();
            regularElement.click();
        }
    }

    public void setFreeDebianCentOSCoreOSUbuntuToOperatingSystemDropbox() {
        if (!operatingSystemDropbox.getText().equals("Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS")) {
            operatingSystemDropbox.click();
            freeDebianCentOSCoreOSUbuntuElement.click();
        }
    }

    public void whatAreTheseInstancesForFieldIsEmpty() {
        if (!whatAreTheseInstancesForField.getText().equals("")) {
            whatAreTheseInstancesForField.clear();
        }
    }

    public void fillInNumberOfInstancesField(String number) {
        numberOfInstancesField.sendKeys(number);
    }

    public void setFrankfurtToDataCenterLocationDropbox() {
        dataCenterLocationDropbox.click();
        wait.until(ExpectedConditions.visibilityOf(frankfurtDatacenterLocationElement));
        frankfurtDatacenterLocationElement.click();
    }

    public void checkAddGPUsCheckbox() {
        addGPUsCheckbox.click();
    }

    public void clickComputeEngineTabIfItIsNotSelected() {
        wait.until(ExpectedConditions.visibilityOf(computeEngineButton));
        if (!computeEngineButton.isSelected()) {
            computeEngineButton.click();
        }
    }
}
