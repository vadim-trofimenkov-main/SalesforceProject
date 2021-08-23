package com.itechart.models;

import lombok.Data;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Data
public class Lead {
    final String Status;
    final String Salutation;
    final String FirstName;
    final String LastName;
    final String Title;
    final String Email;
    final String Phone;
    final String MobilePhone;
    final String Rating;
    final String Website;
    final String Company;
    final String Industry;
    final String NumberOfEmployees;
    final String LeadSource;
    final String street;
    final String city;
    final String country;
    String Name;
    String Address;

    public String getName() {
        Name = getSalutation() + " " + getFirstName() + " " + getLastName();
        log.warn("Compiling Lead Name: {}", Name);
        return Name;
    }

    public String getAddress() {
        Address = getStreet() + "\n" + getCity() + ", " + "\n" + getCountry();
        log.warn("Compiling Lead Address: {}", Address);
        return Address;
    }
}
