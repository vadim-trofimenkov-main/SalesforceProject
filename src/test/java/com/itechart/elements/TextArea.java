package com.itechart.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextArea {
    WebDriver driver;
    String label;
    String textAreaLocator = "//*[contains(@class, 'modal-body')]//*[text()='%s']" +
            "/ancestor::*[contains(@class, 'uiInput') or contains(@class, 'slds-form-element')]//textarea";

    public TextArea(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void write(String text) {
        System.out.printf("Writing text '%s' into text-area field with label %s", text, label);
        driver.findElement(By.xpath(String.format(textAreaLocator, label))).sendKeys(text);
    }
}
