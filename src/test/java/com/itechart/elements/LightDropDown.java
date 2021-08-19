package com.itechart.elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Log4j2
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
        log.info("Selecting option '{}' from {} lookup", option, label);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(By.xpath(String.format(inputLocator, label)));
        executor.executeScript("arguments[0].click();", element);
        WebElement element1 = driver.findElement(By.xpath(String.format(lookupOption, option)));
        executor.executeScript("arguments[0].click();", element1);
    }

    public void clear() {
        log.info("Clearing option in drop-down {}", label);
        WebElement waitInputVisibility = new WebDriverWait(driver, 5).until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath(String.format(inputLocator, label))));
        driver.findElement(By.xpath(String.format(inputLocator, label))).click();
        WebElement waitOptionPresence = new WebDriverWait(driver, 5).until(ExpectedConditions
                .presenceOfElementLocated(By.xpath(String.format(lookupOption, "--None--"))));
        driver.findElement(By.xpath(String.format(lookupOption, "--None--"))).click();
    }
}
