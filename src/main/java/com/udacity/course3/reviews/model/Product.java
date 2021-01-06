package com.udacity.course3.reviews.model;

public class Product {

    private String productId;
    private String productName;
    private double productAmt;
    private Review reviews;

    public Product(){

    }
    public Product(String productId, String productName, double productAmt){
        this.productId = productId;
        this.productName = productName;
        this.productAmt = productAmt;
    }

    public Product(String productId, String productName, double productAmount, Review reviews) {
        this.productId = productId;
        this.productName = productName;
        this.productAmt = productAmount;
        this.reviews = reviews;
    }

    @Override
    public String toString() {
        //return String.format("Product[id=%s, productName='%s', productAmt='%s']", id, productName, productAmt);

        final StringBuffer sb = new StringBuffer("Product{");
        sb.append(", productId=").append(productId);
        sb.append(", productName=").append(productName);
        sb.append(", productAmt=").append(productAmt);
        sb.append(", reviews=").append(reviews);
        sb.append('}');

        return sb.toString();
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Review getReviews() {
        return reviews;
    }

    public void setReviews(Review reviews) {
        this.reviews = reviews;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductAmt() {
        return productAmt;
    }

    public void setProductAmt(double productAmt) {
        this.productAmt = productAmt;
    }
}
