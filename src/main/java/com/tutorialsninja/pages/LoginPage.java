package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class LoginPage extends Utility {

    @CacheLookup
    @FindBy(id = "input-email")
    WebElement emailField;
    @CacheLookup
    @FindBy(id = "input-password")
    WebElement passwordField;
    @CacheLookup
    @FindBy(xpath = "//input[@type = 'submit']")
    WebElement loginButton;
    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'My Account')]")
    WebElement verifyAccountText;


    public void enterEmail(String email) {
        sendTextToElement(emailField, email);
        Reporter.log("Enter email" + email + "to email field" + emailField.toString());
        CustomListeners.test.log(Status.PASS, "Enter email" + email);
    }

    public void enterPassword(String password) {
        sendTextToElement(passwordField, password);
        Reporter.log("Enter password" + password + "to password field" + passwordField.toString());
        CustomListeners.test.log(Status.PASS, "Enter password" + password);
    }

    public void clickOnLoginButton() {
        clickOnElement(loginButton);
        Reporter.log("Click on login button" + loginButton.toString());
        CustomListeners.test.log(Status.PASS, "Click on loginButton");
    }

    public String verifyTextMyAccount() {
        Reporter.log("Verify text my account" + verifyAccountText.toString());
        CustomListeners.test.log(Status.PASS, "Verify text my account");
        return getTextFromElement(verifyAccountText);


    }

}
