package com.example.mobile.model;

public class item {
    private String id;
    private String quantity;
    private String price;
    private product product;
    private discount discount;

    public item() {
    }

    public item(String id, String quantity, String price, com.example.mobile.model.product product, com.example.mobile.model.discount discount) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.product = product;
        this.discount = discount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public com.example.mobile.model.product getProduct() {
        return product;
    }

    public void setProduct(com.example.mobile.model.product product) {
        this.product = product;
    }

    public com.example.mobile.model.discount getDiscount() {
        return discount;
    }

    public void setDiscount(com.example.mobile.model.discount discount) {
        this.discount = discount;
    }
}
