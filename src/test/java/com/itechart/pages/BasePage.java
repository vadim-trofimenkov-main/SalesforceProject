package com.itechart.pages;

import models.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected final By HOME_BUTTON_LOCATOR = By.xpath("//one-app-nav-bar-item-root[@data-id='home']");
    protected final By APP_LAUNCHER_LOCATOR = By.xpath("//div[@class ='appLauncher slds-context-bar__icon-action']");
    protected final By APP_LAUNCHER_SEARCH_LOCATOR = By.xpath("//input[@class='slds-input']");
    protected final By APP_LAUNCHER_SEARCH_First_Result_LOCATOR = By.xpath("//a[@data-label='Apples']");

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
    }

    public boolean isPageOpened() {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(HOME_BUTTON_LOCATOR));
        return driver.findElement(HOME_BUTTON_LOCATOR).isDisplayed();
    }

    public void goToPage(String link) {
        driver.get(link);
    }

    public AppLauncherSearchResultPage goToTabFromAppLauncher(String tab) {
        if (isPageOpened()) {
            driver.findElement(APP_LAUNCHER_LOCATOR).click();
            driver.findElement(APP_LAUNCHER_SEARCH_LOCATOR).sendKeys(tab);
            WebElement element = driver.findElement(APP_LAUNCHER_SEARCH_First_Result_LOCATOR);
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", element);
            return new AppLauncherSearchResultPage(driver);
        } else throw new RuntimeException("Page is not opened");
    }

    public void validateInput(String label, String expected) {
        String locator = "//div[contains(@class, 'active')]//span[text()='%s']/ancestor::force-record-layout-item//" +
                "*[@data-output-element-id='output-field']";
        Assert.assertTrue(
                driver.findElement(By.xpath(String.format(locator, label))).getText().contains(expected),
                String.format("%s input is not correct", label)
        );
    }
}
