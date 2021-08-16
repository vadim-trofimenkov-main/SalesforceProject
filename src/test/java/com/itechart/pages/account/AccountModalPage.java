package com.itechart.pages.account;

import com.itechart.elements.DropDown;
import com.itechart.elements.SFInput;
import com.itechart.elements.TextArea;
import com.itechart.pages.BasePage;
import com.itechart.models.Account;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountModalPage extends BasePage {
    private final By SAVE_BUTTON_LOCATOR = By.cssSelector("[title='Save']");
    private final By CANCEL_BUTTON_LOCATOR = By.cssSelector("[title='Cancel']");
    private final By CROSS_BUTTON_LOCATOR = By.xpath("//button[@title='Close this window']");
    private final By SAVE_AND_NEW_BUTTON_LOCATOR = By.cssSelector("[title='Save & New']");
    private final By EMPTY_REQUIRED_FIELD_LOCATOR = By.xpath("//li[contains(text(),'These required fields must be completed')]");
    private final By MODAL_HEADER_LOCATOR = By.xpath("//div[@class='slds-modal__header']");

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

    public void enterData(Account account) {
        new SFInput(driver, "Account Name").write(account.getAccountName());
        new DropDown(driver, "Type").select(account.getType());
        new SFInput(driver, "Website").write(account.getWebsite());
        new TextArea(driver, "Description").write(account.getDescription());
        new SFInput(driver, "Parent Account").selectLookupOption(account.getParentAccount());
        new SFInput(driver, "Phone").write(account.getPhone());
        new DropDown(driver, "Industry").select(account.getIndustry());
        new SFInput(driver, "Employees").write(account.getEmployees());
        new TextArea(driver, "Billing Street").write(account.getBillingStreet());
        new SFInput(driver, "Billing City").write(account.getBillingCity());
        new SFInput(driver, "Billing State/Province").write(account.getBillingState());
        new SFInput(driver, "Billing Zip/Postal Code").write(account.getBillingPostalCode());
        new SFInput(driver, "Billing Country").write(account.getBillingCountry());
        new TextArea(driver, "Shipping Street").write(account.getShippingStreet());
        new SFInput(driver, "Shipping City").write(account.getShippingCity());
        new SFInput(driver, "Shipping State/Province").write(account.getShippingState());
        new SFInput(driver, "Shipping Zip/Postal Code").write(account.getShippingPostalCode());
        new SFInput(driver, "Shipping Country").write(account.getShippingCountry());
    }

    public AccountModalPage clearData() {
        new SFInput(driver, "Account Name").clearInput();
        new DropDown(driver, "Type").clear();
        new SFInput(driver, "Website").clearInput();
        new TextArea(driver, "Description").clearTextArea();
        new SFInput(driver, "Parent Account").clearLookUp();
        new SFInput(driver, "Phone").clearInput();
        new DropDown(driver, "Industry").clear();
        new SFInput(driver, "Employees").clearInput();
        new TextArea(driver, "Billing Street").clearTextArea();
        new SFInput(driver, "Billing City").clearInput();
        new SFInput(driver, "Billing State/Province").clearInput();
        new SFInput(driver, "Billing Zip/Postal Code").clearInput();
        new SFInput(driver, "Billing Country").clearInput();
        new TextArea(driver, "Shipping Street").clearTextArea();
        new SFInput(driver, "Shipping City").clearInput();
        new SFInput(driver, "Shipping State/Province").clearInput();
        new SFInput(driver, "Shipping Zip/Postal Code").clearInput();
        new SFInput(driver, "Shipping Country").clearInput();
        return this;
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
}
