package models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Contact {

    String salutation;
    String firstName;
    String middleName;
    String lastName;
    String suffix;
    String accountName;
    String reportsTo;
    String title;
    String department;
    String email;
    String fax;
    String phone;
    String mobile;
}
