package models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Account {

    String accountName;
    String type;
    String website;
    String phone;
    String description;
    String employees;
    String parentAccount;
    String industry;
    String parentAccountField;
    String billingStreet;
    String billingCity;
    String billingPostalCode;
    String billingState;
    String billingCountry;
    String shippingStreet;
    String shippingCity;
    String shippingState;
    String shippingPostalCode;
    String shippingCountry;
}
