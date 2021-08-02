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
        ContactModalPage contactModalPage = new ContactModalPage(driver).fillContactDetails("Mr." ,"Test2",
                "Test3", "Contact2", "Test4", "Test New Account","Test5",
                "Test6", "tes@tes.t", "1294567", "+3751720000", "+3752920000");
        contactModalPage.clickSaveButton();
        ContactDetailsPage contactDetailsPage = new ContactDetailsPage(driver);
        Assert.assertEquals(contactDetailsPage.getTitle(),"Contact", "Title is not correct");
    }
}
