package webdriver.pastebin.steps;

import webdriver.pastebin.pages.NewPastePage;


public class NewPasteSteps {

    private NewPastePage newPastePage = new NewPastePage();

    public NewPasteSteps fillInNewPasteField(String text) {
        newPastePage.sendKeysToNewPasteField(text);
        return this;
    }

    public NewPasteSteps fillInPasteNameField(String text) {
        newPastePage.sendKeysToPasteNameField(text);
        return this;
    }

    public NewPasteSteps setTenMinutesToPasteExpirationDropdown() {
        newPastePage.chooseTenMinutesInPasteExpirationDropdown();
        return this;
    }

    public NewPasteSteps setBashToSyntaxHighlightingDropdown() {
        newPastePage.chooseBashElementInSyntaxHighlightingDropdown();
        return this;
    }

    public PasteResultSteps pressNewPasteButton() {
        newPastePage.scrollDown();
        newPastePage.createNewPaste();
        return new PasteResultSteps();
    }
}
