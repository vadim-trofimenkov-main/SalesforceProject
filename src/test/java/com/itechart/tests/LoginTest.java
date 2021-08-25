package com.itechart.tests;

import com.itechart.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {

    @Test(description = "Login with correct credentials")
    public void loginTest() {
        HomePage homePage =
                loginPage.
                        open().
                        login(USERNAME, PASSWORD);
        Assert.assertTrue(homePage.isPageOpened(), "Login is not completed");
    }

    @Test(description = "Login with incorrect username")
    public void usernameShouldBeRequired() {
        loginPage.
                open().
                login("", PASSWORD);
        Assert.assertTrue(loginPage.isUsernameDisplayed(), "Username validation is not working.");
    }

    @Test(description = "Login with incorrect password")
    public void passwordShouldBeRequired() {
        loginPage.
                open().
                login(USERNAME, "");
        Assert.assertEquals(loginPage.getErrorMessage(), "Please enter your password.",
                "Password validation is not working.");
    }
}
