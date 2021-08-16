package com.itechart.pages.lead;

import com.itechart.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LeadListViewPage extends BasePage {
    private final By BREADCRUMB_LOCATOR = By.cssSelector(".slds-var-p-right_x-small");
    private final By NEW_BUTTON_LOCATOR = By.xpath("(//div[@title ='New']) [1]");
    private final By SUCCESS_DELETE_MESSAGE = By.xpath("//*[contains(@class, 'slds-theme--success')]");

    public LeadListViewPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public LeadListViewPage open() {
        driver.get("https://itechart4.lightning.force.com/lightning/o/Lead/list?filterName=Recent");
        return this;
    }

    @Override
    public boolean isPageOpened() {
        wait.until(ExpectedConditions.presenceOfElementLocated(BREADCRUMB_LOCATOR));
        return driver.findElement(BREADCRUMB_LOCATOR).getText().contains("Leads");
    }

    public LeadModalPage clickNewButton() {
        wait.until(ExpectedConditions.presenceOfElementLocated(NEW_BUTTON_LOCATOR));
        driver.findElement(NEW_BUTTON_LOCATOR).click();
        return new LeadModalPage(driver);
    }

    public boolean isSuccessDeleteMessageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(SUCCESS_DELETE_MESSAGE));
        return driver.findElement(SUCCESS_DELETE_MESSAGE).isDisplayed();
    }
}
