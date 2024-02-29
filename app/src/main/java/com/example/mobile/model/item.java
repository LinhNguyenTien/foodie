package com.example.mobile.model;

public class item {
    private String cartID;
    private String productID;
    private String orderID;
    private String discountID;
    private String quantity;
    private String price;
    private String id;

    public item() {
    }

    public item(String cartID, String productID, String orderID, String discountID, String quantity, String price, String id) {
        this.cartID = cartID;
        this.productID = productID;
        this.orderID = orderID;
        this.discountID = discountID;
        this.quantity = quantity;
        this.price = price;
        this.id = id;
    }

    public String getCartID() {
        return cartID;
    }

    public void setCartID(String cartID) {
        this.cartID = cartID;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getDiscountID() {
        return discountID;
    }

    public void setDiscountID(String discountID) {
        this.discountID = discountID;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
