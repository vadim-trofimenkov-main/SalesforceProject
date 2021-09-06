package com.itechart.steps;

import com.itechart.models.Account;
import com.itechart.pages.account.AccountDetailsPage;
import com.itechart.pages.account.AccountListViewPage;
import com.itechart.tests.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AccountSteps extends BaseTest {
    private final AccountListViewPage accountListViewPage;
    private final AccountDetailsPage accountDetailsPage;

    public AccountSteps(WebDriver driver) {
        accountListViewPage = new AccountListViewPage(driver);
        accountDetailsPage = new AccountDetailsPage(driver);
    }

    public AccountSteps create(Account account) {
        boolean isAccountCreated =
                accountListViewPage
                        .clickNewButton()
                        .enterData(account)
                        .clickSaveButton()
                        .isPageOpened();
        Assert.assertTrue(isAccountCreated, "Account is not created");
        return this;
    }

    public AccountSteps edit(Account account) {
        accountDetailsPage
                .clickEditDetailsButton()
                .clearData()
                .enterData(account)
                .clickSaveButton();
        return this;
    }

    public AccountSteps openAccountListViewPage() {
        accountListViewPage.open();
        return this;
    }

    public AccountSteps validate(Account account) {
        accountDetailsPage
                .openDetails()
                .validate(account);
        return this;
    }

    public AccountSteps delete() {
        boolean isRecordDeleted =
                accountDetailsPage
                        .clickDeleteButton()
                        .delete()
                        .isSuccessDeleteMessageDisplayed();
        Assert.assertTrue(isRecordDeleted, "Record deletion failed");
        return this;
    }
}
