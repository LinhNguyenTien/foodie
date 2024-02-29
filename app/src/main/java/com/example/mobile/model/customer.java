package com.example.mobile.model;

import java.io.Serializable;

public class customer implements Serializable {
    private String phoneNumber;
    private String accStatusID;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    public customer() {    }

    public customer(String phoneNumber, String accStatusID, String password, String firstName, String lastName, String email) {
        this.phoneNumber = phoneNumber;
        this.accStatusID = accStatusID;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAccStatusID() {
        return accStatusID;
    }

    public void setAccStatusID(String accStatusID) {
        this.accStatusID = accStatusID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
