package com.itechart.elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class LightInput {
    WebDriver driver;
    String label;
    String inputLocator = "//*[contains(@class, 'modal-body')]//*[text()='%s']/parent::*[contains(@class,'slds-form-element')]//input";

    public LightInput(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void write(String text) {
        log.debug(String.format("Writing text '%s' into input with label %s \n", text, label));
        driver.findElement(By.xpath(String.format(inputLocator, label))).sendKeys(text);
    }

    public void clear() {
        log.debug(String.format("Deleting text from input with label %s \n", label));
        driver.findElement(By.xpath(String.format(inputLocator, label))).clear();
    }
}
