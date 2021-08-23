package com.itechart.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseContact {
    String Salutation;
    String FirstName;
    String LastName;
    String AccountId;
    String ReportsToId;
    String Title;
    String Department;
    String Email;
    String Fax;
    String Phone;
    String MobilePhone;
    String Name;
}
