package com.itechart.pages.lead;

import com.itechart.models.Lead;
import com.itechart.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LeadDetailsPage extends BasePage {
    private final By LEAD_TITLE = By.xpath("//div[@class='entityNameTitle slds-line-height--reset' and contains(text(), 'Lead')]");
    private final By DETAILS_TAB = By.xpath("//a[@data-label='Details']");
    private static final By EDIT_DETAILS_BUTTON_LOCATOR = By.xpath("//button[@name='Edit']");
    private final By DELETE_BUTTON = By.xpath("//button[@name ='Delete']");
    private final By DELETE_MODAL_TITLE = By.xpath("//div[@class='modal-container slds-modal__container']//h2");
    private final By DELETE_MODAL_BUTTON = By.xpath("//div[@class='modal-container slds-modal__container']//button[@title= 'Delete']");

    public LeadDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Check that Lead Details page was opened")
    @Override
    public boolean isPageOpened() {
        wait.until(ExpectedConditions.presenceOfElementLocated(DETAILS_TAB));
        return getTitle().contains("Lead");
    }

    public String getTitle() {
        wait.until(ExpectedConditions.presenceOfElementLocated(LEAD_TITLE));
        return driver.findElement(LEAD_TITLE).getText();
    }

    public LeadDetailsPage openDetails() {
        driver.findElement(DETAILS_TAB).click();
        return this;
    }

    @Step("Click Edit button")
    public LeadModalPage clickEditDetailsButton() {
        WebElement element = new WebDriverWait(driver, 5).until(ExpectedConditions
                .presenceOfElementLocated(EDIT_DETAILS_BUTTON_LOCATOR));
        driver.findElement(EDIT_DETAILS_BUTTON_LOCATOR).click();
        return new LeadModalPage(driver);
    }

    @Step("Check all entering values in fields")
    public LeadDetailsPage validate(Lead lead) {
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
        return this;
    }

    @Step("Click on Delete button")
    public LeadDetailsPage clickDeleteButton() {
        try {
            driver.findElement(DELETE_BUTTON).click();
        } catch (StaleElementReferenceException e) {
            e.printStackTrace();
            driver.findElement(DELETE_BUTTON).click();
        }
        wait.until(ExpectedConditions.presenceOfElementLocated(DELETE_MODAL_TITLE));
        return this;
    }

    public boolean isModalOpened() {
        wait.until(ExpectedConditions.presenceOfElementLocated(DELETE_MODAL_TITLE));
        return driver.findElement(DELETE_MODAL_TITLE).getText().contains("Delete");
    }

    @Step("Confirm deleting account")
    public LeadListViewPage delete() {
        if (!isModalOpened()) throw new RuntimeException("Delete modal is not opened");
        driver.findElement(DELETE_MODAL_BUTTON).click();
        return new LeadListViewPage(driver);
    }
}
