package com.itechart.tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage {
    private final WebDriver driver;
    private static final By HOME_BUTTON_LOCATOR = By.cssSelector("[title = 'Home Tab - Selected']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getHomeBtnText() {
        WebElement firstResult = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(HOME_BUTTON_LOCATOR));
        return driver.findElement(HOME_BUTTON_LOCATOR).getText();
    }
}


