package com.company.login_test;

import com.company.base_test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

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
