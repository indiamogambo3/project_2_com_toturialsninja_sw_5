package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class DesktopsPage extends Utility {

    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement sortBy;

    @CacheLookup
    @FindBy(linkText = "HP LP3065")
    WebElement productHP;


//    public void verifyOriginalProductsOrder() {
//
//        List<WebElement> products = driver.findElements(By.xpath("//h4/a"));
//        ArrayList<String> originalProductName = new ArrayList<>();
//        for (WebElement e : products) {
//            originalProductName.add(e.getText());
//        }
//        Collections.reverse(originalProductName);
//
//        selectByVisibleTextFromDropDown(productZtoA, "Name (Z - A)");
//
//         products = driver.findElements(By.xpath("//h4/a"));
//        ArrayList<String> afterSortByZToAProductName = new ArrayList<>();
//        for (WebElement e : products) {
//            afterSortByZToAProductName.add(e.getText());
//
//        }
//    }

    public void selectSortByPosition(String text) {
        selectByVisibleTextFromDropDown(sortBy, text);
        Reporter.log("Select sort by position" + text + "from sort by drop down" + sortBy.toString());
        CustomListeners.test.log(Status.PASS, "Select sort by position" + text);
    }

    public void selectProductHPLP3065() {
        clickOnElement(productHP);
        Reporter.log("select product HPLP3065" + productHP.toString());
        CustomListeners.test.log(Status.PASS, "select product HPLP3065");
    }

}
