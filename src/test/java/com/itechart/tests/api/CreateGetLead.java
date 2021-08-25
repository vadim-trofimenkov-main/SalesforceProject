package com.itechart.tests.api;

import com.itechart.models.Lead;
import com.itechart.models.ResponseStatus;
import com.itechart.tests.BaseTest;
import com.itechart.tests.adapters.LeadAdapter;
import com.itechart.tests.configurations.Retry;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateGetLead extends BaseTest {

    @Test(retryAnalyzer = Retry.class, description = "Create Lead")
    public void createLeadTest() {
        Lead lead = new Lead("New", "Mr.", "Lead", "TestApi",
                "Boss", "pp41@mailinator.com", "54321", "12345",
                "Hot", "test.com", "Google", "Banking",
                "10", "Partner", "Test Street", "Test City",
                "NY");
        ResponseStatus actual = new LeadAdapter().create(lead);
        Assert.assertTrue(actual.isSuccess(), "Response is not correct");
    }

    @Test(retryAnalyzer = Retry.class, description = "Get Lead")
    public void getLeadTest() {
        Lead actual = new LeadAdapter().getLead("00Q5g000006cV7AEAU");
        Assert.assertEquals(actual.getName(), "Mr. Record Success", "Response is not correct");
    }
}
