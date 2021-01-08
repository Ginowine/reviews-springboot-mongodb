package com.udacity.course3.reviews.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.List;

@Document(collection = "products")
public class Product {
    @Id
    private String productId;

    private String productName;

    private double productAmt;

    private List<Review> reviews;

    public Product(String id, String productName, double productAmt){
        this.productId = id;
        this.productName = productName;
        this.productAmt = productAmt;
    }

    public Product(String id, String productName, double productAmount, List<Review> reviews) {
        this.productId = id;
        this.productName = productName;
        this.productAmt = productAmount;
        this.reviews = reviews;
    }

    public Product() {

    }

    @Override
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "";

        try {
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            jsonString = mapper.writeValueAsString(this);
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }

        return jsonString;


//        final StringBuffer sb = new StringBuffer("Product{");
//        sb.append(", productId=").append(productId);
//        sb.append(", productName=").append(productName);
//        sb.append(", productAmt=").append(productAmt);
//        sb.append(", reviews=").append(reviews);
//        sb.append('}');
//
//        return sb.toString();
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> review) {
        this.reviews = review;
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
