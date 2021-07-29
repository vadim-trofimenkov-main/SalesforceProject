package com.itechart.pages.account;

import com.itechart.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountListViewPage extends BasePage {
    private final By BREADCRUMB_LOCATOR = By.cssSelector(".slds-var-p-right_x-small");
    private final By NEW_BUTTON_LOCATOR = By.xpath("//div[@title ='New'] [1]");
    private final By SEARCH_LIST_LOCATOR = By.cssSelector("input[placeholder='Search this list...']");

    public AccountListViewPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(BREADCRUMB_LOCATOR));
        return driver.findElement(BREADCRUMB_LOCATOR).getText().contains("Accounts");
    }

    public AccountModalPage clickNewButton() {
        driver.findElement(NEW_BUTTON_LOCATOR).click();
        return new AccountModalPage(driver);
    }
}
