package com.itechart.tests;

import com.itechart.pages.contact.ContactDetailsPage;
import com.itechart.pages.contact.ContactListViewPage;
import com.itechart.models.Contact;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateNewContactTest extends BaseTest {

    @Test
    public void testCreateNewContact() {
        Contact contact = new Contact("Mr.", "Test4",
                "Test5", "Contact6", "Test7", "Test Account",
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
                "Test5", "Contact6", "Test77", "Test Account",
                "AContact", "Test88",
                "Test99", "test@tes.t", "129456789", "+3751733000", "+3752933000");
        detailsPage.openDetails();
        detailsPage.validate(contact);
        detailsPage.clickEditDetailsButton()
                .clearData()
                .enterData(contact2)
                .clickSaveButton()
                .validate(contact2);
    }
}
