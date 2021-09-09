package com.itechart.models.factory;

import com.itechart.models.Contact;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ContactFactory extends BaseFactory {
    public Contact createNewContact(boolean isUiTest) {
        if (isUiTest) {
            return new Contact("Mr.",
                    faker.name().firstName(),
                    faker.name().lastName(),
                    "Test Account",
                    "Test4 Test5 Contact6 Test7",
                    faker.gameOfThrones().character(),
                    faker.internet().emailAddress(),
                    faker.harryPotter().house(),
                    faker.number().digit(),
                    faker.phoneNumber().phoneNumber(),
                    faker.phoneNumber().phoneNumber());
        } else {
            return new Contact("Mr.",
                    faker.name().firstName(),
                    faker.name().lastName(),
                    "0015g00000QqXfzAAF",
                    "0035g00000CqtMeAAJ",
                    faker.gameOfThrones().character(),
                    faker.internet().emailAddress(),
                    faker.harryPotter().house(),
                    faker.number().digit(),
                    faker.phoneNumber().phoneNumber(),
                    faker.phoneNumber().phoneNumber());
        }
    }
}
