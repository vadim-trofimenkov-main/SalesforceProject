package com.itechart.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LightLookup {
    WebDriver driver;
    String label;
    String inputLocator = "//*[contains(@class, 'modal-body')]//*[text()='%s']/parent::*[contains(@class,'slds-form-element')]//input";
    String lookupOption = "(//*[contains(@class, 'modal-body')]//*[contains(text(), '%s')]/ancestor::lightning-base-combobox-item) [1]";
    String DELETE_ACTION_LOCATOR = "//*[contains(@class, 'modal-body')]//*[text()='%s']/ancestor::*[@class='slds-form-element']//button[@title='Clear Selection']";

    public LightLookup(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void selectOption(String option) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        System.out.printf("Selecting option '%s' from %s lookup \n", option, label);
        WebElement element = driver.findElement(By.xpath(String.format(inputLocator, label)));
        executor.executeScript("arguments[0].click();", element);
        WebElement element3 = new WebDriverWait(driver,5)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(String.format(lookupOption, option))));
        WebElement element1 = driver.findElement(By.xpath(String.format(lookupOption, option)));
        executor.executeScript("arguments[0].click();", element1);
    }
    public void clear() {
        System.out.printf("Deleting lookup %s\n", label);
        driver.findElement(By.xpath(String.format(DELETE_ACTION_LOCATOR, label))).click();
    }
}