package webdriver.pastebin.steps;

import webdriver.pastebin.pages.PasteResultPage;

public class PasteResultSteps {

    PasteResultPage pasteResultPage = new PasteResultPage();

    public PasteResultSteps verifyThatFieldsHaveCorrectText(String syntaxHighlightingValue, String pageTitleValue, String code) throws InterruptedException {
        pasteResultPage.assertThatSyntaxHighlightingHasCorrectText(syntaxHighlightingValue);
        pasteResultPage.assertThatPageTitleHasCorrectText(pageTitleValue);
        pasteResultPage.assertThatCodeIsCorrect(code);
        return this;
    }

}
