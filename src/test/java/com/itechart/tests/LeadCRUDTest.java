package com.itechart.tests;

import com.itechart.models.Lead;
import com.itechart.pages.lead.LeadDetailsPage;
import com.itechart.pages.lead.LeadListViewPage;
import com.itechart.tests.configurations.Retry;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LeadCRUDTest extends BaseTest {

    @Test(retryAnalyzer = Retry.class, description = "Create Read Update Lead record")
    public void createReadUpdateDeleteLeadRecord() {
        Lead lead = leadFactory.createNewLead();
        login();
        LeadListViewPage leadListViewPage = new LeadListViewPage(driver);
        LeadDetailsPage detailsPage =
                leadListViewPage
                        .open()
                        .clickNewButton()
                        .enterData(lead)
                        .clickSaveButton();
        Assert.assertTrue(detailsPage.isPageOpened(), "Title is not correct");
        Lead updatedLead = leadFactory.createNewLead();
        boolean isRecordDeleted =
                detailsPage
                        .openDetails()
                        .validate(lead)
                        .clickEditDetailsButton()
                        .clearData()
                        .enterData(updatedLead)
                        .clickSaveButton()
                        .openDetails()
                        .validate(updatedLead)
                        .clickDeleteButton()
                        .delete()
                        .isSuccessDeleteMessageDisplayed();
        Assert.assertTrue(isRecordDeleted, "Record deletion failed");
    }
}
