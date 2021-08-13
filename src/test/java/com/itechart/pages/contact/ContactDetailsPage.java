package com.itechart.pages.contact;

import com.itechart.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactDetailsPage extends BasePage {
    private static final By TITLE_CONTACT_LOCATOR = By.xpath("//div[@class='entityNameTitle slds-line-height--reset']");
    private static final By TAB_CONTACT_DETAILS_LOCATOR = By.xpath("//a[@data-label='Details']");

    public ContactDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        wait.until(ExpectedConditions.presenceOfElementLocated(TITLE_CONTACT_LOCATOR));
        return getTitle().contains("Contact");
    }

    public String getTitle() {
        return driver.findElement(TITLE_CONTACT_LOCATOR).getText();
    }

    public ContactDetailsPage openDetails() {
        driver.findElement(TAB_CONTACT_DETAILS_LOCATOR).click();
        return this;
    }

    public void validate(String name, String accountName, String reportsTo, String title, String department, String email,
                         String fax, String phone, String mobile) {
        validateInput("Name", name);
        validateInput("Account Name", accountName);
        validateInput("Reports To", reportsTo);
        validateInput("Title", title);
        validateInput("Department", department);
        validateInput("Email", email);
        validateInput("Phone", phone);
        validateInput("Fax", fax);
        validateInput("Mobile", mobile);
    }
}
