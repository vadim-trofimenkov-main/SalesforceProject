package com.itechart.models.factory;

import com.itechart.models.Account;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class AccountFactory extends BaseFactory {
    public Account createNewAccount(boolean isUiTest) {
        if (isUiTest) {
            return new Account(
                    faker.name().name(),
                    "Test Account",
                    "Prospect",
                    faker.internet().url(),
                    "Apparel",
                    faker.phoneNumber().phoneNumber(),
                    faker.lorem().sentence(),
                    faker.number().digit(),
                    faker.address().streetAddress(),
                    faker.address().city(),
                    faker.address().zipCode(),
                    faker.address().state(),
                    faker.address().country(),
                    faker.address().streetAddress(),
                    faker.address().city(),
                    faker.address().zipCode(),
                    faker.address().state(),
                    faker.address().country(),
                    propertyReader.getPropertyValueByKey("user"));
        } else {
            return new Account(
                    faker.name().name(),
                    "0015g00000PrrCcAAJ",
                    "Prospect",
                    faker.internet().url(),
                    "Apparel",
                    faker.phoneNumber().phoneNumber(),
                    faker.lorem().sentence(),
                    faker.number().digit(),
                    faker.address().streetAddress(),
                    faker.address().city(),
                    faker.address().zipCode(),
                    faker.address().state(),
                    faker.address().country(),
                    faker.address().streetAddress(),
                    faker.address().city(),
                    faker.address().zipCode(),
                    faker.address().state(),
                    faker.address().country(),
                    "0055g00000CA2c5AAD");
        }
    }
}
