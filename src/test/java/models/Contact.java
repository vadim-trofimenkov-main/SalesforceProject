package models;

import lombok.Data;

@Data
public class Contact {
    final String salutation;
    final String firstName;
    final String middleName;
    final String lastName;
    final String suffix;
    final String accountName;
    final String reportsTo;
    final String title;
    final String department;
    final String email;
    final String fax;
    final String phone;
    final String mobile;
    String name;

    public String getName() {
        return getSalutation() +" "+ getFirstName() +" "+ getMiddleName() +" "+ getLastName() +" "+ getSuffix();
    }
}
