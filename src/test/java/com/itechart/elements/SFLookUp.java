package com.itechart.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SFLookUp {
    WebDriver driver;
    String label;
    String inputLocator = "//*[contains(@class, 'modal-body')]//*[text()='%s']" +
            "/ancestor::div[contains(@class,'uiInput')]//input";
    String lookupOption = "(//div[contains(@title, '%s')]//ancestor::li[not(contains(@class, 'invisible'))]) [1]";
    String DELETE_ACTION_LOCATOR = "//*[contains(@class, 'modal-body')]//*[text()='%s']/ancestor::*[contains(@class,'uiInput')]//a[@class='deleteAction']";

    public SFLookUp(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void selectOption(String option) {
        By LOOKUP_OPTION = By.xpath(String.format(lookupOption, option));
        driver.findElement(By.xpath(String.format(inputLocator, label))).click();
        System.out.printf("Selecting option '%s' from %s lookup \n", option, label);
        WebElement element = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(LOOKUP_OPTION));
        driver.findElement(LOOKUP_OPTION).click();
    }

    public void clear() {
        System.out.printf("Deleting lookup of %s \n", label);
        WebElement element = new WebDriverWait(driver, 5).until(ExpectedConditions
                .presenceOfElementLocated(By.xpath(String.format(DELETE_ACTION_LOCATOR, label))));
        driver.findElement(By.xpath(String.format(DELETE_ACTION_LOCATOR, label))).click();
    }
}
