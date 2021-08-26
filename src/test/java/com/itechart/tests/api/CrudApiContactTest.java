package com.itechart.tests.api;

import com.itechart.models.Contact;
import com.itechart.models.ResponseStatus;
import com.itechart.tests.configurations.Retry;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CrudApiContactTest extends BaseApiTest {

    @Test(retryAnalyzer = Retry.class, description = "Create Contact")
    public void createGetUpdateDeleteContact() {
        Contact contact = new Contact("Mr.", "Contact", "TestApi",
                "0015g00000P50EYAAZ", "0035g00000CqrWIAAZ", "Test8",
                "test@tes.t", "testDep", "12945678", "+3751730000", "+3752930000");
        ResponseStatus response = contactAdapter.create(contact);
        Assert.assertTrue(response.isSuccess(), "Response is not correct");
        contact = contactAdapter.get(response.getId());
        Assert.assertEquals(contact.getName(), "Mr. Contact TestApi", "Response is not correct");
        Contact updatedContact = new Contact("Mr.", "Contact", "TestApi Updated",
                "0015g00000P50EYAAZ", "0035g00000CqrWIAAZ", "Test8",
                "test@tes.t", "testDep", "12945678", "+3751730000", "+3752930000");
        contactAdapter.update(updatedContact, response.getId());
        contact = contactAdapter.get(response.getId());
        Assert.assertEquals(contact.getName(), "Mr. Contact TestApi Updated", "Update request is not correct");
        contactAdapter.delete(response.getId());
    }
}
