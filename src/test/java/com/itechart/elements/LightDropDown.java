package com.itechart.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LightDropDown {
    WebDriver driver;
    String label;
    String inputLocator = "//*[contains(@class, 'modal-body')]//*[text()='%s']/parent::*[contains(@class,'slds-form-element')]//input";
    String lookupOption = "(//*[contains(@class, 'modal-body')]//*[contains(text(), '%s')]/ancestor::lightning-base-combobox-item) [1]";

    public LightDropDown(WebDriver driver, String label) {
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
    public void clear() {
        driver.findElement(By.xpath(String.format(inputLocator, label))).click();
        System.out.printf("Clearing option in drop-down %s\n", label);
        WebElement element = new WebDriverWait(driver, 5).until(ExpectedConditions
                .presenceOfElementLocated(By.xpath(String.format(lookupOption, "--None--"))));
        driver.findElement(By.xpath(String.format(lookupOption, "--None--"))).click();
    }
}
