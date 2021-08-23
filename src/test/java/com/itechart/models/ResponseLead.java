package com.itechart.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseLead {
    String Status;
    String Salutation;
    String FirstName;
    String LastName;
    String Title;
    String Email;
    String Phone;
    String MobilePhone;
    String Rating;
    String Website;
    String Company;
    String Industry;
    String NumberOfEmployees;
    String LeadSource;
    String street;
    String city;
    String country;
    String Name;
}
