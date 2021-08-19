package com.itechart.pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;

@Log4j2
public class HomePage extends BasePage {
    private final String homeUrl = propertyReader.getPropertyValueByKey("homepage");
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage open() {
        log.info("Opening Home page: {}", homeUrl);
        driver.get(homeUrl);
        return this;
    }
}


