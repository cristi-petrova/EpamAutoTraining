package webdriver.cloudgoogle.steps;

import webdriver.cloudgoogle.pages.CalculatorPage;

import java.util.ArrayList;
import java.util.List;

public class CalculatorSteps {

    CalculatorPage calculatorPage = new CalculatorPage();


    public CalculatorSteps selectComputeEngineTab() {
        calculatorPage.clickComputeEngineTabIfItIsNotSelected();
        return this;
    }

    public CalculatorSteps fillInRequiredFields(String number) {
        calculatorPage.fillInNumberOfInstancesField(number);
        calculatorPage.whatAreTheseInstancesForFieldIsEmpty();
        calculatorPage.setFreeDebianCentOSCoreOSUbuntuToOperatingSystemDropbox();
        calculatorPage.setRegularToMachineClassDropbox();
        calculatorPage.setE2Standart8ToMachineTypeDropbox();
        calculatorPage.setFrankfurtToDataCenterLocationDropbox();
        calculatorPage.setOneYearToCommittedUsageDropbox();
        return this;
    }

    public CalculatorSteps pressAddToEstimateButton() {
        calculatorPage.clickAddToEstimateButtonInTheFirstBlock();
        return this;
    }

    public CalculatorSteps verifyEstimatedResults(String sumPerOne, String vmClass, String instanceType, String region, String commitmentTerm) {
        List<String> expectedResult = new ArrayList<>();
        expectedResult.add(sumPerOne);
        expectedResult.add(vmClass);
        expectedResult.add(instanceType);
        expectedResult.add(region);
        expectedResult.add(commitmentTerm);
        calculatorPage.assertThatEstimatedResultsHaveCorrectText(expectedResult.toString());
        return this;
    }

    public CalculatorSteps verifyTotalSum(String sum) {
        calculatorPage.assertThatTotalSumIsCorrect(sum);
        return this;
    }
}
