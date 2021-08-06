package com.itechart.pages.contact;

import com.itechart.elements.LightInput;
import com.itechart.pages.BasePage;
import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactModalPage extends BasePage {
    private static final By SALUTATION_PICKLIST_LOCATOR = By.xpath("//input[@name='salutation']");
    private String SALUTATION_VALUE = "//*[contains(text(), '%s')]/ancestor::lightning-base-combobox-item[contains(@data-value, '%s')]";
    private static final By SAVE_BUTTON_LOCATOR = By.xpath("//button[@name='SaveEdit']");

    public ContactModalPage(WebDriver driver) {
        super(driver);
    }

    public void fillSalutationPicklist(String value) {
        driver.findElement(SALUTATION_PICKLIST_LOCATOR).click();
        driver.findElement(By.xpath(String.format(SALUTATION_VALUE, value, value))).click();
    }

    public ContactModalPage enterData(Contact contact) {
        fillSalutationPicklist(contact.getSalutation());
        new LightInput(driver, "First Name").write(contact.getFirstName());
        new LightInput(driver, "Middle Name").write(contact.getMiddleName());
        new LightInput(driver, "Last Name").write(contact.getLastName());
        new LightInput(driver, "Suffix").write(contact.getSuffix());
        new LightInput(driver, "Account Name").selectLookupOption(contact.getAccountName());
        new LightInput(driver, "Reports To").selectLookupOption(contact.getReportsTo());
        new LightInput(driver, "Title").write(contact.getTitle());
        new LightInput(driver, "Email").write(contact.getEmail());
        new LightInput(driver, "Phone").write(contact.getPhone());
        new LightInput(driver, "Mobile").write(contact.getMobile());
        new LightInput(driver, "Department").write(contact.getDepartment());
        new LightInput(driver, "Fax").write(contact.getFax());
        return new ContactModalPage(driver);
    }

    public void clickSaveButton() {
        driver.findElement(SAVE_BUTTON_LOCATOR).click();
    }
}
