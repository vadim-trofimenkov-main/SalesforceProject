package com.itechart.models;

import lombok.Data;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Data
public class Contact {
    final String salutation;
    final String firstName;
    final String middleName;
    final String lastName;
    final String suffix;
    final String accountName;
    final String reportsTo;
    final String title;
    final String department;
    final String email;
    final String fax;
    final String phone;
    final String mobile;
    String name;

    public String getName() {
        name = getSalutation() + " " + getFirstName() + " " + getMiddleName() + " " + getLastName() + " " + getSuffix();
        log.warn("Compiling Contact Name: {}", name);
        return name;
    }
}
