package com.itechart.pages.lead;

import com.itechart.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LeadListViewPage extends BasePage {
    private final By BREADCRUMB_LOCATOR = By.cssSelector(".slds-var-p-right_x-small");
    private final By NEW_BUTTON_LOCATOR = By.xpath("(//div[@title ='New']) [1]");

    public LeadListViewPage(WebDriver driver) {
        super(driver);
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

}
