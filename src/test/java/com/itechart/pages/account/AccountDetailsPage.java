package com.itechart.pages.account;

import com.itechart.pages.BasePage;
import models.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountDetailsPage extends BasePage {

    private final By ACCOUNT_TITLE = By.xpath("//div[@class='entityNameTitle slds-line-height--reset' and contains(text(), 'Account')]");
    private final By DETAILS_TAB = By.xpath("//a[@data-label='Details']");
    private static final By EDIT_DETAILS_BUTTON_LOCATOR = By.xpath("//button[@name='Edit']");

    public AccountDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        wait.until(ExpectedConditions.presenceOfElementLocated(DETAILS_TAB));
        return driver.findElement(DETAILS_TAB).isDisplayed();
    }


    public String getTitle() {
        wait.until(ExpectedConditions.presenceOfElementLocated(ACCOUNT_TITLE));
        return driver.findElement(ACCOUNT_TITLE).getText();
    }

    public AccountDetailsPage openDetails() {
        WebElement element = new WebDriverWait(driver, 5).until(ExpectedConditions
                .presenceOfElementLocated(DETAILS_TAB));
        driver.findElement(DETAILS_TAB).click();
        return this;
    }

    public AccountModalPage clickEditDetailsButton (){
        driver.findElement(EDIT_DETAILS_BUTTON_LOCATOR).click();
        return new AccountModalPage(driver);
    }

    public void validate(Account account){
        validateInput("Account Name", account.getAccountName());
        validateInput("Type", account.getType());
        validateInput("Description", account.getDescription());
        validateInput("Industry", account.getIndustry());
        validateInput("Website", account.getWebsite());
        validateInput("Phone", account.getPhone());
        validateInput("Employees", account.getEmployees());
        validateInput("Billing Address", account.getBillingAddress());
        validateInput("Shipping Address", account.getShippingAddress());
        validateInput("Account Owner", account.getAccountOwner());
        validateInput("Parent Account", account.getParentAccount());
    }
}
