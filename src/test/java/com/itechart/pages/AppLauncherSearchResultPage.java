package com.itechart.pages;

import org.openqa.selenium.*;
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
    private final By CANCEL_BUTTON_LOCATOR = By.xpath("//button[@name='CancelEdit']");
    private final By CROSS_BUTTON_LOCATOR = By.xpath("//button[@title='Close this window']");
    private final By SAVE_AND_NEW_BUTTON_LOCATOR = By.xpath("//button[@name='SaveAndNew']");
    private final By EMPTY_REQUIRED_FIELD_LOCATOR = By.xpath("//div[@class='slds-form-element__help']");
    private final By MODAL_HEADER_LOCATOR = By.xpath("//div[@class='slds-modal__header']");

    public AppLauncherSearchResultPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        WebElement firstResult = wait.until(ExpectedConditions.presenceOfElementLocated(SEARCH_LIST_LOCATOR));
        return driver.findElement(SEARCH_LIST_LOCATOR).isDisplayed();
    }

    public void enterDataInNewRecordModalFields(String name, boolean checkbox, String email, String number, String text) {
        driver.findElement(NAME_LOCATOR).sendKeys(name);
        if (checkbox) {
            driver.findElement(CHECKBOX_LOCATOR).click();
        }
        driver.findElement(EMAIL_LOCATOR).sendKeys(email);
        driver.findElement(NUMBER_LOCATOR).sendKeys(number);
        driver.findElement(TEXT_LOCATOR).sendKeys(text);
        driver.findElement(TEXT_LOCATOR).sendKeys(text);
    }

    public void clickNewButton() {
        driver.findElement(NEW_BUTTON_LOCATOR).click();
        WebElement firstResult = wait.until(ExpectedConditions.presenceOfElementLocated(MODAL_HEADER_LOCATOR));
    }

    public RecordPage clickSaveButton() {
        driver.findElement(SAVE_BUTTON_LOCATOR).click();
        return new RecordPage(driver);
    }

    public RecordPage clickSaveAndNewButton() {
        driver.findElement(SAVE_AND_NEW_BUTTON_LOCATOR).click();
        return new RecordPage(driver);
    }

    public void clickCancelButton() {
        driver.findElement(CANCEL_BUTTON_LOCATOR).click();
    }

    public void clickCrossButton() {
        driver.findElement(CROSS_BUTTON_LOCATOR).click();
    }

    public boolean isEmptyRequiredFieldsValidationError() {
        return driver.findElement(EMPTY_REQUIRED_FIELD_LOCATOR).isDisplayed();
    }

    public boolean isNewRecordModalOpened() {
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(MODAL_HEADER_LOCATOR));
            return false;
        } catch (TimeoutException | NoSuchElementException e) {
            return true;
        }
    }
}
