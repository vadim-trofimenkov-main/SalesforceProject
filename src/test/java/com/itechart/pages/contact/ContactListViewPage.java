package com.itechart.pages.contact;

import com.itechart.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactListViewPage extends BasePage {
    private static final By NEW_BUTTON_LOCATOR = By.xpath("//a[@title='New']");

    public ContactListViewPage(WebDriver driver) {
        super(driver);
    }

    public ContactListViewPage clickNewButton (){
        driver.findElement(NEW_BUTTON_LOCATOR).click();
        return new ContactListViewPage(driver);
    }
}
