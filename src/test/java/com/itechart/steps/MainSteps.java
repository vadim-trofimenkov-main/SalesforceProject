package com.itechart.steps;

import com.itechart.pages.LoginPage;
import com.itechart.tests.BaseTest;
import org.openqa.selenium.WebDriver;

public class MainSteps extends BaseTest {
    private final WebDriver driver;

    public MainSteps(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String username, String password) {
        homePage = loginPage.login(username, password);
    }

    public void openLoginPage() {
        loginPage = new LoginPage(driver);
        loginPage.open();
    }

    public void openHomePage() {
        homePage.open();
    }
}
