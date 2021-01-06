package com.udacity.course3.reviews.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty
    private String productId;
    private String productName;
    private double productAmt;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "review_id", referencedColumnName = "id")
    private Review review;

    public Product(){

    }
    public Product(String productId, String productName, double productAmt){
        this.productId = productId;
        this.productName = productName;
        this.productAmt = productAmt;
    }

    public Product(String productId, String productName, double productAmount, Review review) {
        this.productId = productId;
        this.productName = productName;
        this.productAmt = productAmount;
        this.review = review;
    }

    @Override
    public String toString() {
        //return String.format("Product[id=%s, productName='%s', productAmt='%s']", id, productName, productAmt);

        final StringBuffer sb = new StringBuffer("Product{");
        sb.append(", productId=").append(productId);
        sb.append(", productName=").append(productName);
        sb.append(", productAmt=").append(productAmt);
        sb.append(", reviews=").append(review);
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
        return review;
    }

    public void setReviews(Review review) {
        this.review = review;
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
