package com.itechart.tests;

import com.itechart.pages.contact.ContactDetailsPage;
import com.itechart.pages.contact.ContactListViewPage;
import com.itechart.pages.contact.ContactModalPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateNewContactTest extends BaseTest {

    @Test
    public void testCreateNewContact() {
        homePage.goToPage("https://itechart4.lightning.force.com/lightning/o/Contact/list?filterName=Recent");
        ContactListViewPage contactListViewPage = new ContactListViewPage(driver).clickNewButton();
        ContactModalPage contactModalPage = new ContactModalPage(driver).enterData("Mr.", "Test4",
                "Test5", "Contact6", "Test7", "Test Account",
                "Test4 Test5 Contact6 Test7", "Test8",
                "Test9", "test@tes.t", "12945678", "+3751730000", "+3752930000");
        contactModalPage.clickSaveButton();
        ContactDetailsPage contactDetailsPage = new ContactDetailsPage(driver);
        Assert.assertEquals(contactDetailsPage.getTitle(), "Contact", "Title is not correct");
        contactDetailsPage.openDetails();
        contactDetailsPage.validate("Mr. Test4 Test5 Contact6 Test7", "Test Account",
                "Test4 Test5 Contact6 Test7", "Test8", "Test9", "test@tes.t", "12945678",
                "+3751730000", "+3752930000");
    }
}
