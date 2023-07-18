package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class TopMenuPage extends Utility {

    @CacheLookup
    @FindBy(linkText = "Desktops")
    WebElement desktops;
    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Desktops')]")
    WebElement verifyDesktops;
    @CacheLookup
    @FindBy(linkText = "Laptops & Notebooks")
    WebElement laptopsAndNotebooks;
    ;
    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Laptops & Notebooks')]")
    WebElement verifyLaptopsAndNotebooks;
    @CacheLookup
    @FindBy(linkText = "Components")
    WebElement components;
    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Components')]")
    WebElement verifyComponents;
    @CacheLookup
    @FindBy(linkText = "Show AllDesktops")
    WebElement allDesktops;
    @CacheLookup
    @FindBy(linkText = "Show AllLaptops & Notebooks")
    WebElement allLaptopsAndNotebooks;


    public void selectMenu(String menu) {
        driver.findElement(By.linkText(menu)).click();
        Reporter.log("Select menu" + menu + "menu");
        CustomListeners.test.log(Status.PASS, "Select menu" + menu);
    }

    public void mouseHoverAndClickOnDesktops() {
        mouseHoverToElementAndClick(desktops);
        Reporter.log("Mouse hover and click on desktops" + desktops.toString());
        CustomListeners.test.log(Status.PASS, "Mouse hover and click on desktops");
    }

    public String verifyTextDesktops() {
        Reporter.log("Verify text desktops" + verifyDesktops.toString());
        CustomListeners.test.log(Status.PASS, "Verify text desktops");
        return getTextFromElement(verifyDesktops);
    }

    public void mouseHoverAndClickOnLaptopsAndNotebooks() {
        mouseHoverToElementAndClick(laptopsAndNotebooks);
        Reporter.log("Mouse hover and click on laptops and notebooks" + laptopsAndNotebooks.toString());
        CustomListeners.test.log(Status.PASS, "Mouse hover and click on laptops and notebooks");
    }

    public String verifyTextLaptopsAndNotebooks() {
        Reporter.log("Verify text laptops and notebooks" + verifyLaptopsAndNotebooks.toString());
        CustomListeners.test.log(Status.PASS, "Verify text laptops and notebooks");
        return getTextFromElement(verifyLaptopsAndNotebooks);
    }

    public void mouseHoverAndClickComponents() {
        mouseHoverToElementAndClick(components);
        Reporter.log("Mouse hover and click components" + components.toString());
        CustomListeners.test.log(Status.PASS, "Mouse hover and click components");
    }

    public String verifyTextComponents() {
        Reporter.log("Verify text components" + components.toString());
        CustomListeners.test.log(Status.PASS, "Verify text components");
        return getTextFromElement(verifyComponents);
    }

    public void clickOnShowAllDesktops() {
        clickOnElement(allDesktops);
        Reporter.log("Click on show all desktops" + allDesktops.toString());
        CustomListeners.test.log(Status.PASS, "Click on show all desktops");
    }

    public void clickOnShowAllLaptopsAndNotebooks() {
        clickOnElement(allLaptopsAndNotebooks);
        Reporter.log("Click on show all laptops and notebooks" + allDesktops.toString());
        CustomListeners.test.log(Status.PASS, "Click on show all laptops and notebooks");
    }

}
