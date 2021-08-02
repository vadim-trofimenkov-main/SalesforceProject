package com.itechart.pages.contact;

import com.itechart.pages.BasePage;
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
    private String ACCOUNT_NAME_VALUE = "(//span[contains(@title, '%s')]//ancestor::lightning-base-combobox-item[@class]) [1]";
    private static final By REPORTS_TO_LOOKUP = By.xpath("//input[@placeholder='Search Contacts...']");
    private static final By REPORTS_TO_VALUE = By.xpath("(//span[contains(@title, 'test contact')]//ancestor::li) [1]");
    private static final By SAVE_BUTTON_LOCATOR = By.xpath("//button[@name='SaveEdit']");

    public ContactModalPage(WebDriver driver) {super(driver);}

    public void fillSalutationPicklist(String value){
        driver.findElement(SALUTATION_PICKLIST_LOCATOR).click();
        driver.findElement(By.xpath(String.format(SALUTATION_VALUE, value, value))).click();
    }

    public void fillAccountNameLookUp(String value){
        driver.findElement(ACCOUNT_NAME_LOOKUP).click();
        driver.findElement(By.xpath(String.format(ACCOUNT_NAME_VALUE, value, value))).click();
    }

    public ContactModalPage fillContactDetails(String salutation, String firstname, String middlename, String lastname,
                                   String suffix, String accountname, String title, String department, String email,
                                   String fax, String phone, String mobile){
        fillSalutationPicklist(salutation);
        driver.findElement(FIRST_NAME_LOCATOR).sendKeys(firstname);
        driver.findElement(MIDDLE_NAME_LOCATOR).sendKeys(middlename);
        driver.findElement(LAST_NAME_LOCATOR).sendKeys(lastname);
        driver.findElement(SUFFIX_LOCATOR).sendKeys(suffix);
        fillAccountNameLookUp(accountname);
        driver.findElement(REPORTS_TO_LOOKUP).click();
        driver.findElement(REPORTS_TO_VALUE).click();
        driver.findElement(TITLE_LOCATOR).sendKeys(title);
        driver.findElement(DEPARTMENT_LOCATOR).sendKeys(department);
        driver.findElement(EMAIL_LOCATOR).sendKeys(email);
        driver.findElement(FAX_LOCATOR).sendKeys(fax);
        driver.findElement(PHONE_LOCATOR).sendKeys(phone);
        driver.findElement(MOBILE_LOCATOR).sendKeys(mobile);
        return new ContactModalPage(driver);
    }

    public void clickSaveButton (){
        driver.findElement(SAVE_BUTTON_LOCATOR).click();
    }
}
