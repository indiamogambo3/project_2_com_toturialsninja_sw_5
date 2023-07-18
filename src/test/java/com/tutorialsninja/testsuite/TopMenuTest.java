package com.tutorialsninja.testsuite;

import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.pages.TopMenuPage;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Listeners(CustomListeners.class)

public class TopMenuTest extends BaseTest {

    TopMenuPage topMenuPage;

    @BeforeMethod
    public void inIt() {

        topMenuPage = new TopMenuPage();

    }

    @Test(groups = {"sanity", "regression"})
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        SoftAssert softAssert = new SoftAssert();

        //1.1 Mouse hover on “Desktops” Tab and click
        topMenuPage.mouseHoverAndClickOnDesktops();
        //1.2 call selectMenu method and pass the menu = “Show All Desktops”
        topMenuPage.selectMenu("Show AllDesktops");
        //1.3 Verify the text ‘Desktops’
        softAssert.assertEquals(topMenuPage.verifyTextDesktops(), "Desktops", "Unable to verify text.");
        softAssert.assertAll();
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {

        SoftAssert softAssert = new SoftAssert();

        //2.1 Mouse hover on “Laptops & Notebooks” Tab and click
        topMenuPage.mouseHoverAndClickOnLaptopsAndNotebooks();
        //2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
        topMenuPage.selectMenu("Show AllLaptops & Notebooks");
        //2.3 Verify the text ‘Laptops & Notebooks’
        softAssert.assertEquals(topMenuPage.verifyTextLaptopsAndNotebooks(), "Laptops & Notebooks", "Unable to verify text.");
        softAssert.assertAll();
    }

    @Test(groups = {"regression"})
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {

        SoftAssert softAssert = new SoftAssert();

        //3.1 Mouse hover on “Components” Tab and click
        topMenuPage.mouseHoverAndClickComponents();
        //3.2 call selectMenu method and pass the menu = “Show All Components”
        topMenuPage.selectMenu("Show AllComponents");
        //3.3 Verify the text ‘Components’
        softAssert.assertEquals(topMenuPage.verifyTextComponents(), "Components", "Unable to verify text.");
        softAssert.assertAll();
    }

}
