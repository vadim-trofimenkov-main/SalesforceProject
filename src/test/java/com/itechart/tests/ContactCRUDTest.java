package com.itechart.tests;

import com.itechart.pages.contact.ContactDetailsPage;
import com.itechart.pages.contact.ContactListViewPage;
import com.itechart.models.Contact;
import com.itechart.tests.configurations.Retry;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactCRUDTest extends BaseTest {

    @Test(retryAnalyzer = Retry.class, description = "Create Read Update Contact record", priority = 1)
    public void testCreateNewContact() {
        Contact contact = new Contact("Mr.", "Test4", "Contact6", "Test Account",
                "Test4 Test5 Contact6 Test7", "Test title",
                "test@tes.t", "test Department", "12945678", "+3751730000", "+3752930000");
        login();
        ContactListViewPage contactListViewPage = new ContactListViewPage(driver);
        ContactDetailsPage detailsPage =
                contactListViewPage
                        .open()
                        .clickNewButton()
                        .enterData(contact)
                        .clickSaveButton();
        Assert.assertTrue(detailsPage.isPageOpened(), "Title is not correct");
        Contact contact2 = new Contact("Ms.", "Test4",
                "Contact Not Deleted", "Test Account",
                "Alex Svitkin", "Boss",
                "test@tes.updated", "Department Updated", "129456789", "+3751733000", "+3752933000");
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
