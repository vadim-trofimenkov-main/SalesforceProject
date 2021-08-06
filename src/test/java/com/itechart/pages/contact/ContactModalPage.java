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

    public ContactModalPage enterData(String salutation, String firstname, String middlename, String lastname,
                                      String suffix, String accountname, String reportsto, String title, String department, String email,
                                      String fax, String phone, String mobile) {
        fillSalutationPicklist(salutation);
        new LightInput(driver, "First Name").write(firstname);
        new LightInput(driver, "Middle Name").write(middlename);
        new LightInput(driver, "Last Name").write(lastname);
        new LightInput(driver, "Suffix").write(suffix);
        new LightInput(driver, "Account Name").selectLookupOption(accountname);
        new LightInput(driver, "Reports To").selectLookupOption(reportsto);
        new LightInput(driver, "Title").write(title);
        new LightInput(driver, "Email").write(email);
        new LightInput(driver, "Phone").write(phone);
        new LightInput(driver, "Mobile").write(mobile);
        new LightInput(driver, "Department").write(department);
        new LightInput(driver, "Fax").write(fax);
        return new ContactModalPage(driver);
    }

    public void clickSaveButton() {
        driver.findElement(SAVE_BUTTON_LOCATOR).click();
    }
}
