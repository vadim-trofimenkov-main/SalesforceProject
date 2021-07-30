package com.itechart.pages.contact;

import com.itechart.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountSearchModalPage extends BasePage {
    private static final By ACCOUNT_NAME_LINK = By.xpath("(//a[contains(text(),'Test Account')]) [2]");

    public AccountSearchModalPage(WebDriver driver) {super(driver);}

    public void selectAccountName() {
        driver.findElement(ACCOUNT_NAME_LINK).click();
    }
}
