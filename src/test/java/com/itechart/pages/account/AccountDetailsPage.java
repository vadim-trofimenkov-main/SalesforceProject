package com.itechart.pages.account;

import com.itechart.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class AccountDetailsPage extends BasePage {

    private final By ACCOUNT_TITLE = By.xpath("//div[@class='entityNameTitle slds-line-height--reset' and contains(text(), 'Account')]");
    private final By DETAILS_TAB = By.xpath("//a[@data-label='Details']");
    private String accountTextField = "//lightning-formatted-text[@data-output-element-id='output-field' and contains(text(), '%s')]"; //locator is used for name, type, description and industry fields
    private String accountHyperLinkField = "//a[contains(text(), '%s')]";  //locator is used for website, phone fields
    private String hoverableLink = "//p[@title ='Account Owner']/following::span[contains(text(), '%s')][1]"; //locator is used for Account Owner, Parent Account fields
    private String accountNumberField = "//lightning-formatted-number[@data-output-element-id='output-field' and contains(text(), '%s')]";
    private String accountShippingAddressField = "//lightning-formatted-address[@data-output-element-id='output-field']/following::a[contains(@title, 'Test Address')]";
    private String accountBillingAddressField = "//span[@class='test-id__field-label' and contains(text(), 'Billing Address')]" +
            "/ancestor::div[contains(@class, 'test-id__output-root')]/div[@class='slds-form-element__control']" +
            "//a[contains(@title, 'Test Address')]";

    public AccountDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        wait.until(ExpectedConditions.presenceOfElementLocated(DETAILS_TAB));
        return driver.findElement(DETAILS_TAB).isDisplayed();
    }


    public String getTitle() {
        wait.until(ExpectedConditions.presenceOfElementLocated(ACCOUNT_TITLE));
        return driver.findElement(ACCOUNT_TITLE).getText();
    }

    public void openDetails() {
        driver.findElement(DETAILS_TAB).click();
    }

    public void validate(String name, String parentAccount, String type, String website, String industry,
                         String phone, String description, String employees, String billingAddress,
                         String shippingAddress, String accountOwner) {
        if (!isPageOpened()) throw new RuntimeException("Page is not opened");
        Assert.assertTrue(driver.findElement(By.xpath(String.format(accountTextField, name))).getText().contains(name),
                "Wrong Account Name field");
        Assert.assertTrue(driver.findElement(By.xpath(String.format(accountTextField, type))).getText().contains(type),
                "Wrong Type field");
        Assert.assertTrue(driver.findElement(By.xpath(String.format(accountTextField, description))).getText().contains(description),
                "Wrong Description field");
        Assert.assertTrue(driver.findElement(By.xpath(String.format(accountTextField, industry))).getText().contains(industry),
                "Wrong Industry field");
        Assert.assertTrue(driver.findElement(By.xpath(String.format(accountHyperLinkField, website))).getText().contains(website),
                "Wrong Website field");
        Assert.assertTrue(driver.findElement(By.xpath(String.format(hoverableLink, accountOwner))).getText().contains(accountOwner),
                "Wrong Account Owner field");
        Assert.assertTrue(driver.findElement(By.xpath(String.format(hoverableLink, parentAccount))).getText().contains(parentAccount),
                "Wrong Parent Account field");
        Assert.assertTrue(driver.findElement(By.xpath(String.format(accountHyperLinkField, phone))).getText().contains(phone),
                "Wrong Phone field");
        Assert.assertTrue(driver.findElement(By.xpath(String.format(accountNumberField, employees))).getText().contains(employees),
                "Wrong Employees field");
        Assert.assertEquals(driver.findElement(By.xpath(accountBillingAddressField)).getText(), billingAddress,
                "Wrong Billing Address field");
        Assert.assertEquals(driver.findElement(By.xpath(accountShippingAddressField)).getText(), shippingAddress,
                "Wrong Shipping Address field");
    }
}
