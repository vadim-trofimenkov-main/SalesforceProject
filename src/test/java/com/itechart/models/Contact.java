package com.itechart.models;

import lombok.Data;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Data
public class Contact {
    final String Salutation;
    final String FirstName;
    final String LastName;
    final String AccountId;
    final String ReportsToId;
    final String Title;
    final String Department;
    final String Email;
    final String Fax;
    final String Phone;
    final String MobilePhone;
    String Name;

    public String getName() {
        Name = getSalutation() + " " + getFirstName() + " " + getLastName() + " ";
        log.warn("Compiling Contact Name: {}", Name);
        return Name;
    }
}
