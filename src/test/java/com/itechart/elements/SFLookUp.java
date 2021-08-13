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
}
