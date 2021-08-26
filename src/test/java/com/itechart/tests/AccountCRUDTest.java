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
        Account account = new Account("Test Account", "Test Account", "Prospect", "test", "Banking",
                "123", "test desc", "123", "Test Address", "Test Address",
                "Test Address", "Test Address", "Test Address", "Test Address",
                "Test Address", "Test Address", "Test Address", "Test Address", propertyReader.getPropertyValueByKey("user"));
        login();
        AccountListViewPage accountListViewPage = new AccountListViewPage(driver);
        AccountDetailsPage detailsPage =
                accountListViewPage
                        .open()
                        .clickNewButton()
                        .enterData(account)
                        .clickSaveButton();
        Assert.assertTrue(detailsPage.isPageOpened(), "Account is not created");
        Account account2 = new Account("Test Account Not Deleted", "Test Updated", "Technology Partner", "test1", "Apparel",
                "1234", "test description", "456", "Test Address1", "Test Address1",
                "Test Address1", "Test Address1", "Test Address1", "Test Address1",
                "Test Address1", "Test Address1", "Test Address1", "Test Address1", propertyReader.getPropertyValueByKey("user"));
        boolean isRecordDeleted =
                detailsPage
                        .openDetails()
                        .validate(account)
                        .clickEditDetailsButton()
                        .clearData()
                        .enterData(account2)
                        .clickSaveButton()
                        .openDetails()
                        .validate(account2)
                        .clickDeleteButton()
                        .delete()
                        .isSuccessDeleteMessageDisplayed();
        Assert.assertTrue(isRecordDeleted, "Record deletion failed");
    }
}
