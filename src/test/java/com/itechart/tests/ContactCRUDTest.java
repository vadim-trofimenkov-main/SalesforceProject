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
        Contact contact = contactFactory.createNewContact(true);
        login();
        ContactListViewPage contactListViewPage = new ContactListViewPage(driver);
        ContactDetailsPage detailsPage =
                contactListViewPage
                        .open()
                        .clickNewButton()
                        .enterData(contact)
                        .clickSaveButton();
        Assert.assertTrue(detailsPage.isPageOpened(), "Title is not correct");
        Contact updatedContact = contactFactory.createNewContact(true);
        boolean isRecordDeleted =
                detailsPage
                        .openDetails()
                        .validate(contact)
                        .clickEditDetailsButton()
                        .clearData()
                        .enterData(updatedContact)
                        .clickSaveButton()
                        .validate(updatedContact)
                        .clickDeleteButton()
                        .delete()
                        .isSuccessDeleteMessageDisplayed();
        Assert.assertTrue(isRecordDeleted, "Record deletion failed");
    }
}
