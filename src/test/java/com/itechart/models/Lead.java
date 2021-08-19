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
        name = getSalutation() + " " + getFirstName() + " " + getMiddleName() + " " + getLastName();
        log.warn("Compiling Lead Name: {}", name);
        return name;
    }

    public String getAddress() {
        address = getStreet() + "\n" + getCity() + ", " + getStateOrProvince() + " " + getZipOrPostalCode() + "\n" + getCountry();
        log.warn("Compiling Lead Address: {}", address);
        return address;
    }
}
