package models;

import lombok.Data;

@Data
public class Account {
    final String accountName;
    final String type;
    final String website;
    final String phone;
    final String description;
    final String employees;
    final String parentAccount;
    final String industry;
    final String parentAccountField;
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
}
