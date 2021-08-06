package com.itechart.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SFInput {
    WebDriver driver;
    String label;
    String inputLocator = "//*[contains(@class, 'modal-body')]//*[text()='%s']/ancestor::div[contains(@class,'uiInput')]//input";
    private String lookupOption = "(//div[contains(@title, 'Test Account')]//ancestor::li[not(contains(@class, 'invisible'))]) [1]";

    public SFInput(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void write(String text) {
        System.out.printf("Writing text '%s' into input with label %s \n", text, label);
        WebElement element = new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(By.xpath(String.format(inputLocator, label))));
        driver.findElement(By.xpath(String.format(inputLocator, label))).sendKeys(text);
    }

    public void selectLookupOption(String option) {
        By LOOKUP_OPTION = By.xpath(String.format(lookupOption, option));
        driver.findElement(By.xpath(String.format(inputLocator, label))).click();
        System.out.printf("Selecting option '%s' from %s lookup \n", option, label);
        WebElement element = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(LOOKUP_OPTION));
        driver.findElement(LOOKUP_OPTION).click();
    }
}