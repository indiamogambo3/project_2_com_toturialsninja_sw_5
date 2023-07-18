package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class LaptopsAndNotebooksPage extends Utility {

    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement sortPrice;
    @CacheLookup
    @FindBy(linkText = "MacBook")
    WebElement macBook;


    public void selectSortByPriceHighToLow(String text) {
        selectByVisibleTextFromDropDown(sortPrice, text);
        Reporter.log("Select sort by price high to low" + text + "in sort by price filter" + sortPrice.toString());
        CustomListeners.test.log(Status.PASS, "Select sort by price high to low" + text);
    }

    public void selectProductMacBook() {
        clickOnElement(macBook);
        Reporter.log("Select product MacBook" + macBook.toString());
        CustomListeners.test.log(Status.PASS, "Select product MacBook");
    }

}
