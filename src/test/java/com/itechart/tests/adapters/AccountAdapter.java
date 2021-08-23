package com.itechart.tests.adapters;

import com.itechart.models.Account;
import com.itechart.models.ResponseAccount;
import com.itechart.models.ResponseStatus;

public class AccountAdapter extends BaseAdapter {

    public ResponseStatus create(Account account) {
        String response = post("https://ap5.salesforce.com/services/data/v42.0/sobjects/account",
                jsonReader.toJson(account), 201);
        return jsonReader.fromJson(response, ResponseStatus.class);
    }

    public ResponseAccount getAccount(String accountId) {
        String response = get("https://ap5.salesforce.com/services/data/v42.0/sobjects/account/" + accountId, 200);
        return jsonReader.fromJson(response, ResponseAccount.class);
    }
}
