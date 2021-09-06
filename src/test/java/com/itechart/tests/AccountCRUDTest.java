package com.itechart.tests;

import com.itechart.models.Account;
import com.itechart.tests.configurations.Retry;
import org.testng.annotations.Test;

public class AccountCRUDTest extends BaseTest {

    @Test(retryAnalyzer = Retry.class, description = "Create read update delete new Account record")
    public void createNewAccountRecord() {
        Account account = accountFactory.createNewAccount(true);
        Account updatedAccount = accountFactory.createNewAccount(true);
        mainSteps.login(USERNAME, PASSWORD);
        accountSteps
                .openAccountListViewPage()
                .createAccount(account)
                .validate(account)
                .editAccount(updatedAccount)
                .validate(updatedAccount)
                .delete();
    }
}