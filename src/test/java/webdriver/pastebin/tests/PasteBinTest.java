package webdriver.pastebin.tests;

import org.testng.annotations.Test;

public class PasteBinTest extends BaseTest {

    @Test
    public void iCanWin() {

        steps.fillInNewPasteField("Hello from WebDriver")
                .setTenMinutesToPasteExpirationDropdown()
                .fillInPasteNameField("helloweb")
                .pressNewPasteButton();
    }

    @Test
    public void BringItOn() throws InterruptedException {

        String pasteNameFiled = "how to gain dominance among developers";
        String code = "git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force";

        steps.fillInNewPasteField(code)
                .setBashToSyntaxHighlightingDropdown()
                .setTenMinutesToPasteExpirationDropdown()
                .fillInPasteNameField(pasteNameFiled)
                .pressNewPasteButton()
                .verifyThatFieldsHaveCorrectText("Bash", pasteNameFiled, code);

    }

}
