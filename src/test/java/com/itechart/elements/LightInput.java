package com.itechart.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class LightInput {
    WebDriver driver;
    String label;
    String inputLocator = "//*[contains(@class, 'modal-body')]//*[text()='%s']/parent::*[contains(@class,'slds-form-element')]//input";

    public LightInput(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void write(String text) {
        System.out.printf("Writing text '%s' into input with label %s \n", text, label);
        driver.findElement(By.xpath(String.format(inputLocator, label))).sendKeys(text);
    }

    public void clear() {
        System.out.printf("Deleting text from input with label %s \n", label);
        driver.findElement(By.xpath(String.format(inputLocator, label))).clear();
    }
}
