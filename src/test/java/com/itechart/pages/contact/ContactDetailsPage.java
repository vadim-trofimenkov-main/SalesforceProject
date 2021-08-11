package com.itechart.pages.contact;

import com.itechart.pages.BasePage;
import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactDetailsPage extends BasePage {
    private static final By TITLE_CONTACT_LOCATOR = By.xpath("//div[@class='entityNameTitle slds-line-height--reset']");
    private static final By TAB_CONTACT_DETAILS_LOCATOR = By.xpath("//a[@data-label='Details']");
    private static final By EDIT_DETAILS_BUTTON_LOCATOR = By.xpath("//button[@name='Edit']");

    public ContactModalPage clickEditDetailsButton (){
        WebElement element = new WebDriverWait(driver, 5).until(ExpectedConditions
                .presenceOfElementLocated(EDIT_DETAILS_BUTTON_LOCATOR));
        driver.findElement(EDIT_DETAILS_BUTTON_LOCATOR).click();
        return new ContactModalPage(driver);
    }

    public ContactDetailsPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return driver.findElement(TITLE_CONTACT_LOCATOR).getText();
    }

    public void openDetails() {
        driver.findElement(TAB_CONTACT_DETAILS_LOCATOR).click();
    }

    public void validate(Contact contact) {
        validateInput("Name", contact.getName());
        validateInput("Account Name", contact.getAccountName());
        validateInput("Reports To", contact.getReportsTo());
        validateInput("Title", contact.getTitle());
        validateInput("Department", contact.getDepartment());
        validateInput("Email", contact.getEmail());
        validateInput("Phone", contact.getPhone());
        validateInput("Fax", contact.getFax());
        validateInput("Mobile", contact.getMobile());
    }
}
