package com.itechart.tests.adapters;

import com.itechart.models.Contact;
import com.itechart.models.ResponseContact;
import com.itechart.models.ResponseStatus;

public class ContactAdapter extends BaseAdapter {

    public ResponseStatus create(Contact contact) {
        String response = post("https://ap5.salesforce.com/services/data/v42.0/sobjects/contact",
                jsonReader.toJson(contact), 201);
        return jsonReader.fromJson(response, ResponseStatus.class);
    }

    public ResponseContact getContact(String contactId) {
        String response = get("https://ap5.salesforce.com/services/data/v42.0/sobjects/contact/" + contactId, 200);
        return jsonReader.fromJson(response, ResponseContact.class);
    }
}
