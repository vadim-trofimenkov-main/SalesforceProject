package com.itechart.tests;

import com.github.javafaker.Faker;
import com.itechart.pages.HomePage;
import com.itechart.pages.LoginPage;
import com.itechart.tests.adapters.AccountAdapter;
import com.itechart.tests.adapters.ContactAdapter;
import com.itechart.tests.adapters.LeadAdapter;
import com.itechart.tests.configurations.TestListener;
import com.itechart.utils.PropertyReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import java.util.concurrent.TimeUnit;

@Log4j2
@Listeners(TestListener.class)
public abstract class BaseTest {
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected HomePage homePage;
    protected Faker faker = new Faker();
    protected PropertyReader propertyReader = new PropertyReader("src/test/resources/configuration.properties");
    protected final String USERNAME = propertyReader.getPropertyValueByKey("username");
    protected final String PASSWORD = propertyReader.getPropertyValueByKey("password");

    @BeforeClass(description = "Open browser")
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);
    }

    public void login() {
        homePage =
                loginPage.open()
                         .login(USERNAME, PASSWORD);
    }

    public void goToHomePage() {
        homePage.open();
    }

    @AfterClass(alwaysRun = true, description = "Close browser")
    public void tearDown() {
        if (driver != null)
            driver.quit();
    }
}
