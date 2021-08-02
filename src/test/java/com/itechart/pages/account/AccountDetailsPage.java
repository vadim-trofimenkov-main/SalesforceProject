package com.itechart.pages.account;

import com.itechart.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountDetailsPage extends BasePage {

    private final By ACCOUNT_TITLE = By.xpath("//div[@class='entityNameTitle slds-line-height--reset']");
    public AccountDetailsPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle(){
        return driver.findElement(ACCOUNT_TITLE).getText();
    }
}
