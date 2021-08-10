package com.itechart.pages.lead;

import com.itechart.models.Lead;
import com.itechart.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LeadDetailsPage extends BasePage {
    private final By LEAD_TITLE = By.xpath("//div[@class='entityNameTitle slds-line-height--reset' and contains(text(), 'Lead')]");
    private final By DETAILS_TAB = By.xpath("//a[@data-label='Details']");

    public LeadDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        wait.until(ExpectedConditions.presenceOfElementLocated(DETAILS_TAB));
        return driver.findElement(DETAILS_TAB).isDisplayed();
    }


    public String getTitle() {
        wait.until(ExpectedConditions.presenceOfElementLocated(LEAD_TITLE));
        return driver.findElement(LEAD_TITLE).getText();
    }

    public LeadDetailsPage openDetails() {
        driver.findElement(DETAILS_TAB).click();
        return this;
    }

    public void validate(Lead lead) {
        if (!isPageOpened()) throw new RuntimeException("Page is not opened");
        validateInput("Lead Status", lead.getLeadStatus());
        validateInput("Name", lead.getName());
        validateInput("Title", lead.getTitle());
        validateInput("Email", lead.getEmail());
        validateInput("Phone", lead.getPhone());
        validateInput("Mobile", lead.getMobile());
        validateInput("Rating", lead.getRating());
        validateInput("Website", lead.getWebsite());
        validateInput("Company", lead.getCompany());
        validateInput("Industry", lead.getIndustry());
        validateInput("No. of Employees", lead.getNoOfEmployees());
        validateInput("Lead Source", lead.getLeadSource());
        validateInput("Address", lead.getAddress());
    }
}
