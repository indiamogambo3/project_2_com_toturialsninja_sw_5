package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class ShoppingCartPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//div[@id='content']/h1")
    WebElement shoppingCartText;
    @CacheLookup
    @FindBy(xpath = "//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]")
    WebElement productNameText;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[2]/small[1]")
    WebElement deliveryDate;
    @CacheLookup
    @FindBy(xpath = "//td[contains(text(),'Product 21')]")
    WebElement modelName;
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Currency')]")
    WebElement selectCurrency;
    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'£Pound Sterling')]")
    WebElement selectPounds;
    @CacheLookup
    @FindBy(xpath = "//tbody/tr[1]/td[6]")
    WebElement verifyTotal;
    @CacheLookup
    @FindBy(xpath = "//input[@value = '1']")
    WebElement quantity;
    @CacheLookup
    @FindBy(xpath = "//i[@class ='fa fa-refresh']")
    WebElement update;
    @CacheLookup
    @FindBy(xpath = "//body/div[@id='checkout-cart']/div[1]")
    WebElement verifyUpdateMessage;
    @CacheLookup
    @FindBy(linkText = "Checkout")
    WebElement checkoutButton;

    public String verifyShoppingCartText() {
        Reporter.log("Verify shopping cart text" + shoppingCartText.toString());
        CustomListeners.test.log(Status.PASS, "Verify shopping cart text");
        return getTextFromElement(shoppingCartText);
    }

    public String verifyProductName() {
        Reporter.log("Verify product name" + productNameText.toString());
        CustomListeners.test.log(Status.PASS, "Verify product name");
        return getTextFromElement(productNameText);
    }

    public String verifyDeliveryDate() {
        Reporter.log("Verify delivery date" + deliveryDate.toString());
        CustomListeners.test.log(Status.PASS, "Verify delivery date");
        return getTextFromElement(deliveryDate);
    }

    public String verifyModelName() {
        Reporter.log("Verify model name" + modelName.toString());
        CustomListeners.test.log(Status.PASS, "Verify model name");
        return getTextFromElement(modelName);
    }

    public void selectCurrencyTab() {
        clickOnElement(selectCurrency);
        Reporter.log("Select currency tab" + selectCurrency.toString());
        CustomListeners.test.log(Status.PASS, "Select currency tab");
    }

    public void selectPoundsSterling() {
        clickOnElement(selectPounds);
        Reporter.log("Select Pounds Sterling" + selectPounds.toString());
        CustomListeners.test.log(Status.PASS, "Select Pounds Sterling");
    }

    public String verifyTheTotal() {
        Reporter.log("Verify the total" + verifyTotal.toString());
        CustomListeners.test.log(Status.PASS, "Verify the total");
        return getTextFromElement(verifyTotal);
    }

    public void clearQuantity() {
        driver.findElement(By.xpath("//input[@value = '1']")).clear();
        Reporter.log("Clear quantity");
        CustomListeners.test.log(Status.PASS, "Clear quantity");
    }

    public void inputQuantity(String text) {
        sendTextToElement(quantity, text);
        Reporter.log("Input quantity" + text + "to quantity field" + quantity.toString());
        CustomListeners.test.log(Status.PASS, "Input quantity" + text);
    }

    public void clickOnUpdateTab() {
        clickOnElement(update);
        Reporter.log("Click on update tab" + update.toString());
        CustomListeners.test.log(Status.PASS, "Click on update tab");
    }

    public String modifiedMessage() {
        Reporter.log("Modified message" + verifyUpdateMessage.toString());
        CustomListeners.test.log(Status.PASS, "Modified message");
        return getTextFromElement(verifyUpdateMessage);
    }

    public void clickOnCheckOutButton() {
        clickOnElement(checkoutButton);
        Reporter.log("Click on check out button" + checkoutButton.toString());
        CustomListeners.test.log(Status.PASS, "Click on check out button");
    }

}
