package com.itechart.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SFDropDown {
    WebDriver driver;
    String label;
    String locator = "//*[contains(@class, 'modal-body')]//span[text()='%s']" +
            "/ancestor::div[contains(@class,'uiInput')]//a";
    String optionLocator = "//*[contains(@class, 'uiMenuList') and contains(@class, 'visible')]//a[@title='%s']";

    public SFDropDown(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void select(String option) {
        driver.findElement(By.xpath(String.format(locator, label))).click();
        System.out.printf("Selecting option '%s' in drop-down %s\n", option, label);
        WebElement element = new WebDriverWait(driver, 5).until(ExpectedConditions
                .presenceOfElementLocated(By.xpath(String.format(optionLocator, option))));
        driver.findElement(By.xpath(String.format(optionLocator, option))).click();
    }

    public void clear() {
        driver.findElement(By.xpath(String.format(locator, label))).click();
        System.out.printf("Clearing option in drop-down %s\n", label);
        WebElement element = new WebDriverWait(driver, 5).until(ExpectedConditions
                .presenceOfElementLocated(By.xpath(String.format(optionLocator, "--None--"))));
        driver.findElement(By.xpath(String.format(optionLocator, "--None--"))).click();
    }
}
