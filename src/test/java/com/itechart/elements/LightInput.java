package com.itechart.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LightInput {
    WebDriver driver;
    String label;
    String inputLocator = "//*[contains(@class, 'modal-body')]//*[text()='%s']/parent::*[contains(@class,'slds-form-element')]//input";
    private String lookupOption = "(//*[contains(@class, 'modal-body')]//*[contains(text(), '%s')]/ancestor::lightning-base-combobox-item[@aria-selected='true']) [1]";

    public LightInput(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void write(String text) {
        System.out.printf("Writing text '%s' into input with label %s \n", text, label);
        driver.findElement(By.xpath(String.format(inputLocator, label))).sendKeys(text);
    }

    public void selectLookupOption(String option) {
        By LOOKUP_OPTION = By.xpath(String.format(lookupOption, option));
        driver.findElement(By.xpath(String.format(inputLocator,label))).click();
        System.out.printf("Selecting option '%s' from %s lookup \n", option, label);
        WebElement element = new WebDriverWait(driver,5)
                .until(ExpectedConditions.presenceOfElementLocated(LOOKUP_OPTION));
        driver.findElement(LOOKUP_OPTION).click();
    }
}
