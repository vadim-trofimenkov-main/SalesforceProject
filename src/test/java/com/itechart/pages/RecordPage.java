package com.itechart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RecordPage extends BasePage {
    private final By SUCCESS_MESSAGE_LOCATOR = By.cssSelector(".slds-theme--success");
    private final By DETAILS_TAB_LOCATOR = By.id("detailTab__item");

    public RecordPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(DETAILS_TAB_LOCATOR));
        return driver.findElement(DETAILS_TAB_LOCATOR).isDisplayed();
    }

    public boolean isRecordCreated() {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(SUCCESS_MESSAGE_LOCATOR));
        return driver.findElement(SUCCESS_MESSAGE_LOCATOR).isDisplayed();
    }
}
