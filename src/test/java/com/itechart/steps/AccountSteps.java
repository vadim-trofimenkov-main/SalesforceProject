package com.itechart.steps;

import com.itechart.models.Account;
import com.itechart.pages.account.AccountDetailsPage;
import com.itechart.pages.account.AccountListViewPage;
import com.itechart.pages.account.AccountModalPage;
import com.itechart.tests.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AccountSteps extends BaseTest {
    private final WebDriver driver;
    private AccountListViewPage accountListViewPage;
    private AccountDetailsPage accountDetailsPage;
    private AccountModalPage accountModalPage;
    private Account account;

    public AccountSteps(WebDriver driver) {
        this.driver = driver;
        accountListViewPage = new AccountListViewPage(driver);
    }

    public void openAccountListViewPage() {
        accountListViewPage.open();
    }

    public void openDetails() {
        accountDetailsPage.openDetails();
    }

    public void validate() {
        accountDetailsPage.validate(account);
    }

    public void clickEditDetailsButton() {
        accountModalPage = accountDetailsPage.clickEditDetailsButton();
    }

    public void clearData() {
        accountModalPage.clearData();
    }

    public void clickNewButton() {
        accountModalPage = accountListViewPage.clickNewButton();
    }

    public void enterData() {
        initAccount();
        accountModalPage.enterData(account);
    }

    public void clickSaveButton() {
        accountDetailsPage = accountModalPage.clickSaveButton();
    }

    public void checkDetailsPageIsOpened() {
        Assert.assertTrue(accountDetailsPage.isPageOpened(), "Account is not created");
    }

    public void clickDeleteButton() {
        accountDetailsPage.clickDeleteButton();
    }

    public void delete() {
        accountListViewPage = accountDetailsPage.delete();
    }

    public void checkIsAccountDeleted() {
        boolean isRecordDeleted = accountListViewPage.isSuccessDeleteMessageDisplayed();
        Assert.assertTrue(isRecordDeleted, "Record deletion failed");
    }

    public void initAccount() {
        account = new Account("Test Account", "Test Account", "Prospect", "test", "Banking",
                "123", "test desc", "123", "Test Address", "Test Address",
                "Test Address", "Test Address", "Test Address", "Test Address",
                "Test Address", "Test Address", "Test Address", "Test Address", propertyReader.getPropertyValueByKey("user"));
    }
}
