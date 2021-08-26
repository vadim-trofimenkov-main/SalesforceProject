package com.itechart.tests.api;

import com.itechart.models.Account;
import com.itechart.models.ResponseStatus;
import com.itechart.tests.BaseTest;
import com.itechart.tests.configurations.Retry;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CrudApiAccountTest extends BaseTest {

    @Test(retryAnalyzer = Retry.class, description = "CRUD API Account")
    public void createGetUpdateDeleteAccount() {
        Account account = new Account("Account TestApi", "0015g00000PrprjAAB", "Investor", "test", "Banking",
                "123", "test desc", "123", "Test Address", "Test Address",
                "Test Address", "Test Address", "Test Address", "Test Address",
                "Test Address", "Test Address", "Test Address", "Test Address", "0055g00000CA2c5AAD");
        ResponseStatus response = accountAdapter.create(account);
        Assert.assertTrue(response.isSuccess(), "Create Response is not correct");
        account = accountAdapter.get(response.getId());
        Assert.assertEquals(account.getName(), "Account TestApi", "Get Response is not correct");
        Account updatedAccount = new Account("Account TestApi Updated", "0015g00000PrprjAAB", "Investor", "test", "Banking",
                "123", "test desc", "123", "Test Address", "Test Address",
                "Test Address", "Test Address", "Test Address", "Test Address",
                "Test Address", "Test Address", "Test Address", "Test Address", "0055g00000CA2c5AAD");
        accountAdapter.update(updatedAccount, response.getId());
        account = accountAdapter.get(response.getId());
        Assert.assertEquals(account.getName(), "Account TestApi Updated", "Update request is not correct");
        accountAdapter.delete(response.getId());
    }
}
