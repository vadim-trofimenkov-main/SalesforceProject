package com.itechart.tests.adapters;

import com.itechart.models.Account;
import com.itechart.models.ResponseStatus;

public class AccountAdapter extends BaseAdapter {

    public ResponseStatus create(Account account) {
        String response = post(API_BASE_URL + "/account",
                jsonReader.toJson(account), 201);
        return jsonReader.fromJson(response, ResponseStatus.class);
    }

    public Account getAccount(String accountId) {
        String response = get(API_BASE_URL + "/account/" + accountId, 200);
        return jsonReader.fromJson(response, Account.class);
    }
}
