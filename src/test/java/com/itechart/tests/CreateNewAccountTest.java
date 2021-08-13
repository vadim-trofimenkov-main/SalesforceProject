package com.itechart.tests;

import com.itechart.pages.account.AccountDetailsPage;
import com.itechart.models.Account;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateNewAccountTest extends BaseTest {
    @Test
    public void createNewAccountRecord() {
        Account account = new Account("Test Account", "Test Account", "Investor", "test", "Banking",
                "123", "test desc", "123", "Test Address", "Test Address",
                "Test Address", "Test Address", "Test Address", "Test Address",
                "Test Address", "Test Address", "Test Address", "Test Address");
        AccountDetailsPage detailsPage =
                homePage
                        .openAccountListViewPage()
                        .clickNewButton()
                        .enterData(account)
                        .clickSaveButton();
        Assert.assertTrue(detailsPage.isPageOpened(), "Account is not created");
        detailsPage
                .openDetails()
                .validate("Test Account", "Test Account", "Investor", "test", "Banking",
                        "123", "test desc", "123", "Test Address\n" +
                                "Test Address, Test Address Test Address\n" +
                                "Test Address", "Test Address\n" +
                                "Test Address, Test Address Test Address\n" +
                                "Test Address",
                        "Vadim Trofimenkov");
    }
}
