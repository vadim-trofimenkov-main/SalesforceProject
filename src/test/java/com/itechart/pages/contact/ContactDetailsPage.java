package com.itechart.pages.contact;

import com.itechart.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ContactDetailsPage extends BasePage {
    private static final By TITLE_CONTACT_LOCATOR = By.xpath("//div[@class='entityNameTitle slds-line-height--reset']");
    private static final By TAB_CONTACT_DETAILS_LOCATOR = By.xpath("//a[@data-label='Details']");
    private static final By NAME_CONTACT_DETAILS_LOCATOR = By.xpath("//lightning-formatted-name[@data-output-element-id='output-field']");
    private String LOOK_UP_CONTACT_DETAILS_LOCATOR = "//a[@class='flex-wrap-ie11']//span[contains(text(),'%s')]";
    private String TEXT_CONTACT_DETAILS_LOCATOR = "//lightning-formatted-text[@data-output-element-id='output-field' and contains(text(),'%s')]";
    private String EMAIL_CONTACT_DETAILS_LOCATOR = "//ancestor::slot[@slot='outputField']//a[@class='emailuiFormattedEmail' and contains(text(), '%s')]";
    private String PHONE_CONTACT_DETAILS_LOCATOR = "//ancestor::lightning-formatted-phone[@data-output-element-id='output-field']/a[contains(text(), '%s')]";

    public ContactDetailsPage(WebDriver driver) {super(driver);}

    public String getTitle(){
        return driver.findElement(TITLE_CONTACT_LOCATOR).getText();
    }

    public void openDetails(){
        driver.findElement(TAB_CONTACT_DETAILS_LOCATOR).click();
    }

    public void validate(String name, String accountname, String reportsto, String title, String department, String email, String fax, String phone, String mobile){
        Assert.assertTrue(driver.findElement(NAME_CONTACT_DETAILS_LOCATOR).getText().contains(name), "This Name doesn't exist");
        Assert.assertTrue(driver.findElement(By.xpath(String.format(LOOK_UP_CONTACT_DETAILS_LOCATOR, accountname))).getText().contains(accountname), "This Account Name doesn't exist");
        Assert.assertTrue(driver.findElement(By.xpath(String.format(LOOK_UP_CONTACT_DETAILS_LOCATOR, reportsto))).getText().contains(reportsto), "This Reports To doesn't exist");
        Assert.assertTrue(driver.findElement(By.xpath(String.format(TEXT_CONTACT_DETAILS_LOCATOR, title))).getText().contains(title), "This Title doesn't exist");
        Assert.assertTrue(driver.findElement(By.xpath(String.format(TEXT_CONTACT_DETAILS_LOCATOR, department))).getText().contains(department), "This Department doesn't exist");
        Assert.assertTrue(driver.findElement(By.xpath(String.format(EMAIL_CONTACT_DETAILS_LOCATOR, email))).getText().contains(email), "This Email doesn't exist");
        Assert.assertTrue(driver.findElement(By.xpath(String.format(PHONE_CONTACT_DETAILS_LOCATOR, fax))).getText().contains(fax), "This Fax doesn't exist");
        Assert.assertTrue(driver.findElement(By.xpath(String.format(PHONE_CONTACT_DETAILS_LOCATOR, phone))).getText().contains(phone), "This Phone doesn't exist");
        Assert.assertTrue(driver.findElement(By.xpath(String.format(PHONE_CONTACT_DETAILS_LOCATOR, mobile))).getText().contains(mobile), "This Mobile doesn't exist");
    }
}
