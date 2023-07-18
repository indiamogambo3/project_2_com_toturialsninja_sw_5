package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class SuccessPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Your Account Has Been Created!')]")
    WebElement verifyCreatedMessage;
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    WebElement continueButton;

    public String verifyAccountHasBeenCreatedMessage() {
        Reporter.log("Verify accountHas been created message" + verifyCreatedMessage.toString());
        CustomListeners.test.log(Status.PASS, "Verify accountHas been created message");
        return getTextFromElement(verifyCreatedMessage);
    }

    public void clickOnContinueButton() {
        clickOnElement(continueButton);
        Reporter.log("Click on continue button" + continueButton.toString());
        CustomListeners.test.log(Status.PASS, "Click on continue button");
    }

}
