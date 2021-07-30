package com.itechart.tests.contact;

import com.itechart.pages.contact.ContactDetailsPage;
import com.itechart.pages.contact.ContactListViewPage;
import com.itechart.pages.contact.ContactModalPage;
import com.itechart.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateNewContactTest extends BaseTest {

    @Test
    public void testCreateNewContact(){
        homePage.goToPage("https://itechart4.lightning.force.com/lightning/o/Contact/list?filterName=Recent");
        ContactListViewPage contactListViewPage = new ContactListViewPage(driver).clickNewButton();
        ContactModalPage contactModalPage = new ContactModalPage(driver).fillContactDetails("Test", "Test2", "Contact", "Test3", "Test4",
                "Test5", "tes@te.st", "1234567", "+3751710000", "+3752910000");
        contactModalPage.clickSaveButton();
        ContactDetailsPage contactDetailsPage = new ContactDetailsPage(driver);
        Assert.assertEquals(contactDetailsPage.getTitle(),"Contact", "Title is not correct");
    }
}
