package com.itechart.tests.api;

import com.itechart.models.Contact;
import com.itechart.models.ResponseStatus;
import com.itechart.tests.BaseTest;
import com.itechart.tests.adapters.ContactAdapter;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateGetContact extends BaseTest {
    @Test
    public void createContactTest() {
        Contact contact = new Contact("Mr.", "Test", "Contact4",
                "0015g00000OYSDhAAP", "0035g00000CqoGjAAJ", "Test8",
                "test@tes.t", "testDep", "12945678", "+3751730000", "+3752930000");
        ResponseStatus actual = new ContactAdapter().create(contact);
        Assert.assertTrue(actual.isSuccess(), "Response is not correct");
    }

    @Test
    public void getContactTest() {
        Contact actual = new ContactAdapter().getContact("0035g00000CqoGjAAJ");
        Assert.assertEquals(actual.getName(), "Mr. Test Contact Updated", "Response is not correct");
    }
}
