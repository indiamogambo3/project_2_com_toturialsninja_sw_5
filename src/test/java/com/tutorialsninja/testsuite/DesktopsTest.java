package com.tutorialsninja.testsuite;

import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.pages.DesktopsPage;
import com.tutorialsninja.pages.HP_LP3065Page;
import com.tutorialsninja.pages.ShoppingCartPage;
import com.tutorialsninja.pages.TopMenuPage;
import com.tutorialsninja.testbase.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Listeners(CustomListeners.class)

public class DesktopsTest extends BaseTest {

    TopMenuPage topMenuPage;
    DesktopsPage desktopsPage;
    HP_LP3065Page hp_lp3065Page;
    ShoppingCartPage shoppingCartPage;

    @BeforeMethod
    public void inIt() {

        topMenuPage = new TopMenuPage();
        desktopsPage = new DesktopsPage();
        hp_lp3065Page = new HP_LP3065Page();
        shoppingCartPage = new ShoppingCartPage();

    }

    @Test(groups = {"sanity", "regression"})
    public void verifyProductArrangedInAlphabeticalOrder() {

        //1.1 Mouse hover on Desktops Tab.and click
        topMenuPage.mouseHoverAndClickOnDesktops();
        //1.2 Click on “Show All Desktops”
        topMenuPage.clickOnShowAllDesktops();

    }

    public void verifyProductsOrder() {

        //1.3 Select Sort By position "Name: Z to A" and //1.4 Verify the Product will arrange in Descending order.
        List<WebElement> products = driver.findElements(By.xpath("//h4/a"));
        ArrayList<String> originalProductName = new ArrayList<>();
        for (WebElement e : products) {
            originalProductName.add(e.getText());
        }
        Collections.reverse(originalProductName);

        selectByVisibleTextFromDropDown(By.id("input-sort"), "Name (Z - A)");

        products = driver.findElements(By.xpath("//h4/a"));
        ArrayList<String> afterSortByZToAProductName = new ArrayList<>();
        for (WebElement e : products) {
            afterSortByZToAProductName.add(e.getText());

        }
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyProductAddedToShoppingCartSuccessfully() throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        //2.1 Mouse hover on Desktops Tab. and click
        topMenuPage.mouseHoverAndClickOnDesktops();
        //2.2 Click on “Show All Desktops”
        topMenuPage.clickOnShowAllDesktops();
        //2.3 Select Sort By position "Name: A to Z"
        desktopsPage.selectSortByPosition("Name (A - Z)");
        //2.4 Select product “HP LP3065”
        desktopsPage.selectProductHPLP3065();
        //2.5 Verify the Text "HP LP3065"
        softAssert.assertEquals(hp_lp3065Page.verifyHPLP3065Text(), "HP LP3065", "Unable to verify text.");
        //2.6 Select Delivery Date "2022-11-30"
        hp_lp3065Page.selectDeliveryDate();
        //2.7.Enter Qty "1” using Select class.
        hp_lp3065Page.clearQuantity();
        hp_lp3065Page.inputQuantity("1");
        //2.8 Click on “Add to Cart” button
        Thread.sleep(2000);
        hp_lp3065Page.clickOnAddToCartButton();
        //2.9 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
        Thread.sleep(2000);
        softAssert.assertEquals(hp_lp3065Page.messageAddedToShoppingCart(), "Success: You have added HP LP3065 to your shopping cart!\n" + "×", "Unable to verify message.");
        //2.10 Click on link “shopping cart” display into success message
        hp_lp3065Page.clickOnShoppingCartLink();
        //2.11 Verify the text "Shopping Cart"
        softAssert.assertEquals(shoppingCartPage.verifyShoppingCartText(), "Shopping Cart  (1.00kg)", "Unable to verify text.");
        //2.12 Verify the Product name "HP LP3065"
        softAssert.assertEquals(shoppingCartPage.verifyProductName(), "HP LP3065", "Unable to verify name.");
        //2.13 Verify the Delivery Date "2022-11-30"
        Thread.sleep(2000);
        softAssert.assertEquals(shoppingCartPage.verifyDeliveryDate(), "Delivery Date:2022-11-30", "Unable to verify date.");
        //2.14 Verify the Model "Product21"
        Thread.sleep(3000);
        softAssert.assertEquals(shoppingCartPage.verifyModelName(), "Product 21", "Unable to verify model");
        //2.15 Verify the Total "£74.73"
        shoppingCartPage.selectCurrencyTab();
        shoppingCartPage.selectPoundsSterling();
        softAssert.assertEquals(shoppingCartPage.verifyTheTotal(), "£74.73", "Unable to verify total.");
        softAssert.assertAll();
    }

}
