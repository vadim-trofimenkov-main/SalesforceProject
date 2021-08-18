package com.itechart.pages.account;

import com.itechart.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountListViewPage extends BasePage {
    private final By BREADCRUMB_LOCATOR = By.cssSelector(".slds-var-p-right_x-small");
    private final By NEW_BUTTON_LOCATOR = By.xpath("(//div[@title ='New']) [1]");
    private final By SEARCH_LIST_LOCATOR = By.cssSelector("input[placeholder='Search this list...']");
    private final By SUCCESS_DELETE_MESSAGE = By.xpath("//*[contains(@class, 'slds-theme--success')]");

    public AccountListViewPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        wait.until(ExpectedConditions.presenceOfElementLocated(BREADCRUMB_LOCATOR));
        return driver.findElement(BREADCRUMB_LOCATOR).getText().contains("Accounts");
    }

    @Step("Open List View for Account")
    public AccountListViewPage open() {
        driver.get("https://itechart4.lightning.force.com/lightning/o/Account/list?filterName=Recent");
        return this;
    }

    @Step("Click on New button")
    public AccountModalPage clickNewButton() {
        wait.until(ExpectedConditions.presenceOfElementLocated(NEW_BUTTON_LOCATOR));
        driver.findElement(NEW_BUTTON_LOCATOR).click();
        return new AccountModalPage(driver);
    }

    @Step("Check that Account was deleted successfully")
    public boolean isSuccessDeleteMessageDisplayed() {
        boolean isSuccessMessageDisplayed;
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(SUCCESS_DELETE_MESSAGE));
            isSuccessMessageDisplayed = driver.findElement(SUCCESS_DELETE_MESSAGE).isDisplayed();
        } catch (StaleElementReferenceException e) {
            e.printStackTrace();
            isSuccessMessageDisplayed = driver.findElement(SUCCESS_DELETE_MESSAGE).isDisplayed();
        }
        return isSuccessMessageDisplayed;
    }
}
