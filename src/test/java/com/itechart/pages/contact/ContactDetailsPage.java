package com.itechart.pages.contact;

import com.itechart.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactDetailsPage extends BasePage {
    private static final By TITLE_CONTACT_LOCATOR = By.xpath("//div[@class='entityNameTitle slds-line-height--reset']");
    private static final By TAB_CONTACT_DETAILS_LOCATOR = By.xpath("//a[@data-label='Details']");

    public ContactDetailsPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return driver.findElement(TITLE_CONTACT_LOCATOR).getText();
    }

    public void openDetails() {
        driver.findElement(TAB_CONTACT_DETAILS_LOCATOR).click();
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
