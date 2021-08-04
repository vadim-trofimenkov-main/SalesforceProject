package com.itechart.pages.account;

import com.itechart.elements.DropDown;
import com.itechart.elements.Input;
import com.itechart.elements.TextArea;
import com.itechart.pages.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountModalPage extends BasePage {
    private final By PARENT_ACCOUNT_LOCATOR = By.xpath("//input[@title='Search Accounts']");
    private final By SAVE_BUTTON_LOCATOR = By.cssSelector("[title='Save']");
    private final By CANCEL_BUTTON_LOCATOR = By.cssSelector("[title='Cancel']");
    private final By CROSS_BUTTON_LOCATOR = By.xpath("//button[@title='Close this window']");
    private final By SAVE_AND_NEW_BUTTON_LOCATOR = By.cssSelector("[title='Save & New']");
    private final By EMPTY_REQUIRED_FIELD_LOCATOR = By.xpath("//li[contains(text(),'These required fields must be completed')]");
    private final By MODAL_HEADER_LOCATOR = By.xpath("//div[@class='slds-modal__header']");
    private String parentAccountField = "(//div[contains(@title, '%s')]//ancestor::li[not(contains(@class, 'invisible'))]) [1]";

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

    public void enterData(String name, String parentAccount, String type, String website, String industry,
                          String phone, String description, String employees, String billingStreet, String billingCity,
                          String billingPostalCode, String billingState,
                          String billingCountry, String shippingStreet, String shippingCity, String shippingState, String shippingPostalCode,
                          String shippingCountry) {
        new Input(driver, "Account Name").accountWrite(name);
        new DropDown(driver, "Type").select(type);
        new Input(driver, "Website").accountWrite(website);
        new TextArea(driver, "Description").write(description);
        selectParentAccountFirstPage(parentAccount);
        new Input(driver, "Phone").accountWrite(phone);
        new DropDown(driver, "Industry").select(industry);
        new Input(driver, "Employees").accountWrite(employees);
        new TextArea(driver, "Billing Street").write(billingStreet);
        new Input(driver, "Billing City").accountWrite(billingCity);
        new Input(driver, "Billing State/Province").accountWrite(billingState);
        new Input(driver, "Billing Zip/Postal Code").accountWrite(billingPostalCode);
        new Input(driver, "Billing Country").accountWrite(billingCountry);
        new TextArea(driver, "Shipping Street").write(shippingStreet);
        new Input(driver, "Shipping City").accountWrite(shippingCity);
        new Input(driver, "Shipping State/Province").accountWrite(shippingState);
        new Input(driver, "Shipping Zip/Postal Code").accountWrite(shippingPostalCode);
        new Input(driver, "Shipping Country").accountWrite(shippingCountry);
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

    public void selectParentAccountFirstPage(String parentAccount) {
        By PARENT_ACCOUNT_FIRST_OPTION_HEADER_LOCATOR = By.xpath(String.format(parentAccountField, parentAccount));
        driver.findElement(PARENT_ACCOUNT_LOCATOR).sendKeys(parentAccount);
        wait.until(ExpectedConditions.presenceOfElementLocated(PARENT_ACCOUNT_FIRST_OPTION_HEADER_LOCATOR));
        WebElement element = driver.findElement(PARENT_ACCOUNT_FIRST_OPTION_HEADER_LOCATOR);
        element.click();
    }
}
