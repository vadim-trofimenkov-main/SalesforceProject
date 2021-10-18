package com.itechart.tests.ui;

import com.itechart.models.Account;
import com.itechart.configurations.Retry;
import org.testng.annotations.Test;

public class AccountCRUDTest extends TestBase {
    @Test(retryAnalyzer = Retry.class, description = "Create Read Update Delete Account record")
    public void createNewAccountRecord() {
        Account account = accountFactory.createNewAccount(true);
        Account updatedAccount = accountFactory.createNewAccount(true);
        loginSteps.login(USERNAME, PASSWORD);
        accountSteps
                .openAccountListViewPage()
                .create(account)
                .validate(account)
                .edit(updatedAccount)
                .validate(updatedAccount)
                .delete();
    }
}