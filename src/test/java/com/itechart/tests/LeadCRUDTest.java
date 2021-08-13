package com.itechart.tests;

import com.itechart.models.Lead;
import com.itechart.pages.lead.LeadDetailsPage;
import com.itechart.pages.lead.LeadListViewPage;
import com.itechart.pages.lead.LeadModalPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LeadCRUDTest extends BaseTest {

    @Test
    public void createReadUpdateDeleteLeadRecord() {
        homePage.goToPage("https://itechart4.lightning.force.com/lightning/o/Lead/list?filterName=Recent");
        LeadListViewPage leadListViewPage = new LeadListViewPage(driver);
        LeadModalPage modalPage = leadListViewPage.clickNewButton();
        Lead lead = new Lead("New", "Mr.", "Record", "for", "Success",
                "Delete", "Boss", "pp41@mailinator.com", "54321", "12345",
                "Hot", "test.com", "Google", "Banking",
                "10", "Partner", "Test Street", "Test City", "02240",
                "NY", "NY");
        modalPage.enterData(lead);
        LeadDetailsPage detailsPage = modalPage.clickSaveButton();
        Assert.assertEquals(detailsPage.getTitle(), "Lead", "Title is not correct");
        detailsPage.openDetails();
        boolean isRecordDeleted = detailsPage
                                             .validate(lead)
                                             .clickDeleteButton()
                                             .delete()
                                             .isSuccessDeleteMessageDisplayed();
        Assert.assertTrue(isRecordDeleted, "Record deletion failed");
    }
}
