package com.example.mobile.model;

public class review {

    private String reviewID;
    private String productID;
    private String phoneNumber;
    private int numOfStar;
    private String content;
    private String dateReview;

    public review() {
    }

    public review(String reviewID, String productID, String phoneNumber, int numOfStar, String content, String dateReview) {
        this.reviewID = reviewID;
        this.productID = productID;
        this.phoneNumber = phoneNumber;
        this.numOfStar = numOfStar;
        this.content = content;
        this.dateReview = dateReview;
    }

    public String getReviewID() {
        return reviewID;
    }

    public void setReviewID(String reviewID) {
        this.reviewID = reviewID;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getNumOfStar() {
        return numOfStar;
    }

    public void setNumOfStar(int numOfStar) {
        this.numOfStar = numOfStar;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDateReview() {
        return dateReview;
    }

    public void setDateReview(String dateReview) {
        this.dateReview = dateReview;
    }
}
