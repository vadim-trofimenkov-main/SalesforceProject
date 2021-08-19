package com.itechart.pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class LoginPage extends BasePage {
    private static final By USERNAME_LOCATOR = By.id("username");
    private static final By PASSWORD_LOCATOR = By.id("password");
    private static final By LOGIN_BUTTON_LOCATOR = By.id("Login");
    private static final By ERROR_MESSAGE_LOCATOR = By.id("error");
    private static final By LOGO_LOCATOR = By.id("logo");
    private static final By USERNAME_LABEL_LOCATOR = By.cssSelector(".usernamelabel");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(LOGO_LOCATOR));
        log.info("Login page is open");
        return driver.findElement(LOGO_LOCATOR).isDisplayed();
    }

    public LoginPage open() {
        log.info("Opening Login page");
        driver.get("https://itechart4.my.salesforce.com/");
        return this;
    }

    public HomePage login(String username, String password) {
        log.info("Logging into Salesforce");
        driver.findElement(USERNAME_LOCATOR).sendKeys(username);
        driver.findElement(PASSWORD_LOCATOR).sendKeys(password);
        driver.findElement(LOGIN_BUTTON_LOCATOR).click();
        return new HomePage(driver);
    }

    public String getErrorMessage() {
        log.info("Getting Login Error Message");
        return driver.findElement(ERROR_MESSAGE_LOCATOR).getText();
    }

    public boolean isUsernameDisplayed() {
        log.info("Checking whether Username is displayed");
        return driver.findElement(USERNAME_LABEL_LOCATOR).isDisplayed();
    }
}
