package com.itechart.pages.account;

import com.itechart.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountDetailsPage extends BasePage {

    private final By ACCOUNT_TITLE = By.xpath("//div[@class='entityNameTitle slds-line-height--reset' and contains(text(), 'Account')]");
    private final By DETAILS_TAB = By.xpath("//a[@data-label='Details']");

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
        driver.findElement(DETAILS_TAB).click();
        return this;
    }

    public void validate(String name, String parentAccount, String type, String website, String industry,
                         String phone, String description, String employees, String billingAddress,
                         String shippingAddress, String accountOwner) {
        if (!isPageOpened()) throw new RuntimeException("Page is not opened");
        validateInput("Account Name", name);
        validateInput("Type", type);
        validateInput("Description", description);
        validateInput("Industry", industry);
        validateInput("Website", website);
        validateInput("Phone", phone);
        validateInput("Employees", employees);
        validateInput("Billing Address", billingAddress);
        validateInput("Shipping Address", shippingAddress);
        validateInput("Account Owner", accountOwner);
        validateInput("Parent Account", parentAccount);
    }
}
