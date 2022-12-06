package com.example.geektrust.model;

import com.example.geektrust.constants.Constants;
import com.example.geektrust.exception.InvalidInputException;



public class Employee {

    private final String name;
    private final String emailAddress;


    public Employee(String emailAddress) throws InvalidInputException {
        if (Constants.VALID_EMAIL_ADDRESS_REGEX.matcher(emailAddress).matches()) {
            this.emailAddress = emailAddress;
            this.name = this.emailAddress.substring(0, this.emailAddress.indexOf('@'));
        } else {
            throw new InvalidInputException("INPUT_DATA_ERROR");
        }
    }

    public String getName() {
        return name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

}
