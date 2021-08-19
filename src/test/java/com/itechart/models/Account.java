package com.itechart.models;

import lombok.Data;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Data
public class Account {
    final String accountName;
    final String parentAccount;
    final String type;
    final String website;
    final String industry;
    final String phone;
    final String description;
    final String employees;
    final String billingStreet;
    final String billingCity;
    final String billingPostalCode;
    final String billingState;
    final String billingCountry;
    final String shippingStreet;
    final String shippingCity;
    final String shippingState;
    final String shippingPostalCode;
    final String shippingCountry;
    String billingAddress;
    String shippingAddress;
    final String accountOwner;

    public String getAccountName() {
        return accountName;
    }

    public String getBillingAddress() {
        billingAddress = getBillingStreet() + "\n" + getBillingCity() + ", " + getBillingState() + " " +
                getBillingPostalCode() + "\n" + getBillingCountry();
        log.warn("Compiling Account Billing Address: {}", billingAddress);
        return billingAddress;
    }

    public String getShippingAddress() {
        shippingAddress = getShippingStreet() + "\n" + getShippingCity() + ", " + getShippingState() + " " +
                getShippingPostalCode() + "\n" + getShippingCountry();
        log.warn("Compiling Account Shipping Address: {}", shippingAddress);
        return shippingAddress;
    }
}
