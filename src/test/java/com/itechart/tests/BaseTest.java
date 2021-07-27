package com.itechart.tests;

import com.itechart.pages.HomePage;
import com.itechart.pages.LoginPage;
import com.itechart.utils.PropertyReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;


import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected HomePage homePage;
    protected PropertyReader propertyReader = new PropertyReader("src/main/resources/configuration.properties");
    protected final String USERNAME = propertyReader.getPropertyValueByKey("username");
    protected final String PASSWORD = propertyReader.getPropertyValueByKey("password");
    protected final String URL = propertyReader.getPropertyValueByKey("baseUrl");

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @BeforeMethod
    public void goToLoginPage() {
        driver.get(URL);
        loginPage = new LoginPage(driver);
        homePage = loginPage.login(USERNAME,PASSWORD);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

    private void setCookie() {
        Cookie cookie = new Cookie
                .Builder(USERNAME, PASSWORD)
                .domain(URL)
                .build();
        driver.manage().addCookie(cookie);
    }
}
