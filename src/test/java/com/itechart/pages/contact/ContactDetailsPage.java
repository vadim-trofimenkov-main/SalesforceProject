package com.itechart.pages.contact;

import com.itechart.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactDetailsPage extends BasePage {
    private static final By TITLE_CONTACT_DETAILS_LOCATOR = By.xpath("//div[@class='entityNameTitle slds-line-height--reset']");

    public ContactDetailsPage(WebDriver driver) {super(driver);}

    public String getTitle(){
        return driver.findElement(TITLE_CONTACT_DETAILS_LOCATOR).getText();
    }
}
