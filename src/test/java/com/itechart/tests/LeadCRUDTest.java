package com.itechart.tests;

import com.itechart.models.Lead;
import com.itechart.pages.lead.LeadDetailsPage;
import com.itechart.pages.lead.LeadListViewPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LeadCRUDTest extends BaseTest {

    @Test
    public void createReadUpdateDeleteLeadRecord() {
        Lead lead = new Lead("New", "Mr.", "Record", "for", "Success",
                "Delete", "Boss", "pp41@mailinator.com", "54321", "12345",
                "Hot", "test.com", "Google", "Banking",
                "10", "Partner", "Test Street", "Test City", "02240",
                "NY", "NY");
        LeadListViewPage leadListViewPage = new LeadListViewPage(driver);
        LeadDetailsPage detailsPage =
                leadListViewPage
                        .open()
                        .clickNewButton()
                        .enterData(lead)
                        .clickSaveButton();
        Assert.assertTrue(detailsPage.isPageOpened(), "Title is not correct");
        boolean isRecordDeleted =
                detailsPage
                        .openDetails()
                        .validate(lead)
                        .clickDeleteButton()
                        .delete()
                        .isSuccessDeleteMessageDisplayed();
        Assert.assertTrue(isRecordDeleted, "Record deletion failed");
    }
}
