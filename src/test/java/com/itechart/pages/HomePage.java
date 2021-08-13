package com.itechart.pages;

import com.itechart.pages.account.AccountListViewPage;
import com.itechart.pages.contact.ContactListViewPage;
import com.itechart.pages.lead.LeadListViewPage;
import com.itechart.utils.PropertyReader;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    protected PropertyReader propertyReader = new PropertyReader("src/main/resources/links.properties");
    AccountListViewPage accountListViewPage;
    ContactListViewPage contactListViewPage;
    LeadListViewPage leadListViewPage;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public AccountListViewPage openAccountListViewPage() {
        driver.get(propertyReader.getPropertyValueByKey("AccountListViewPage"));
        accountListViewPage = new AccountListViewPage(driver);
        return accountListViewPage;
    }

    public ContactListViewPage openContactListViewPage() {
        driver.get(propertyReader.getPropertyValueByKey("ContactListViewPage"));
        contactListViewPage = new ContactListViewPage(driver);
        return contactListViewPage;
    }

    public LeadListViewPage openLeadListViewPage() {
        driver.get(propertyReader.getPropertyValueByKey("LeadListViewPage"));
        leadListViewPage = new LeadListViewPage(driver);
        return leadListViewPage;
    }
}


