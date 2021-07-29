package com.itechart.pages;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void goToPage(String link){
        driver.get(link);
    }
}


