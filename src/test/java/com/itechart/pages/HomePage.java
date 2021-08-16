package com.itechart.pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public HomePage open() {
        driver.get("https://itechart4.lightning.force.com/lightning/page/home");
        return this;
    }
}


