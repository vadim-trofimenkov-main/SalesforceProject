package com.itechart.tests;

import com.itechart.tests.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    private final String USERNAME = propertyReader.getPropertyValueByKey("username");
    private final String PASSWORD = propertyReader.getPropertyValueByKey("password");

    @Test
    public void login() {
        HomePage homePage = loginPage.login(USERNAME, PASSWORD);
        Assert.assertTrue(homePage.getHomeBtnText().contains("Home"), "Login is not completed");
    }

    @Test
    public void usernameShouldBeRequired() {
        loginPage.login("", PASSWORD);
        Assert.assertTrue(loginPage.isUsernameLabelDisplayed(), "Username validation is not working.");
    }

    @Test
    public void passwordShouldBeRequired() {
        loginPage.login(USERNAME, "");
        Assert.assertEquals(loginPage.getErrorMessage(), "Please enter your password.",
                "Password validation is not working.");
    }
}
