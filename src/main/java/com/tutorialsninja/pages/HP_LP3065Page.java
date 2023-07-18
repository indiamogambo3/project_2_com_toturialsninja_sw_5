package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class HP_LP3065Page extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'HP LP3065')]")
    WebElement verifyText;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'input-group date']//button")
    WebElement deliveryDate;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'datepicker']/div[1]//th[@class='picker-switch']")
    WebElement monthYear;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'datepicker']/div[1]//th[@class='next']")
    WebElement datePicker;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'datepicker']/div[1]//tbody/tr/td[@class = 'day']")
    WebElement dates;
    @CacheLookup
    @FindBy(id = "input-quantity")
    WebElement quantity;
    @CacheLookup
    @FindBy(id = "button-cart")
    WebElement cartButton;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'alert alert-success alert-dismissible']")
    WebElement successMessage;
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Shopping Cart')]")
    WebElement shoppingCartLink;



    public String verifyHPLP3065Text() {
        Reporter.log("Verify HPLP3065 text" +  verifyText.toString());
        CustomListeners.test.log(Status.PASS, "Verify HPLP3065 text");
        return getTextFromElement(verifyText);
    }


    public void selectDeliveryDate() {

        String year = "2022";
        String month = "November";
        String date = "30";

        clickOnElement(deliveryDate);

        while (true) {
            String monthAndYear = getTextFromElement(monthYear);
            String arr[] = monthAndYear.split(" ");
            String mon = arr[0];
            String yer = arr[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(datePicker);
            }
        }

        List<WebElement> allDates = driver.findElements(By.xpath("//div[@class = 'datepicker']/div[1]//tbody/tr/td[@class = 'day']"));
        for (WebElement e : allDates) {
            if (e.getText().equalsIgnoreCase(date)) {
                e.click();
                break;
            }
        }
    }

    public void clearQuantity() {
        driver.findElement(By.id("input-quantity")).clear();
        Reporter.log("Clear quantity" +  quantity.toString());
        CustomListeners.test.log(Status.PASS, "Clear quantity");
    }

    public void inputQuantity(String text) {
        sendTextToElement(quantity, text);
        Reporter.log("Input quantity" + text + "to input quantity field" + quantity.toString());
        CustomListeners.test.log(Status.PASS, "Input quantity" + text);
    }

    public void clickOnAddToCartButton() {
        clickOnElement(cartButton);
        Reporter.log("Click on add to cart button" +  cartButton.toString());
        CustomListeners.test.log(Status.PASS, "Click on add to cart button");
    }

    public String messageAddedToShoppingCart() {
        Reporter.log("Message added to shopping cart" +  successMessage.toString());
        CustomListeners.test.log(Status.PASS, "Message added to shopping cart");
        return getTextFromElement(successMessage);
    }

    public void clickOnShoppingCartLink() {
        clickOnElement(shoppingCartLink);
        Reporter.log("Click on shopping cart link" +  shoppingCartLink.toString());
        CustomListeners.test.log(Status.PASS, "Click on shopping cart link");
    }

}
