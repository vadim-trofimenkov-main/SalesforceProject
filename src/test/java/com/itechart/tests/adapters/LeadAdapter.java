package com.itechart.tests.adapters;

import com.itechart.models.Lead;
import com.itechart.models.ResponseStatus;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class LeadAdapter extends BaseAdapter {

    public ResponseStatus create(Lead lead) {
        String response = post(API_BASE_URL + "/lead",
                jsonReader.toJson(lead), 201);
        return jsonReader.fromJson(response, ResponseStatus.class);
    }

    @Step("Get Lead")
    public Lead getLead(String leadId) {
        log.info("Getting Lead by Id: {}", leadId);
        String response = get(API_BASE_URL + "/lead/" + leadId, 200);
        return jsonReader.fromJson(response, Lead.class);
    }
}
