package com.itechart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AppLauncherSearchResultPage extends BasePage {
    private final By NEW_BUTTON_LOCATOR = By.cssSelector("div[title ='New']");
    private final By SEARCH_LIST_LOCATOR = By.cssSelector("input[placeholder='Search this list...']");
    private final By NAME_LOCATOR = By.xpath("//input[@name='Name']");
    private final By CHECKBOX_LOCATOR = By.xpath("//input[@name='test_checkbox__c']");
    private final By EMAIL_LOCATOR = By.xpath("//input[@name='test_email__c']");
    private final By NUMBER_LOCATOR = By.xpath("//input[@name='Number__c']");
    private final By TEXT_LOCATOR = By.xpath("//textarea[@class= 'slds-textarea']");
    private final By SAVE_BUTTON_LOCATOR = By.xpath("//button[@name='SaveEdit']");

    public AppLauncherSearchResultPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        WebElement firstResult = wait.until(ExpectedConditions.presenceOfElementLocated(SEARCH_LIST_LOCATOR));
        return driver.findElement(SEARCH_LIST_LOCATOR).isDisplayed();
    }

    public RecordPage createNewRecord(String name, boolean checkbox, String email, String number, String text) {
        driver.findElement(NEW_BUTTON_LOCATOR).click();
        driver.findElement(NAME_LOCATOR).sendKeys(name);
        if (checkbox) {
            driver.findElement(CHECKBOX_LOCATOR).click();
        }
        driver.findElement(EMAIL_LOCATOR).sendKeys(email);
        driver.findElement(NUMBER_LOCATOR).sendKeys(number);
        driver.findElement(TEXT_LOCATOR).sendKeys(text);
        driver.findElement(TEXT_LOCATOR).sendKeys(text);
        clickSaveButton();
        return new RecordPage(driver);
    }

    public void clickSaveButton() {
        driver.findElement(SAVE_BUTTON_LOCATOR).click();
    }
}
