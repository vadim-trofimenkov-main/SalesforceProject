package com.itechart.models;

import lombok.Data;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Data
public class Account {
    final String Name;
    final String ParentId;
    final String Type;
    final String Website;
    final String Industry;
    final String Phone;
    final String Description;
    final String NumberOfEmployees;
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
    String BillingAddress;
    String ShippingAddress;
    String OwnerId;

    public String getName() {
        return Name;
    }

    public String getBillingAddress() {
        BillingAddress = getBillingStreet() + "\n" + getBillingCity() + ", " + getBillingState() + " " +
                getBillingPostalCode() + "\n" + getBillingCountry();
        log.warn("Compiling Account Billing Address: {}", BillingAddress);
        return BillingAddress;
    }

    public String getShippingAddress() {
        ShippingAddress = getShippingStreet() + "\n" + getShippingCity() + ", " + getShippingState() + " " +
                getShippingPostalCode() + "\n" + getShippingCountry();
        log.warn("Compiling Account Shipping Address: {}", ShippingAddress);
        return ShippingAddress;
    }
}
