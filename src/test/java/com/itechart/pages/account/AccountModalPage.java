package com.itechart.pages.account;

import com.itechart.pages.BasePage;
import models.Account;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountModalPage extends BasePage {
    private final By ACCOUNT_NAME_LOCATOR = By.xpath("//div[@class='autocompleteWrapper slds-grow']/input [1]");
    String TYPE_LOCATOR = "//*[contains(@class, 'uiMenuList') and contains(@class, 'visible')]//a[@title='%s']";
    private final By WEBSITE_LOCATOR = By.xpath("//input[@type='url']");
    private final By PHONE_LOCATOR = By.xpath("//input[@type='tel']");
    private final By DESCRIPTION_LOCATOR = By.xpath("//textarea[@class=' textarea']");
    private final By EMPLOYEES_LOCATOR = By.xpath("//input[@class='input uiInputSmartNumber']");
    private final By PARENT_ACCOUNT_LOCATOR = By.xpath("//input[@title='Search Accounts']");
    private final By INDUSTRY_LOCATOR = By.xpath("(//a[@class='select']) [2]");
    private final By SAVE_BUTTON_LOCATOR = By.cssSelector("[title='Save']");
    private final By CANCEL_BUTTON_LOCATOR = By.cssSelector("[title='Cancel']");
    private final By CROSS_BUTTON_LOCATOR = By.xpath("//button[@title='Close this window']");
    private final By SAVE_AND_NEW_BUTTON_LOCATOR = By.cssSelector("[title='Save & New']");
    private final By EMPTY_REQUIRED_FIELD_LOCATOR = By.xpath("//li[contains(text(),'These required fields must be completed')]");
    private final By MODAL_HEADER_LOCATOR = By.xpath("//div[@class='slds-modal__header']");
    private String parentAccountField = "(//div[contains(@title, '%s')]//ancestor::li[not(contains(@class, 'invisible'))]) [1]";

    //address
    private final By BILLING_STREET_LOCATOR = By.cssSelector("[placeholder='Billing Street']");
    private final By BILLING_CITY_LOCATOR = By.cssSelector("[placeholder='Billing City']");
    private final By BILLING_POSTAL_CODE_LOCATOR = By.cssSelector("[placeholder='Billing Zip/Postal Code']");
    private final By BILLING_STATE_LOCATOR = By.cssSelector("[placeholder='Billing State/Province']");
    private final By BILLING_COUNTRY_LOCATOR = By.cssSelector("[placeholder='Billing Country']");
    private final By SHIPPING_STREET_LOCATOR = By.cssSelector("[placeholder='Shipping Street']");
    private final By SHIPPING_CITY_LOCATOR = By.cssSelector("[placeholder='Shipping City']");
    private final By SHIPPING_STATE_LOCATOR = By.cssSelector("[placeholder='Shipping State/Province']");
    private final By SHIPPING_POSTAL_CODE_LOCATOR = By.cssSelector("[placeholder='Shipping Zip/Postal Code']");
    private final By SHIPPING_COUNTRY_LOCATOR = By.cssSelector("[placeholder='Shipping Country']");

    public AccountModalPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(MODAL_HEADER_LOCATOR));
            return false;
        } catch (TimeoutException | NoSuchElementException e) {
            return true;
        }
    }

    public void enterDataInNewRecordModalFields(Account account) {
        driver.findElement(ACCOUNT_NAME_LOCATOR).sendKeys(account.getAccountName());
        selectPicklistOption(TYPE_LOCATOR, account.getType());
        selectParentAccountFirstPage(account.getParentAccount());
        driver.findElement(WEBSITE_LOCATOR).sendKeys(account.getWebsite());
        selectPicklistOption(TYPE_LOCATOR, account.getIndustry());
        driver.findElement(PHONE_LOCATOR).sendKeys(account.getPhone());
        driver.findElement(DESCRIPTION_LOCATOR).sendKeys(account.getDescription());
        driver.findElement(EMPLOYEES_LOCATOR).sendKeys(account.getEmployees());
        driver.findElement(BILLING_STREET_LOCATOR).sendKeys(account.getBillingStreet());
        driver.findElement(BILLING_CITY_LOCATOR).sendKeys(account.getBillingCity());
        driver.findElement(BILLING_POSTAL_CODE_LOCATOR).sendKeys(account.getBillingPostalCode());
        driver.findElement(BILLING_STATE_LOCATOR).sendKeys(account.getBillingState());
        driver.findElement(BILLING_COUNTRY_LOCATOR).sendKeys(account.getBillingCountry());
        driver.findElement(SHIPPING_STREET_LOCATOR).sendKeys(account.getShippingStreet());
        driver.findElement(SHIPPING_CITY_LOCATOR).sendKeys(account.getShippingCity());
        driver.findElement(SHIPPING_STATE_LOCATOR).sendKeys(account.getShippingState());
        driver.findElement(SHIPPING_POSTAL_CODE_LOCATOR).sendKeys(account.getShippingPostalCode());
        driver.findElement(SHIPPING_COUNTRY_LOCATOR).sendKeys(account.getShippingCountry());
    }

    public AccountDetailsPage clickSaveButton() {
        driver.findElement(SAVE_BUTTON_LOCATOR).click();
        return new AccountDetailsPage(driver);
    }

    public AccountDetailsPage clickSaveAndNewButton() {
        driver.findElement(SAVE_AND_NEW_BUTTON_LOCATOR).click();
        return new AccountDetailsPage(driver);
    }

    public AccountListViewPage clickCancelButton() {
        driver.findElement(CANCEL_BUTTON_LOCATOR).click();
        return new AccountListViewPage(driver);
    }

    public AccountListViewPage clickCrossButton() {
        driver.findElement(CROSS_BUTTON_LOCATOR).click();
        return new AccountListViewPage(driver);
    }

    public boolean isEmptyRequiredFieldsValidationError() {
        return driver.findElement(EMPTY_REQUIRED_FIELD_LOCATOR).isDisplayed();
    }

    public void selectPicklistOption(String locator, String type) {
        driver.findElement(By.xpath(locator)).click();
        wait.until(ExpectedConditions.presenceOfElementLocated((By.linkText(type))));
        driver.findElement(By.linkText(type)).click();
    }

    public void selectParentAccountFirstPage(String parentAccount) {
        By PARENT_ACCOUNT_FIRST_OPTION_HEADER_LOCATOR = By.xpath(String.format(parentAccountField, parentAccount));
        driver.findElement(PARENT_ACCOUNT_LOCATOR).sendKeys(parentAccount);
        wait.until(ExpectedConditions.presenceOfElementLocated(PARENT_ACCOUNT_FIRST_OPTION_HEADER_LOCATOR));
        WebElement element = driver.findElement(PARENT_ACCOUNT_FIRST_OPTION_HEADER_LOCATOR);
        element.click();
    }
}
