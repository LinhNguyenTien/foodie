package com.example.mobile.model;

import java.io.Serializable;

public class customer implements Serializable {
    private String phone;
    private String accStatusID;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    public customer() {    }

    public customer(String phone, String accStatusID, String password, String firstName, String lastName, String email) {
        this.phone = phone;
        this.accStatusID = accStatusID;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    @Override
    public String toString() {
        return "customer{" +
                "phone='" + phone + '\'' +
                ", accStatusID='" + accStatusID + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
