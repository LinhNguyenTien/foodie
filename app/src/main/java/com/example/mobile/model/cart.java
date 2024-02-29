package com.example.mobile.model;

public class cart {
    private String cartID;
    private String phoneNumber;

    public cart() {
    }

    public cart(String cartID, String phoneNumber) {
        this.cartID = cartID;
        this.phoneNumber = phoneNumber;
    }

    public String getCartID() {
        return cartID;
    }

    public void setCartID(String cartID) {
        this.cartID = cartID;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
