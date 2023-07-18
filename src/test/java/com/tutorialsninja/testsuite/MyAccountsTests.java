package com.tutorialsninja.testsuite;

import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.pages.*;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Listeners(CustomListeners.class)

public class MyAccountsTests extends BaseTest {

    MyAccountsPage myAccountsPage;
    RegisterPage registerPage;
    SuccessPage successPage;
    LogoutPage logoutPage;
    LoginPage loginPage;

    @BeforeMethod
    public void inIt() {

        myAccountsPage = new MyAccountsPage();
        registerPage = new RegisterPage();
        successPage = new SuccessPage();
        logoutPage = new LogoutPage();
        loginPage = new LoginPage();
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyUserShouldShouldNavigateToRegisterPageSuccessfully() {

        SoftAssert softAssert = new SoftAssert();

        //1.1 Click on My Account Link.
        myAccountsPage.clickOnMyAccountLink();
        //1.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        myAccountsPage.clickOnRegisterOption();
        //1.3 Verify the text “Register Account”.
        softAssert.assertEquals(registerPage.verifyTextRegisterAccount(), "Register Account", "Unable to verify text.");
        softAssert.assertAll();
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {

        SoftAssert softAssert = new SoftAssert();

        //2.1 Click on My Account Link.
        myAccountsPage.clickOnMyAccountLink();
        //2.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        myAccountsPage.clickOnLoginOption();
        //2.3 Verify the text “Returning Customer”.
        softAssert.assertEquals(registerPage.verifyTextReturningCustomer(), "Returning Customer", "Unable to verify text.");
        softAssert.assertAll();
    }

    @Test(groups = {"regression"})
    public void verifyThatUserRegisterAccountSuccessfully() throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        //3.1 Click on My Account Link.
        myAccountsPage.clickOnMyAccountLink();
        //3.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        myAccountsPage.clickOnRegisterOption();
        //3.3 Enter First Name
        registerPage.enterFirstName("Mukz");
        //3.4 Enter Last Name
        registerPage.enterLastName("Shah");
        //3.5 Enter Email
        registerPage.enterEmailName("mogambo123456@gmail.com");
        //3.6 Enter Telephone
        registerPage.enterTelephoneNumber("07125698742");
        //3.7 Enter Password
        registerPage.enterPassword("Mukz123");
        //3.8 Enter Password Confirm
        registerPage.enterConfirmPassword("Mukz123");
        //3.9 Select Subscribe Yes radio button
        registerPage.selectSubscribeYesRadioButton();
        //3.10 Click on Privacy Policy check box
        registerPage.clickOnPrivacyPolicy();
        //3.11 Click on Continue button
        registerPage.clickOnContinueButton();
        //3.12 Verify the message “Your Account Has Been Created!”
        Thread.sleep(2000);
        softAssert.assertEquals(successPage.verifyAccountHasBeenCreatedMessage(), "Your Account Has Been Created!", "Unable to verify message.");
        //3.13 Click on Continue button
        successPage.clickOnContinueButton();
        //3.14 Click on My Account Link.
        Thread.sleep(2000);
        myAccountsPage.clickOnMyAccountLink();
        //3.15 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        myAccountsPage.clickOnLogoutOption();
        //3.16 Verify the text “Account Logout”
        softAssert.assertEquals(logoutPage.verifyAccountLogoutText(), "Account Logout", "Unable to verify text.");
        //3.17 Click on Continue button
        logoutPage.clickOnContinueButton();
        softAssert.assertAll();
    }

    @Test(groups = {"regression"})
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        //4.1 Click on My Account Link.
        myAccountsPage.clickOnMyAccountLink();
        //4.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        myAccountsPage.clickOnLoginOption();
        //4.3 Enter Email address
        loginPage.enterEmail("mogambo123456@gmail.com");
        //4.4 Enter Password
        loginPage.enterPassword("Mukz123");
        //4.5 Click on Login button
        loginPage.clickOnLoginButton();
        //4.6 Verify text “My Account”
        softAssert.assertEquals(loginPage.verifyTextMyAccount(), "My Account", "Unable to verify text");
        //4.7 Click on My Account Link.
        Thread.sleep(2000);
        myAccountsPage.clickOnMyAccountLink();
        //4.8 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        myAccountsPage.clickOnLogoutOption();
        //4.9 Verify the text “Account Logout”
        softAssert.assertEquals(logoutPage.verifyAccountLogoutText(), "Account Logout", "Unable to verify text.");
        //4.10 Click on Continue button
        logoutPage.clickOnContinueButton();
        softAssert.assertAll();
    }

}
