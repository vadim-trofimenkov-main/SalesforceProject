package com.itechart.pages.account;

import com.itechart.elements.DropDown;
import com.itechart.elements.SFInput;
import com.itechart.elements.TextArea;
import com.itechart.pages.BasePage;
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

    public void enterData(String name, String parentAccount, String type, String website, String industry,
                          String phone, String description, String employees, String billingStreet, String billingCity,
                          String billingPostalCode, String billingState,
                          String billingCountry, String shippingStreet, String shippingCity, String shippingState, String shippingPostalCode,
                          String shippingCountry) {
        new SFInput(driver, "Account Name").write(name);
        new DropDown(driver, "Type").select(type);
        new SFInput(driver, "Website").write(website);
        new TextArea(driver, "Description").write(description);
        new SFInput(driver, "Parent Account").selectLookupOption(parentAccount);
        new SFInput(driver, "Phone").write(phone);
        new DropDown(driver, "Industry").select(industry);
        new SFInput(driver, "Employees").write(employees);
        new TextArea(driver, "Billing Street").write(billingStreet);
        new SFInput(driver, "Billing City").write(billingCity);
        new SFInput(driver, "Billing State/Province").write(billingState);
        new SFInput(driver, "Billing Zip/Postal Code").write(billingPostalCode);
        new SFInput(driver, "Billing Country").write(billingCountry);
        new TextArea(driver, "Shipping Street").write(shippingStreet);
        new SFInput(driver, "Shipping City").write(shippingCity);
        new SFInput(driver, "Shipping State/Province").write(shippingState);
        new SFInput(driver, "Shipping Zip/Postal Code").write(shippingPostalCode);
        new SFInput(driver, "Shipping Country").write(shippingCountry);
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
