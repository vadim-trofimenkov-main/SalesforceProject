package com.itechart.tests;

import com.itechart.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {

    @Test
    public void loginTest() {
        HomePage homePage = loginPage.login(USERNAME, PASSWORD);
        Assert.assertTrue(homePage.isPageOpened(), "Login is not completed");
    }

    @Test
    public void usernameShouldBeRequired() {
        loginPage.login("", PASSWORD);
        Assert.assertTrue(loginPage.isUsernameDisplayed(), "Username validation is not working.");
    }

    @Test
    public void passwordShouldBeRequired() {
        loginPage.login(USERNAME, "");
        Assert.assertEquals(loginPage.getErrorMessage(), "Please enter your password.",
                "Password validation is not working.");
    }
}
