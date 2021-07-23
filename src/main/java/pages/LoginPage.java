package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final WebDriver driver;
    private static final By USERNAME_LOCATOR = By.id("username");
    private static final By PASSWORD_LOCATOR = By.id("password");
    private static final By LOGIN_BUTTON_LOCATOR = By.id("Login");
    private static final By ERROR_MESSAGE_LOCATOR = By.id("error");
    private static final By USERNAME_LABEL_LOCATOR = By.cssSelector(".usernamelabel");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage login(String username, String password) {
        driver.findElement(USERNAME_LOCATOR).sendKeys(username);
        driver.findElement(PASSWORD_LOCATOR).sendKeys(password);
        driver.findElement(LOGIN_BUTTON_LOCATOR).click();
        return new HomePage(driver);
    }

    public String getErrorMessage() {
        return driver.findElement(ERROR_MESSAGE_LOCATOR).getText();
    }

    public boolean isUsernameLabelDisplayed() {
        return driver.findElement(USERNAME_LABEL_LOCATOR).isDisplayed();
    }
}
