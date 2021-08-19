package com.itechart.pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;

@Log4j2
public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage open() {
        log.info("Opening Home page");
        driver.get("https://itechart4.lightning.force.com/lightning/page/home");
        return this;
    }
}


