package com.itechart.tests;

import com.itechart.pages.contact.ContactDetailsPage;
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

        ContactDetailsPage detailsPage =
                homePage
                        .openContactListViewPage()
                        .clickNewButton()
                        .enterData(contact)
                        .clickSaveButton();
        Assert.assertTrue(detailsPage.isPageOpened(), "Title is not correct");
        detailsPage
                .openDetails()
                .validate("Mr. Test4 Test5 Contact6 Test7", "Test Account",
                        "Test4 Test5 Contact6 Test7", "Test8", "Test9", "test@tes.t", "12945678",
                        "+3751730000", "+3752930000");
    }
}
