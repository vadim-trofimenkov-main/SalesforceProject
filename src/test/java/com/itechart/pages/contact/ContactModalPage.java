package com.itechart.pages.contact;

import com.itechart.pages.BasePage;
import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactModalPage extends BasePage {
    private static final By SALUTATION_PICKLIST_LOCATOR = By.xpath("//input[@name='salutation']");
    private String SALUTATION_VALUE = "//*[contains(text(), '%s')]/ancestor::lightning-base-combobox-item[contains(@data-value, '%s')]";
    private static final By FIRST_NAME_LOCATOR = By.xpath("//input[@name='firstName']");
    private static final By MIDDLE_NAME_LOCATOR = By.xpath("//input[@name='middleName']");
    private static final By LAST_NAME_LOCATOR = By.xpath("//input[@name='lastName']");
    private static final By SUFFIX_LOCATOR = By.xpath("//input[@name='suffix']");
    private static final By TITLE_LOCATOR = By.xpath("//input[@name='Title']");
    private static final By DEPARTMENT_LOCATOR = By.xpath("//input[@name='Department']");
    private static final By EMAIL_LOCATOR = By.xpath("//input[@name='Email']");
    private static final By FAX_LOCATOR = By.xpath("//input[@name='Fax']");
    private static final By PHONE_LOCATOR = By.xpath("//input[@name='Phone']");
    private static final By MOBILE_LOCATOR = By.xpath("//input[@name='MobilePhone']");
    private static final By ACCOUNT_NAME_LOOKUP = By.xpath("//input[@placeholder='Search Accounts...']");
    private String ACCOUNT_NAME_VALUE = "//span[@class='slds-listbox__option-text slds-listbox__option-text_entity']//span[contains(text(), '%s')]";
    private static final By REPORTS_TO_LOOKUP = By.xpath("//input[@placeholder='Search Contacts...']");
    private String REPORTS_TO_VALUE = "//span[@class='slds-truncate' and contains(text(),'%s')]";
    private static final By SAVE_BUTTON_LOCATOR = By.xpath("//button[@name='SaveEdit']");

    public ContactModalPage(WebDriver driver) {super(driver);}

    public void fillSalutationPicklist(String value){
        driver.findElement(SALUTATION_PICKLIST_LOCATOR).click();
        driver.findElement(By.xpath(String.format(SALUTATION_VALUE, value, value))).click();
    }

    public void fillAccountName(String value){
        driver.findElement(ACCOUNT_NAME_LOOKUP).click();
        driver.findElement(By.xpath(String.format(ACCOUNT_NAME_VALUE, value))).click();
    }

    public void fillReportsTo(String value){
        driver.findElement(REPORTS_TO_LOOKUP).click();
        driver.findElement(By.xpath(String.format(REPORTS_TO_VALUE, value))).click();
    }

    public ContactModalPage fillContactDetails(Contact contact){
        fillSalutationPicklist(contact.getSalutation());
        driver.findElement(FIRST_NAME_LOCATOR).sendKeys(contact.getFirstName());
        driver.findElement(MIDDLE_NAME_LOCATOR).sendKeys(contact.getMiddleName());
        driver.findElement(LAST_NAME_LOCATOR).sendKeys(contact.getLastName());
        driver.findElement(SUFFIX_LOCATOR).sendKeys(contact.getSuffix());
        fillAccountName(contact.getAccountName());
        fillReportsTo(contact.getReportsTo());
        driver.findElement(TITLE_LOCATOR).sendKeys(contact.getTitle());
        driver.findElement(DEPARTMENT_LOCATOR).sendKeys(contact.getDepartment());
        driver.findElement(EMAIL_LOCATOR).sendKeys(contact.getEmail());
        driver.findElement(FAX_LOCATOR).sendKeys(contact.getFax());
        driver.findElement(PHONE_LOCATOR).sendKeys(contact.getPhone());
        driver.findElement(MOBILE_LOCATOR).sendKeys(contact.getMobile());
        return new ContactModalPage(driver);
    }

    public void clickSaveButton (){
        driver.findElement(SAVE_BUTTON_LOCATOR).click();
    }
}
