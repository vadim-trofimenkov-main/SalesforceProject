package com.itechart.tests;

import com.itechart.tests.configurations.Retry;
import org.testng.annotations.Test;

public class AccountCRUDTest extends BaseTest {

    @Test(retryAnalyzer = Retry.class, description = "Create read update delete new Account record")
    public void createNewAccountRecord() {
        mainSteps.openLoginPage();
        mainSteps.login(USERNAME, PASSWORD);
        accountSteps.openAccountListViewPage();
        accountSteps.clickNewButton();
        accountSteps.enterData();
        accountSteps.clickSaveButton();
        accountSteps.checkDetailsPageIsOpened();
        accountSteps.openDetails();
        accountSteps.validate();
        accountSteps.clickEditDetailsButton();
        accountSteps.clearData();
        accountSteps.enterData();
        accountSteps.clickSaveButton();
        accountSteps.openDetails();
        accountSteps.validate();
        accountSteps.clickDeleteButton();
        accountSteps.delete();
        accountSteps.checkIsAccountDeleted();
    }
}