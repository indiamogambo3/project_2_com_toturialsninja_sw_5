package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class MyAccountsPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'My Account')]")
    WebElement myAccountLink;


    public void selectMyAccountOptions(String option) {

        List<WebElement> registerList = driver.findElements(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']/li"));
        for (WebElement element : registerList) {
            if (element.getText().equals(option)) {
                element.click();
                break;
            }
        }
    }

    public void clickOnRegisterOption() {
        selectMyAccountOptions("Register");
        Reporter.log("Click on register option");
        CustomListeners.test.log(Status.PASS, "Click on register option");
    }

    public void clickOnLoginOption() {
        selectMyAccountOptions("Login");
        Reporter.log("Click on Login option");
        CustomListeners.test.log(Status.PASS, "Click on Login option");
    }

    public void clickOnLogoutOption() {
        selectMyAccountOptions("Logout");
        Reporter.log("Click on Logout option");
        CustomListeners.test.log(Status.PASS, "Click on Logout option");
    }

    public void clickOnMyAccountLink() {
//        clickOnElement(myAccountLink);
        try{
            driver.findElement(By.xpath("//span[contains(text(),'My Account')]")).click();

        }catch (StaleElementReferenceException e) {

        }
        Reporter.log("Click on my account link" + myAccountLink.toString());
        CustomListeners.test.log(Status.PASS, "Click on my account link");
    }

}


