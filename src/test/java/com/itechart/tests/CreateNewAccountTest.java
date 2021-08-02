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
        AccountModalPage modalPage = new AccountListViewPage(driver).clickNewButton();
        modalPage.enterDataInNewRecordModalFields("Test final6 Account","Test New Account", "Investor", "test", "Banking",
                "123", "test desc", "123", "Test Address", "Test Address",
                "Test Address", "Test Address", "Test Address", "Test Address",
                "Test Address", "Test Address", "Test Address", "Test Address");
        AccountDetailsPage detailsPage = modalPage.clickSaveButton();
        Assert.assertTrue(detailsPage.getTitle().contains("Account"), "Account is not created");
        detailsPage.openDetails();
        detailsPage.validate("Test final6 Account","Test New Account", "Investor", "test", "Banking",
                "123", "test desc", "123", "Test Address\n" +
                        "Test Address, Test Address Test Address\n" +
                        "Test Address", "Test Address\n" +
                        "Test Address, Test Address Test Address\n" +
                        "Test Address",
                 "Vadim Trofimenkov");
    }
}
