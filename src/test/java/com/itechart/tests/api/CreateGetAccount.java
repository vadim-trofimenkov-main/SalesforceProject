package com.itechart.tests.api;

import com.itechart.models.Account;
import com.itechart.models.ResponseStatus;
import com.itechart.tests.BaseTest;
import com.itechart.tests.adapters.AccountAdapter;
import com.itechart.tests.configurations.Retry;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateGetAccount extends BaseTest {

    @Test(retryAnalyzer = Retry.class, description = "Create Account")
    public void createAccountTest() {
        Account account = new Account("Account TestApi", "0015g00000OYQYgAAP", "Investor", "test", "Banking",
                "123", "test desc", "123", "Test Address", "Test Address",
                "Test Address", "Test Address", "Test Address", "Test Address",
                "Test Address", "Test Address", "Test Address", "Test Address", "0055g00000CA2c5AAD");
        ResponseStatus actual = new AccountAdapter().create(account);
        Assert.assertTrue(actual.isSuccess(), "Response is not correct");
    }

    @Test(retryAnalyzer = Retry.class, description = "Get Account")
    public void getAccountTest() {
        Account actual = new AccountAdapter().getAccount("0015g00000P50EYAAZ");
        Assert.assertEquals(actual.getName(), "University of Arizona", "Response is not correct");
    }
}
