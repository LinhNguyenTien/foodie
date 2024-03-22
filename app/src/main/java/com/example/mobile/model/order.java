package com.example.mobile.model;

public class order {
    private String orderdate;

    public order() {
    }

    public order(String orderdate) {
        this.orderdate = orderdate;
    }

    public String getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(String orderdate) {
        this.orderdate = orderdate;
    }
}