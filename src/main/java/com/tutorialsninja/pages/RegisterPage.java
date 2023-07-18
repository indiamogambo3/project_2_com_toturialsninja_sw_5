package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class RegisterPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Register Account')]")
    WebElement registerText;
    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Returning Customer')]")
    WebElement returningText;
    @CacheLookup
    @FindBy(id = "input-firstname")
    WebElement firstNameField;
    @CacheLookup
    @FindBy(id = "input-lastname")
    WebElement lastNameField;
    @CacheLookup
    @FindBy(id = "input-email")
    WebElement emailField;
    @CacheLookup
    @FindBy(id = "input-telephone")
    WebElement telephoneField;
    @CacheLookup
    @FindBy(id = "input-password")
    WebElement passwordField;
    @CacheLookup
    @FindBy(id = "input-confirm")
    WebElement confirmPasswordField;
    @CacheLookup
    @FindBy(name = "newsletter")
    WebElement newsletterRadio;
    @CacheLookup
    @FindBy(name = "agree")
    WebElement privacyPolicy;
    @CacheLookup
    @FindBy(xpath = "//input[@type = 'submit']")
    WebElement continueButton;


    public String verifyTextRegisterAccount() {
        Reporter.log("Verify text register account" + registerText.toString());
        CustomListeners.test.log(Status.PASS, "Verify text register account");
        return getTextFromElement(registerText);
    }

    public String verifyTextReturningCustomer() {
        Reporter.log("Verify text returning customer" + returningText.toString());
        CustomListeners.test.log(Status.PASS, "Verify text returning customer");
        return getTextFromElement(returningText);
    }

    public void enterFirstName(String firstName) {
        sendTextToElement(firstNameField, firstName);
        Reporter.log("Enter first name" + firstName + "to password field" + firstNameField.toString());
        CustomListeners.test.log(Status.PASS, "Enter first name " + firstName);
    }

    public void enterLastName(String lastName) {
        sendTextToElement(lastNameField, lastName);
        Reporter.log("Enter last name" + lastName + "to password field" + lastNameField.toString());
        CustomListeners.test.log(Status.PASS, "Enter last name " + lastName);
    }

    public void enterEmailName(String email) {
        sendTextToElement(emailField, email);
        Reporter.log("Enter email" + email + "to password field" + emailField.toString());
        CustomListeners.test.log(Status.PASS, "Enter email " + email);
    }

    public void enterTelephoneNumber(String telephoneNumber) {
        sendTextToElement(telephoneField, telephoneNumber);
        Reporter.log("Enter telephone number" + telephoneNumber + "to password field" + telephoneField.toString());
        CustomListeners.test.log(Status.PASS, "Enter telephone number " + telephoneNumber);
    }

    public void enterPassword(String password) {
        sendTextToElement(passwordField, password);
        Reporter.log("Enter password" + password + "to password field" + passwordField.toString());
        CustomListeners.test.log(Status.PASS, "Enter password " + password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        sendTextToElement(confirmPasswordField, confirmPassword);
        Reporter.log("Enter confirm password" + confirmPassword + "to password field" + confirmPasswordField.toString());
        CustomListeners.test.log(Status.PASS, "Enter confirm password " + confirmPassword);
    }

    public void selectSubscribeYesRadioButton() {
        clickOnElement(newsletterRadio);
        Reporter.log("Select subscribe yes radio button" + newsletterRadio.toString());
        CustomListeners.test.log(Status.PASS, "Select subscribe yes radio button");
    }

    public void clickOnPrivacyPolicy() {
        clickOnElement(privacyPolicy);
        Reporter.log("Click on privacy policy" + privacyPolicy.toString());
        CustomListeners.test.log(Status.PASS, "Click on privacy policy");
    }

    public void clickOnContinueButton() {
        clickOnElement(continueButton);
        Reporter.log("Click on continue button" + continueButton.toString());
        CustomListeners.test.log(Status.PASS, "Click on continue button");
    }

}
