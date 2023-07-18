package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class MacBookPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'MacBook')]")
    WebElement verifyMacBook;
    @CacheLookup
    @FindBy(id = "button-cart")
    WebElement addToCart;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'alert alert-success alert-dismissible']")
    WebElement verifySuccessMessage;
    @CacheLookup
    @FindBy(linkText = "shopping cart")
    WebElement shoppingCartLink;


    public String verifyTextMacBook() {
        Reporter.log("Verify text MacBook" + verifyMacBook.toString());
        CustomListeners.test.log(Status.PASS, "Verify text MacBook");
        return getTextFromElement(verifyMacBook);
    }

    public void clickOnAddToCartButton() {
        clickOnElement(addToCart);
        Reporter.log("Click on add to cart button" + addToCart.toString());
        CustomListeners.test.log(Status.PASS, "Click on add to cart button");
    }

    public String verifyMacBookAddedToShoppingCart() {
        Reporter.log("Verify MacBook added to shopping cart" + verifySuccessMessage.toString());
        CustomListeners.test.log(Status.PASS, "Verify MacBook added to shopping cart");
        return getTextFromElement(verifySuccessMessage);
    }

    public void clickOnShoppingCartLink() {
        clickOnElement(shoppingCartLink);
        Reporter.log("Click on shopping cart link" + shoppingCartLink.toString());
        CustomListeners.test.log(Status.PASS, "Click on shopping cart link");
    }

}
