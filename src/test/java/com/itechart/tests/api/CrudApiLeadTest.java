package com.itechart.tests.api;

import com.itechart.models.Lead;
import com.itechart.models.ResponseStatus;
import com.itechart.tests.BaseTest;
import com.itechart.tests.adapters.LeadAdapter;
import com.itechart.tests.configurations.Retry;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CrudApiLeadTest extends BaseTest {

    @Test(retryAnalyzer = Retry.class, description = "Create Lead")
    public void createGetUpdateDeleteLead() {
        Lead lead = new Lead("New", "Mr.", "Lead", "TestApi",
                "Boss", "pp41@mailinator.com", "54321", "12345",
                "Hot", "test.com", "Google", "Banking",
                "10", "Partner", "Test Street", "Test City",
                "NY");
        ResponseStatus response = new LeadAdapter().create(lead);
        Assert.assertTrue(response.isSuccess(), "Response is not correct");
        lead = leadAdapter.get(response.getId());
        Assert.assertEquals(lead.getName(), "Mr. Lead TestApi", "Response is not correct");
        Lead updatedLead = new Lead("New", "Mr.", "Lead", "TestApi Updated",
                "Boss", "pp41@mailinator.com", "54321", "12345",
                "Hot", "test.com", "Google", "Banking",
                "10", "Partner", "Test Street", "Test City",
                "NY");
        leadAdapter.update(updatedLead, response.getId());
        lead = leadAdapter.get(response.getId());
        Assert.assertEquals(lead.getName(), "Mr. Lead TestApi Updated", "Update request is not correct");
        leadAdapter.delete(response.getId());
    }
}
