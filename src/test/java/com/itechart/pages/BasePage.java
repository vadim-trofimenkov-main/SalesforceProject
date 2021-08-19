package com.itechart.pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

@Log4j2
public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected final By HOME_BUTTON_LOCATOR = By.xpath("//one-app-nav-bar-item-root[@data-id='home']");

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
    }

    public boolean isPageOpened() {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(HOME_BUTTON_LOCATOR));
        return driver.findElement(HOME_BUTTON_LOCATOR).isDisplayed();
    }

    public void validateInput(String label, String expected) {
        String locator = "//div[contains(@class, 'active')]//span[text()='%s']/ancestor::force-record-layout-item//" +
                "*[@data-output-element-id='output-field']";
        Assert.assertTrue(
                driver.findElement(By.xpath(String.format(locator, label))).getText().contains(expected),
                String.format("%s input is not correct", label)
        );
    }
}
