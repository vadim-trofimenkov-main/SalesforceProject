package com.company.login_test;

import com.company.base_test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class LoginTest extends BaseTest {
    @Test
    public void login() {
        loginPage.setUsername(propertyReader.getPropertyValueByKey("username"));
        loginPage.setPassword(propertyReader.getPropertyValueByKey("password"));
        HomePage homePage = loginPage.clickLoginButton();
        Assert.assertTrue(homePage.getHomeBtnText().contains("Home"), "Login is not completed");
    }
}
