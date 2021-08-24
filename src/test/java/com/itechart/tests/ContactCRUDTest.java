package com.itechart.tests;

import com.itechart.pages.contact.ContactDetailsPage;
import com.itechart.pages.contact.ContactListViewPage;
import com.itechart.models.Contact;
import com.itechart.tests.configurations.Retry;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactCRUDTest extends BaseTest {

    @Test(retryAnalyzer = Retry.class, description = "Create Read Update Contact record")
    public void testCreateNewContact() {
        Contact contact = new Contact("Mr.", "Test4", "Contact6", "Test Account",
                "Test4 Test5 Contact6 Test7", "Test8",
                "Test9", "test@tes.t", "12945678", "+3751730000", "+3752930000");
        ContactListViewPage contactListViewPage = new ContactListViewPage(driver);
        ContactDetailsPage detailsPage =
                contactListViewPage
                        .open()
                        .clickNewButton()
                        .enterData(contact)
                        .clickSaveButton();
        Assert.assertTrue(detailsPage.isPageOpened(), "Title is not correct");
        Contact contact2 = new Contact("Ms.", "Test4",
                "Contact6", "Test Account",
                "Con Chen In", "Test88",
                "Test99", "test@tes.t", "129456789", "+3751733000", "+3752933000");
        boolean isRecordDeleted =
                detailsPage
                        .openDetails()
                        .validate(contact)
                        .clickEditDetailsButton()
                        .clearData()
                        .enterData(contact2)
                        .clickSaveButton()
                        .validate(contact2)
                        .clickDeleteButton()
                        .delete()
                        .isSuccessDeleteMessageDisplayed();
        Assert.assertTrue(isRecordDeleted, "Record deletion failed");
    }
}
