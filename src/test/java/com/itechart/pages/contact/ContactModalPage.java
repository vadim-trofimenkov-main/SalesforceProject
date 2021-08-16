package com.itechart.pages.contact;

import com.itechart.elements.LightInput;
import com.itechart.pages.BasePage;
import com.itechart.models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactModalPage extends BasePage {
    private static final By SAVE_BUTTON_LOCATOR = By.xpath("//button[@name='SaveEdit']");

    public ContactModalPage(WebDriver driver) {
        super(driver);
    }

    public ContactModalPage enterData(Contact contact) {
        new LightInput(driver, "Salutation").selectLookupOption(contact.getSalutation());
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

    public ContactModalPage clearData() {
        new LightInput(driver, "Salutation").clearDropDown();
        new LightInput(driver, "First Name").clearLightInput();
        new LightInput(driver, "Middle Name").clearLightInput();
        new LightInput(driver, "Last Name").clearLightInput();
        new LightInput(driver, "Suffix").clearLightInput();
        new LightInput(driver, "Account Name").clearLookUp();
        new LightInput(driver, "Reports To").clearLookUp();
        new LightInput(driver, "Title").clearLightInput();
        new LightInput(driver, "Email").clearLightInput();
        new LightInput(driver, "Phone").clearLightInput();
        new LightInput(driver, "Mobile").clearLightInput();
        new LightInput(driver, "Department").clearLightInput();
        new LightInput(driver, "Fax").clearLightInput();
        return this;
    }

    public ContactDetailsPage clickSaveButton() {
        driver.findElement(SAVE_BUTTON_LOCATOR).click();
        return new ContactDetailsPage(driver);
    }
}
