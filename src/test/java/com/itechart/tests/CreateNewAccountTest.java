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
        Account account = new Account("Test Account", "Test Account", "Investor", "test", "Banking",
                "123", "test desc", "123", "Test Address", "Test Address",
                "Test Address", "Test Address", "Test Address", "Test Address",
                "Test Address", "Test Address", "Test Address", "Test Address");
        modalPage.enterData(account);
        AccountDetailsPage detailsPage = modalPage.clickSaveButton();
        Assert.assertTrue(detailsPage.getTitle().contains("Account"), "Account is not created");
        detailsPage.openDetails();
        detailsPage.validate(account);
        detailsPage.clickEditDetailsButton().clearData();
        Account account2 = new Account("Test Account1", "Test Account", "Analyst", "test1", "Apparel",
                "1234", "test descr", "1234", "Test Address1", "Test Address1",
                "Test Address1", "Test Address1", "Test Address1", "Test Address1",
                "Test Address1", "Test Address1", "Test Address1", "Test Address1");
        modalPage.enterData(account2);
        modalPage
                .clickSaveButton()
                .openDetails()
                .validate(account2);
    }
}
