package com.itechart.pages.contact;

import com.itechart.elements.Input;
import com.itechart.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactModalPage extends BasePage {
    private static final By SALUTATION_PICKLIST_LOCATOR = By.xpath("//input[@name='salutation']");
    private String SALUTATION_VALUE = "//*[contains(text(), '%s')]/ancestor::lightning-base-combobox-item[contains(@data-value, '%s')]";
    private static final By ACCOUNT_NAME_LOOKUP = By.xpath("//input[@placeholder='Search Accounts...']");
    private String ACCOUNT_NAME_VALUE = "//span[@class='slds-listbox__option-text slds-listbox__option-text_entity']//span[contains(text(), '%s')]";
    private static final By REPORTS_TO_LOOKUP = By.xpath("//input[@placeholder='Search Contacts...']");
    private String REPORTS_TO_VALUE = "//span[@class='slds-truncate' and contains(text(),'%s')]";
    private static final By SAVE_BUTTON_LOCATOR = By.xpath("//button[@name='SaveEdit']");

    public ContactModalPage(WebDriver driver) {
        super(driver);
    }

    public void fillSalutationPicklist(String value) {
        driver.findElement(SALUTATION_PICKLIST_LOCATOR).click();
        driver.findElement(By.xpath(String.format(SALUTATION_VALUE, value, value))).click();
    }

    public void fillAccountName(String value) {
        driver.findElement(ACCOUNT_NAME_LOOKUP).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(String.format(ACCOUNT_NAME_VALUE, value))));
        driver.findElement(By.xpath(String.format(ACCOUNT_NAME_VALUE, value))).click();
    }

    public void fillReportsTo(String value) {
        driver.findElement(REPORTS_TO_LOOKUP).click();
        driver.findElement(By.xpath(String.format(REPORTS_TO_VALUE, value))).click();
    }

    public ContactModalPage fillContactDetails(String salutation, String firstname, String middlename, String lastname,
                                               String suffix, String accountname, String reportsto, String title, String department, String email,
                                               String fax, String phone, String mobile) {
        fillSalutationPicklist(salutation);
        new Input(driver, "First Name").contactWrite(firstname);
        new Input(driver, "Middle Name").contactWrite(middlename);
        new Input(driver, "Last Name").contactWrite(lastname);
        new Input(driver, "Suffix").contactWrite(suffix);
        fillAccountName(accountname);
        fillReportsTo(reportsto);
        new Input(driver, "Title").contactWrite(title);
        new Input(driver, "Email").contactWrite(email);
        new Input(driver, "Phone").contactWrite(phone);
        new Input(driver, "Mobile").contactWrite(mobile);
        new Input(driver, "Department").contactWrite(department);
        new Input(driver, "Fax").contactWrite(fax);
        return new ContactModalPage(driver);
    }

    public void clickSaveButton() {
        driver.findElement(SAVE_BUTTON_LOCATOR).click();
    }
}
