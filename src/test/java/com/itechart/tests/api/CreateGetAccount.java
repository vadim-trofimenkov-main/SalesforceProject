package com.itechart.tests.api;

import com.itechart.models.Account;
import com.itechart.models.ResponseStatus;
import com.itechart.tests.BaseTest;
import com.itechart.tests.adapters.AccountAdapter;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateGetAccount extends BaseTest {
    @Test
    public void createAccountTest() {
        Account account = new Account("Test Account7", "0015g00000OYQYgAAP", "Investor", "test", "Banking",
                "123", "test desc", "123", "Test Address", "Test Address",
                "Test Address", "Test Address", "Test Address", "Test Address",
                "Test Address", "Test Address", "Test Address", "Test Address", "0055g00000CA2c5AAD");
        ResponseStatus actual = new AccountAdapter().create(account);
        Assert.assertTrue(actual.isSuccess(), "Response is not correct");
    }

    @Test
    public void getAccountTest() {
        Account actual = new AccountAdapter().getAccount("0015g00000OYSDhAAP");
        Assert.assertEquals(actual.getName(), "Test Account2", "Response is not correct");
    }
}
