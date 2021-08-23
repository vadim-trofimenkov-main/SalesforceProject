package com.itechart.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseAccount {
    String Id;
    String Name;
    int statusCode;
    String ParentId;
    String Type;
    String Website;
    String Industry;
    String Phone;
    String Description;
    String NumberOfEmployees;
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
    String OwnerId;
}
