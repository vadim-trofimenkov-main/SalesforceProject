package com.itechart.tests;

import com.itechart.pages.account.AccountDetailsPage;
import com.itechart.pages.account.AccountListViewPage;
import com.itechart.models.Account;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateNewAccountTest extends BaseTest {
    @Test
    public void createNewAccountRecord() {
        Account account = new Account("Test Account", "Test Account", "Investor", "test", "Banking",
                "123", "test desc", "123", "Test Address", "Test Address",
                "Test Address", "Test Address", "Test Address", "Test Address",
                "Test Address", "Test Address", "Test Address", "Test Address", propertyReader.getPropertyValueByKey("user"));
        AccountListViewPage accountListViewPage = new AccountListViewPage(driver);
        AccountDetailsPage detailsPage =
                accountListViewPage
                        .open()
                        .clickNewButton()
                        .enterData(account)
                        .clickSaveButton();
        Assert.assertTrue(detailsPage.isPageOpened(), "Account is not created");
        Account account2 = new Account("Test Account1", "Ac47 Test", "Analyst", "test1", "Apparel",
                "1234", "test descr", "456", "Test Address1", "Test Address1",
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
