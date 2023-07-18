package com.tutorialsninja.testsuite;

import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.pages.*;
import com.tutorialsninja.testbase.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Listeners(CustomListeners.class)

public class LaptopsAndNotebooksTest extends BaseTest {

    TopMenuPage topMenuPage;
    LaptopsAndNotebooksPage laptopsAndNotebooksPage;
    MacBookPage macBookPage;
    ShoppingCartPage shoppingCartPage;
    CheckoutPage checkoutPage;

    @BeforeMethod
    public void inIt() {

        topMenuPage = new TopMenuPage();
        laptopsAndNotebooksPage = new LaptopsAndNotebooksPage();
        macBookPage = new MacBookPage();
        shoppingCartPage = new ShoppingCartPage();
        checkoutPage = new CheckoutPage();
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {

        //1.1 Mouse hover on Laptops & Notebooks Tab.and click
        topMenuPage.mouseHoverAndClickOnLaptopsAndNotebooks();
        //1.2 Click on “Show All Laptops & Notebooks”
        topMenuPage.clickOnShowAllLaptopsAndNotebooks();
    }


    public void verifyPriceOrder() {

        //1.3 Select Sort By "Price (High > Low)" and Verify the Product price will arrange in High to Low order
        List<WebElement> products = driver.findElements(By.xpath("//p[@class ='price']"));
        List<Double> originalProductPrice = new ArrayList<>();
        for (WebElement e : products) {
            String[] arr = e.getText().split("Ex Tax:");
            originalProductPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        Collections.sort(originalProductPrice, Collections.reverseOrder());

        selectByVisibleTextFromDropDown(By.id("input-sort"), "Price (High > Low)");

        products = driver.findElements(By.xpath("//p[@class ='price']"));
        ArrayList<Double> afterSortByPrice = new ArrayList<>();
        for (WebElement e : products) {
            String[] arr = e.getText().split("Ex Tax:");
            afterSortByPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }

        Assert.assertEquals(afterSortByPrice, originalProductPrice, "Product not sorted by price High to Low");
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        //2.1 Mouse hover on Laptops & Notebooks Tab and click
        topMenuPage.mouseHoverAndClickOnLaptopsAndNotebooks();
        //2.2 Click on “Show All Laptops & Notebooks”
        topMenuPage.clickOnShowAllLaptopsAndNotebooks();
        //2.3 Select Sort By "Price (High > Low)"
        laptopsAndNotebooksPage.selectSortByPriceHighToLow("Price (High > Low)");
        //2.4 Select Product “MacBook”
        laptopsAndNotebooksPage.selectProductMacBook();
        //2.5 Verify the text “MacBook”
        softAssert.assertEquals(macBookPage.verifyTextMacBook(), "MacBook", "Unable to verify text");
        //2.6 Click on ‘Add To Cart’ button
        macBookPage.clickOnAddToCartButton();
        //2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        softAssert.assertEquals(macBookPage.verifyMacBookAddedToShoppingCart(), "Success: You have added MacBook to your shopping cart!\n" + "×", "Unable to verify message");
        //2.8 Click on link “shopping cart” display into success message
        macBookPage.clickOnShoppingCartLink();
        //2.9 Verify the text "Shopping Cart"
        softAssert.assertEquals(shoppingCartPage.verifyShoppingCartText(), "Shopping Cart  (0.00kg)", "Unable to verify text.");
        //2.10 Verify the Product name "MacBook"
        softAssert.assertEquals(shoppingCartPage.verifyProductName(), "MacBook", "Unable to verify name.");
        //2.11 Change Quantity "2"
        Thread.sleep(2000);
        shoppingCartPage.clearQuantity();
        shoppingCartPage.inputQuantity("2");
        //2.12 Click on “Update” Tab
        shoppingCartPage.clickOnUpdateTab();
        //2.13 Verify the message “Success: You have modified your shopping cart!”
        softAssert.assertEquals(shoppingCartPage.modifiedMessage(), "Success: You have modified your shopping cart!\n" + "×", "Unable to confirm message.");
        //2.14 Verify the Total £737.45
        shoppingCartPage.selectCurrencyTab();
        shoppingCartPage.selectPoundsSterling();
        softAssert.assertEquals(shoppingCartPage.verifyTheTotal(), "£737.45", "Unable to verify total.");
        //2.15 Click on “Checkout” button
        shoppingCartPage.clickOnCheckOutButton();
        //2.16 Verify the text “Checkout”
        softAssert.assertEquals(checkoutPage.verifyCheckoutText(), "Checkout", "Unable to verify text.");
        //2.17 Verify the Text “New Customer”
        Thread.sleep(2000);
        softAssert.assertEquals(checkoutPage.verifyNewCustomerText(), "New Customer", "Unable to verify text.");
        //2.18 Click on “Guest Checkout” radio button
        checkoutPage.clickOnGuestRadioButton();
        //2.19 Click on “Continue” tab
        checkoutPage.clickOnContinueTab();
        //2.20 Fill the mandatory fields
        checkoutPage.enterFirstName("Mukz");
        checkoutPage.enterLastName("Shah");
        checkoutPage.enterEmail("kkkk123@gmail.com");
        checkoutPage.enterTelephoneNumber("07745365214");
        checkoutPage.enterAddressLine1("123 Best Street");
        checkoutPage.enterCity("London");
        checkoutPage.enterPostCode("LN1 1LN");
        checkoutPage.enterCountry("United Kingdom");
        checkoutPage.enterRegion("Merseyside");
        //2.21 Click on “Continue” Button
        checkoutPage.clickOnContinueButton();
        //2.22 Add Comments About your order into text area
        Thread.sleep(2000);
        checkoutPage.addCommentsAboutOrder("Please dispatch as soon as possible.");
        //2.23 Check the Terms & Conditions check box
        checkoutPage.clickOnTermsAndConditions();
        //2.24 Click on “Continue” button
        checkoutPage.clickOnContinueButtonOnPayment();
        //2.25 Verify the message “Warning: Payment method required!”
        softAssert.assertEquals(checkoutPage.verifyWarningMessage(), "Warning: Payment method required!\n" + "×", "Unable to verify message.");
        softAssert.assertAll();

    }

}
