package com.itechart.tests.adapters;

import com.itechart.models.Contact;
import com.itechart.models.ResponseStatus;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ContactAdapter extends BaseAdapter {

    public ResponseStatus create(Contact contact) {
        String response = post(API_BASE_URL + "/contact",
                jsonReader.toJson(contact), 201);
        return jsonReader.fromJson(response, ResponseStatus.class);
    }

    @Step("Get Contact")
    public Contact getContact(String contactId) {
        log.info("Getting Contact by Id: {}", contactId);
        String response = get(API_BASE_URL + "/contact/" + contactId, 200);
        return jsonReader.fromJson(response, Contact.class);
    }
}
