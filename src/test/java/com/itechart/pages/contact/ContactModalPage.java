package com.itechart.pages.contact;

import com.itechart.elements.LightDropDown;
import com.itechart.elements.LightInput;
import com.itechart.elements.LightLookup;
import com.itechart.models.Contact;
import com.itechart.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactModalPage extends BasePage {
    private static final By SAVE_BUTTON_LOCATOR = By.xpath("//button[@name='SaveEdit']");

    public ContactModalPage(WebDriver driver) {
        super(driver);
    }

    public ContactModalPage enterData(Contact contact) {
        new LightDropDown(driver, "Salutation").selectOption(contact.getSalutation());
        new LightInput(driver, "First Name").write(contact.getFirstName());
        new LightInput(driver, "Middle Name").write(contact.getMiddleName());
        new LightInput(driver, "Last Name").write(contact.getLastName());
        new LightInput(driver, "Suffix").write(contact.getSuffix());
        new LightLookup(driver, "Account Name").selectOption(contact.getAccountName());
        new LightLookup(driver, "Reports To").selectOption(contact.getReportsTo());
        new LightInput(driver, "Title").write(contact.getTitle());
        new LightInput(driver, "Email").write(contact.getEmail());
        new LightInput(driver, "Phone").write(contact.getPhone());
        new LightInput(driver, "Mobile").write(contact.getMobile());
        new LightInput(driver, "Department").write(contact.getDepartment());
        new LightInput(driver, "Fax").write(contact.getFax());
        return this;
    }

    public ContactModalPage clearData() {
        new LightDropDown(driver, "Salutation").clear();
        new LightInput(driver, "First Name").clear();
        new LightInput(driver, "Middle Name").clear();
        new LightInput(driver, "Last Name").clear();
        new LightInput(driver, "Suffix").clear();
        new LightLookup(driver, "Account Name").clear();
        new LightLookup(driver, "Reports To").clear();
        new LightInput(driver, "Title").clear();
        new LightInput(driver, "Email").clear();
        new LightInput(driver, "Phone").clear();
        new LightInput(driver, "Mobile").clear();
        new LightInput(driver, "Department").clear();
        new LightInput(driver, "Fax").clear();
        return this;
    }

    public ContactDetailsPage clickSaveButton() {
        driver.findElement(SAVE_BUTTON_LOCATOR).click();
        return new ContactDetailsPage(driver);
    }
}
