package com.itechart.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Input {
    WebDriver driver;
    String label;
    String inputAccountLocator = "//*[contains(@class, 'modal-body')]//span[text()='%s']" +
            "/ancestor::div[contains(@class,'uiInput')]//input";
    String inputContactLocator = "//*[contains(@class, 'modal-body')]//label[text()='%s']/ancestor::lightning-input//input";


    public Input(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void accountWrite(String text) {
        System.out.printf("Writing text '%s' into input with label %s \n", text, label);
        driver.findElement(By.xpath(String.format(inputAccountLocator,label))).sendKeys(text);
    }
    public void contactWrite(String text) {
        System.out.printf("Writing text '%s' into input with label %s \n", text, label);
        driver.findElement(By.xpath(String.format(inputContactLocator,label))).sendKeys(text);
    }
}
