package com.itechart.steps;

import com.itechart.models.Account;
import com.itechart.pages.account.AccountDetailsPage;
import com.itechart.pages.account.AccountListViewPage;
import com.itechart.tests.ui.BaseTest;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

@Log4j2
public class AccountSteps extends BaseTest {
    private final AccountListViewPage accountListViewPage;
    private final AccountDetailsPage accountDetailsPage;

    public AccountSteps(WebDriver driver) {
        accountListViewPage = new AccountListViewPage(driver);
        accountDetailsPage = new AccountDetailsPage(driver);
    }

    @Step("Creating Account")
    public AccountSteps create(Account account) {
        log.info("Creating Account: {}", account);
        boolean isAccountCreated =
                accountListViewPage
                        .clickNewButton()
                        .enterData(account)
                        .clickSaveButton()
                        .isPageOpened();
        Assert.assertTrue(isAccountCreated, "Account is not created");
        return this;
    }

    @Step("Updating Account")
    public AccountSteps edit(Account account) {
        log.info("Editing Account: {}", account);
        accountDetailsPage
                .clickEditDetailsButton()
                .clearData()
                .enterData(account)
                .clickSaveButton();
        return this;
    }

    @Step("Opening Account List View Page")
    public AccountSteps openAccountListViewPage() {
        log.info("Opening Account List View Page");
        accountListViewPage.open();
        return this;
    }

    @Step("Validating Account")
    public AccountSteps validate(Account account) {
        log.info("Validating Account: {}", account);
        accountDetailsPage
                .openDetails()
                .validate(account);
        return this;
    }

    @Step("Deleting Account")
    public AccountSteps delete() {
        log.info("Deleting Account");
        boolean isRecordDeleted =
                accountDetailsPage
                        .clickDeleteButton()
                        .delete()
                        .isSuccessDeleteMessageDisplayed();
        Assert.assertTrue(isRecordDeleted, "Record deletion failed");
        return this;
    }
}
