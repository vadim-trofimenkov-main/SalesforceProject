package com.itechart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class HomePage extends BasePage {
    private static final By HOME_BUTTON_LOCATOR = By.cssSelector("[title = 'Home Tab - Selected']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        WebElement firstResult = wait.until(ExpectedConditions.presenceOfElementLocated(HOME_BUTTON_LOCATOR));
        return driver.findElement(HOME_BUTTON_LOCATOR).isDisplayed();
    }
}


