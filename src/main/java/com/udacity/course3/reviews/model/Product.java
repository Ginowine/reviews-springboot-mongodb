package com.udacity.course3.reviews.model;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Document(collection = "products")
public class Product {
    @Id
    private String productId;

    private String productName;

    private double productAmt;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> review;

    public Product(String productId, String productName, double productAmt){
        this.productId = productId;
        this.productName = productName;
        this.productAmt = productAmt;
    }

    public Product(String productId, String productName, double productAmount, List<Review> review) {
        this.productId = productId;
        this.productName = productName;
        this.productAmt = productAmount;
        this.review = review;
    }

    public Product() {

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

    public List<Review> getReviews() {
        return review;
    }

    public void setReviews(List<Review> review) {
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
