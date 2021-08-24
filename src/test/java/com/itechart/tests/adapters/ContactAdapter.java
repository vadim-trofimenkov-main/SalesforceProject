package com.itechart.tests.adapters;

import com.itechart.models.Contact;
import com.itechart.models.ResponseStatus;

public class ContactAdapter extends BaseAdapter {

    public ResponseStatus create(Contact contact) {
        String response = post(API_BASE_URL + "/contact",
                jsonReader.toJson(contact), 201);
        return jsonReader.fromJson(response, ResponseStatus.class);
    }

    public Contact getContact(String contactId) {
        String response = get(API_BASE_URL + "/contact/" + contactId, 200);
        return jsonReader.fromJson(response, Contact.class);
    }
}
