package com.itechart.tests;

import com.itechart.models.Account;
import com.itechart.pages.account.AccountDetailsPage;
import com.itechart.pages.account.AccountListViewPage;
import com.itechart.tests.configurations.Retry;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountCRUDTest extends BaseTest {

    @Test(retryAnalyzer = Retry.class, description = "Create read update delete new Account record")
    public void createNewAccountRecord() {
        Account account = accountFactory.createNewAccount(true);
        login();
        AccountListViewPage accountListViewPage = new AccountListViewPage(driver);
        AccountDetailsPage detailsPage =
                accountListViewPage
                        .open()
                        .clickNewButton()
                        .enterData(account)
                        .clickSaveButton();
        Assert.assertTrue(detailsPage.isPageOpened(), "Account is not created");
        Account updatedAccount = accountFactory.createNewAccount(true);
        boolean isRecordDeleted =
                detailsPage
                        .openDetails()
                        .validate(account)
                        .clickEditDetailsButton()
                        .clearData()
                        .enterData(updatedAccount)
                        .clickSaveButton()
                        .openDetails()
                        .validate(updatedAccount)
                        .clickDeleteButton()
                        .delete()
                        .isSuccessDeleteMessageDisplayed();
        Assert.assertTrue(isRecordDeleted, "Record deletion failed");
    }
}
