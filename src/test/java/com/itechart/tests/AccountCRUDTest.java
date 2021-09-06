package com.itechart.tests;

import com.itechart.models.Account;
import com.itechart.tests.configurations.Retry;
import org.testng.annotations.Test;

public class AccountCRUDTest extends BaseTest {

    @Test(retryAnalyzer = Retry.class, description = "Create read update delete new Account record")
    public void createNewAccountRecord() {
        Account account = new Account("Test Account", "Test Account", "Prospect", "test", "Banking",
                "123", "test desc", "123", "Test Address", "Test Address",
                "Test Address", "Test Address", "Test Address", "Test Address",
                "Test Address", "Test Address", "Test Address", "Test Address", propertyReader.getPropertyValueByKey("user"));
        Account account2 = new Account("Test Account Updated", "Test Account", "Prospect", "test", "Banking",
                "123", "test desc", "123", "Test Address", "Test Address",
                "Test Address", "Test Address", "Test Address", "Test Address",
                "Test Address", "Test Address", "Test Address", "Test Address", propertyReader.getPropertyValueByKey("user"));
        mainSteps.login(USERNAME, PASSWORD);
        accountSteps
                .openAccountListViewPage()
                .createAccount(account)
                .validate(account)
                .editAccount(account2)
                .validate(account2)
                .delete();
    }
}