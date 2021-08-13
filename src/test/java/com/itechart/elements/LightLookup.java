package com.itechart.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LightLookup {
    WebDriver driver;
    String label;
    String inputLocator = "//*[contains(@class, 'modal-body')]//*[text()='%s']/parent::*[contains(@class,'slds-form-element')]//input";
    String lookupOption = "(//*[contains(@class, 'modal-body')]//*[contains(text(), '%s')]/ancestor::lightning-base-combobox-item) [1]";

    public LightLookup(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void selectOption(String option) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        System.out.printf("Selecting option '%s' from %s lookup \n", option, label);
        WebElement element = driver.findElement(By.xpath(String.format(inputLocator, label)));
        executor.executeScript("arguments[0].click();", element);
        WebElement element1 = driver.findElement(By.xpath(String.format(lookupOption, option)));
        executor.executeScript("arguments[0].click();", element1);
    }
}
