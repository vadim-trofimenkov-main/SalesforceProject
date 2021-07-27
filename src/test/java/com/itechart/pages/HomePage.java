package com.itechart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class HomePage extends BasePage {
    private final By HOME_BUTTON_LOCATOR = By.xpath("//one-app-nav-bar-item-root[@data-id='home']");
    private final By APP_LAUNCHER_LOCATOR = By.xpath("//div[@class ='appLauncher slds-context-bar__icon-action']");
    private final By APP_LAUNCHER_SEARCH_LOCATOR = By.xpath("//input[@class='slds-input']");
    private final By APP_LAUNCHER_SEARCH_First_Result_LOCATOR = By.xpath("//a[@data-label='Apples']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(HOME_BUTTON_LOCATOR));
        return driver.findElement(HOME_BUTTON_LOCATOR).isDisplayed();
    }
    public AppLauncherSearchResultPage goToTabFromAppLauncher(String tab) {
        driver.findElement(APP_LAUNCHER_LOCATOR).click();
        driver.findElement(APP_LAUNCHER_SEARCH_LOCATOR).sendKeys(tab);
        WebElement element = driver.findElement(APP_LAUNCHER_SEARCH_First_Result_LOCATOR);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
        return new AppLauncherSearchResultPage(driver);
    }
}


