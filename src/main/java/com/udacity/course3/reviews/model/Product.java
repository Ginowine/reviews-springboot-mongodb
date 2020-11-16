package com.udacity.course3.reviews.model;

import org.bson.types.ObjectId;

import java.util.List;

public class Product {

    private ObjectId id;
    private Double productId;
    private String productName;
    private double productAmt;
    private List<Review> reviews;

    public Product(){

    }
    public Product(Double productId, String productName, double productAmt){
        this.productId = productId;
        this.productName = productName;
        this.productAmt = productAmt;
    }

    public Product(Double productId, String productName, double productAmount, List<Review> reviews) {
        this.productId = productId;
        this.productName = productName;
        this.productAmt = productAmount;
        this.reviews = reviews;
    }

    @Override
    public String toString() {
        //return String.format("Product[id=%s, productName='%s', productAmt='%s']", id, productName, productAmt);

        final StringBuffer sb = new StringBuffer("Product{");
        sb.append("id=").append(id);
        sb.append(", productId=").append(productId);
        sb.append(", productName=").append(productName);
        sb.append(", productAmt=").append(productAmt);
        sb.append(", reviews=").append(reviews);
        sb.append('}');

        return sb.toString();
    }

    public Double getProductId() {
        return productId;
    }

    public void setProductId(Double productId) {
        this.productId = productId;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
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
