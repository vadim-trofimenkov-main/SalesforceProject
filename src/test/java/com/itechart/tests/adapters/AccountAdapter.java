package com.itechart.tests.adapters;

import com.itechart.models.Account;
import com.itechart.models.ResponseStatus;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class AccountAdapter extends BaseAdapter {

    @Step("Create Account")
    public ResponseStatus create(Account account) {
        log.info("Creating Account: {}", account);
        String response = post(API_BASE_URL + "/account",
                jsonReader.toJson(account), 201);
        return jsonReader.fromJson(response, ResponseStatus.class);
    }

    @Step("Get Account")
    public Account getAccount(String accountId) {
        log.info("Getting Account by Id: {}", accountId);
        String response = get(API_BASE_URL + "/account/" + accountId, 200);
        return jsonReader.fromJson(response, Account.class);
    }
}