package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class CheckoutPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Checkout')]")
    WebElement verifyCheckoutText;

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'New Customer')]")
    WebElement verifyNewCustomer;

    @CacheLookup
    @FindBy(xpath = "//input[@value = 'guest']")
    WebElement guestRadioButton;

    @CacheLookup
    @FindBy(id = "button-account")
    WebElement continueTab;

    @CacheLookup
    @FindBy(id = "input-payment-firstname")
    WebElement firstNameField;

    @CacheLookup
    @FindBy(id = "input-payment-lastname")
    WebElement lastNameField;

    @CacheLookup
    @FindBy(id = "input-payment-email")
    WebElement emailField;

    @CacheLookup
    @FindBy(id = "input-payment-telephone")
    WebElement telephoneNumberField;

    @CacheLookup
    @FindBy(id = "input-payment-address-1")
    WebElement address1Field;

    @CacheLookup
    @FindBy(id = "input-payment-city")
    WebElement cityField;

    @CacheLookup
    @FindBy(id = "input-payment-postcode")
    WebElement postCodeField;

    @CacheLookup
    @FindBy(id = "input-payment-country")
    WebElement countryField;

    @CacheLookup
    @FindBy(id = "input-payment-zone")
    WebElement regionField;

    @CacheLookup
    @FindBy(id = "button-guest")
    WebElement continueButton;

    @CacheLookup
    @FindBy(tagName = "textarea")
    WebElement addComments;

    @CacheLookup
    @FindBy(xpath = "//input[@id='button-shipping-method']")
    WebElement continueTabDeliveryMethod;

    @CacheLookup
    @FindBy(name = "agree")
    WebElement termsAndConditions;

    @CacheLookup
    @FindBy(xpath = "//input[@id='button-payment-method']")
    WebElement continueButtonOnPayment;

    @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    WebElement paymentMethod;


    public String verifyCheckoutText() {
        Reporter.log("Verify checkout text" + verifyCheckoutText.toString());
        CustomListeners.test.log(Status.PASS, "Verify checkout text");
        return getTextFromElement(verifyCheckoutText);
    }

    public String verifyNewCustomerText() {
        Reporter.log("Verify new customer text" + verifyNewCustomer.toString());
        CustomListeners.test.log(Status.PASS, "Verify new customer text");
        return getTextFromElement(verifyNewCustomer);
    }

    public void clickOnGuestRadioButton() {
        clickOnElement(guestRadioButton);
        Reporter.log("Click on guest radio button" + guestRadioButton.toString());
        CustomListeners.test.log(Status.PASS, "Click on guest radio button");
    }

    public void clickOnContinueTab() {
        clickOnElement(continueTab);
        Reporter.log("Click on continue tab" + continueTab.toString());
        CustomListeners.test.log(Status.PASS, "Click on continue tab");
    }

    public void enterFirstName(String firstName) {
        sendTextToElement(firstNameField, firstName);
        Reporter.log("Enter first name" + firstName + "to first name field" + firstNameField.toString());
        CustomListeners.test.log(Status.PASS, "Enter first name " + firstName);
    }

    public void enterLastName(String lastName) {
        sendTextToElement(lastNameField, lastName);
        Reporter.log("Enter last name" + lastName + "to last name field" + lastNameField.toString());
        CustomListeners.test.log(Status.PASS, "Enter last name " + lastName);
    }

    public void enterEmail(String email) {
        sendTextToElement(emailField, email);
        Reporter.log("Enter email" + email + "to email field" + emailField.toString());
        CustomListeners.test.log(Status.PASS, "Enter email " + email);
    }

    public void enterTelephoneNumber(String number) {
        sendTextToElement(telephoneNumberField, number);
        Reporter.log("Enter telephone number" + number + "to telephone number field" + telephoneNumberField.toString());
        CustomListeners.test.log(Status.PASS, "Enter telephone number " + number);
    }

    public void enterAddressLine1(String text) {
        sendTextToElement(address1Field, text);
        Reporter.log("Enter address line 1" + text + "to address line 1 field" + address1Field.toString());
        CustomListeners.test.log(Status.PASS, "Enter address 1 field " + text);
    }

    public void enterCity(String text) {
        sendTextToElement(cityField, text);
        Reporter.log("Enter city" + text + "to city field" + cityField.toString());
        CustomListeners.test.log(Status.PASS, "Enter city" + text);
    }

    public void enterPostCode(String text) {
        sendTextToElement(postCodeField, text);
        Reporter.log("Enter post code" + text + "to post code field" + postCodeField.toString());
        CustomListeners.test.log(Status.PASS, "Enter post code" + text);
    }

    public void enterCountry(String text) {
        selectByVisibleTextFromDropDown(countryField, text);
        Reporter.log("Enter country" + text + "to country field" + cityField.toString());
        CustomListeners.test.log(Status.PASS, "Enter country" + text);
    }

    public void enterRegion(String text) {
        sendTextToElement(regionField, text);
        Reporter.log("Enter region" + text + "to region field" + regionField.toString());
        CustomListeners.test.log(Status.PASS, "Enter region" + text);
    }

    public void clickOnContinueButton() {
        clickOnElement(continueButton);
        Reporter.log("Click on continue button" + continueButton.toString());
        CustomListeners.test.log(Status.PASS, "Click on continue button");
    }

    public void addCommentsAboutOrder(String text) {
        sendTextToElement(addComments, text);
        Reporter.log("Enter add comments about order" + text + "to add comments field" + addComments.toString());
        CustomListeners.test.log(Status.PASS, "Enter add comments about order" + text);
    }

    public void clickOnContinue() {
        clickOnElement(continueTabDeliveryMethod);
        Reporter.log("Click on continue" + continueTabDeliveryMethod.toString());
        CustomListeners.test.log(Status.PASS, "Click on continue");

    }

    public void clickOnTermsAndConditions() {
        clickOnElement(termsAndConditions);
        Reporter.log("Click on terms and conditions" + termsAndConditions.toString());
        CustomListeners.test.log(Status.PASS, "Click on terms and conditions");
    }

    public void clickOnContinueButtonOnPayment() {
        clickOnElement(continueButtonOnPayment);
        Reporter.log("Click on continue button on payment" + continueButtonOnPayment.toString());
        CustomListeners.test.log(Status.PASS, "Click on continue button on payment");
    }

    public String verifyWarningMessage() {
        Reporter.log("Verify warning message" + paymentMethod.toString());
        CustomListeners.test.log(Status.PASS, "Verify warning message");
        return getTextFromElement(paymentMethod);

    }

}
