package com.itechart.tests;

import com.itechart.pages.account.AccountDetailsPage;
import com.itechart.pages.account.AccountListViewPage;
import com.itechart.pages.account.AccountModalPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateNewAccountTest extends BaseTest {
    @Test
    public void createNewAccountRecord() {
        homePage.goToPage("https://itechart4.lightning.force.com/lightning/o/Account/list?filterName=Recent");
        AccountListViewPage listViewPage = new AccountListViewPage(driver);
        AccountModalPage modalPage = listViewPage.clickNewButton();
        modalPage.enterDataInNewRecordModalFields("Test New Account", "Investor", "test", "Banking",
                "123", "test desc", "1234", "Test Address", "Test Address",
                "Test Address", "Test Address", "Test Address", "Test Address",
                "Test Address", "Test Address", "Test Address", "Test Address");
        AccountDetailsPage detailsPage = modalPage.clickSaveButton();
        Assert.assertTrue(detailsPage.getTitle().contains("Account"), "Account is not created");
    }
}
