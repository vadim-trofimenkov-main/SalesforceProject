package com.itechart.tests.api;

import com.itechart.models.Contact;
import com.itechart.models.ResponseStatus;
import com.itechart.tests.BaseTest;
import com.itechart.tests.adapters.ContactAdapter;
import com.itechart.tests.configurations.Retry;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateGetContact extends BaseTest {

    @Test(retryAnalyzer = Retry.class, description = "Create Contact")
    public void createContactTest() {
        Contact contact = new Contact("Mr.", "Contact", "TestApi",
                "0015g00000P50EYAAZ", "0035g00000CqrWIAAZ", "Test8",
                "test@tes.t", "testDep", "12945678", "+3751730000", "+3752930000");
        ResponseStatus actual = new ContactAdapter().create(contact);
        Assert.assertTrue(actual.isSuccess(), "Response is not correct");
    }

    @Test(retryAnalyzer = Retry.class, description = "Get Contact")
    public void getContactTest() {
        Contact actual = new ContactAdapter().getContact("0035g00000CqrWIAAZ");
        Assert.assertEquals(actual.getName(), "Prof. Alex Svitkin", "Response is not correct");
    }
}
