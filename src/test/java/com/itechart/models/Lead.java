package com.itechart.models;

import lombok.Data;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Data
public class Lead {
    final String leadStatus;
    final String salutation;
    final String firstName;
    final String middleName;
    final String lastName;
    final String suffix;
    final String title;
    final String email;
    final String phone;
    final String mobile;
    final String rating;
    final String website;
    final String company;
    final String industry;
    final String noOfEmployees;
    final String leadSource;
    final String street;
    final String city;
    final String zipOrPostalCode;
    final String stateOrProvince;
    final String country;
    String name;
    String address;

    public String getName() {
        log.warn("Compiling Lead Name");
        return getSalutation() + " " + getFirstName() + " " + getMiddleName() + " " + getLastName();
    }

    public String getAddress() {
        log.warn("Compiling Lead Address");
        return getStreet() + "\n" + getCity() + ", " + getStateOrProvince() + " " + getZipOrPostalCode() + "\n" + getCountry();
    }
}
