package com.itechart.steps;

import com.itechart.pages.HomePage;
import com.itechart.pages.LoginPage;
import com.itechart.tests.BaseTest;
import org.openqa.selenium.WebDriver;

public class MainSteps extends BaseTest {
    private final WebDriver driver;

    public MainSteps(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage login(String username, String password) {
        loginPage = new LoginPage(driver);
        homePage = loginPage.open().login(username, password);
        return homePage;
    }
}
