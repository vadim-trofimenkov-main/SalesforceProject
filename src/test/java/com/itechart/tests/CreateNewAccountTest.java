package com.itechart.tests;

import com.itechart.pages.account.AccountDetailsPage;
import com.itechart.pages.account.AccountListViewPage;
import com.itechart.pages.account.AccountModalPage;
import models.Account;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateNewAccountTest extends BaseTest {
    @Test
    public void createNewAccountRecord() {
        homePage.goToPage("https://itechart4.lightning.force.com/lightning/o/Account/list?filterName=Recent");
        AccountModalPage modalPage = new AccountListViewPage(driver).clickNewButton();
        Account account = new Account("Test final1 Account","Investor", "Investor", "test",
                "Banking", "123", "test desc", "Banking", "Test Address",
                "Test Address", "Test Address", "Test Address", "Test Address",
                "Test Address", "Test Address", "Test Address", "Test Address",
                "Test Address","Test Address");
        modalPage.enterDataInNewRecordModalFields(account);
        AccountDetailsPage detailsPage = modalPage.clickSaveButton();
        Assert.assertTrue(detailsPage.getTitle().contains("Account"), "Account is not created");
        detailsPage.openDetails();
        detailsPage.validate("Test final1 Account","Test New Account", "Investor", "test", "Banking",
                "123", "test desc", "123", "Test Address\n" +
                        "Test Address, Test Address Test Address\n" +
                        "Test Address", "Test Address\n" +
                        "Test Address, Test Address Test Address\n" +
                        "Test Address",
                 "Vadim Trofimenkov");
    }
}
