package com.udacity.course3.reviews.model;

import java.util.List;

public class Review {
    private String id;
    private String reviewerName;
    private String reviewerDescription;
    private String reviewerTitle;
    private String createdDate;
    private String productId;
    private List<Comment> comments;

    public Review(String id, String reviewerName, String reviewerDescription, String reviewerTitle, String date, String productId) {
        this.id = id;
        this.reviewerName = reviewerName;
        this.reviewerDescription = reviewerDescription;
        this.reviewerTitle = reviewerTitle;
        this.createdDate = date;
        this.productId = productId;
    }

    public Review(){

    }

    @Override
    public String toString() {
        //return String.format("Review[id=%s, reviewerName='%s', reviewerDescription='%s', reviewerTitle='%s', createdDate='%s', productId='%s']", id, reviewerName, reviewerDescription, reviewerTitle, createdDate, productId);
        final StringBuffer sb = new StringBuffer("Review{");
        sb.append("id=").append(id);
        sb.append(", reviewerName=").append(reviewerName);
        sb.append(", reviewerDescription=").append(reviewerDescription);
        sb.append(", reviewerTitle=").append(reviewerTitle);
        sb.append(", createdDate=").append(createdDate);
        sb.append(", productId=").append(productId);
        sb.append(", comments").append(comments);
        sb.append('}');

        return sb.toString();
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReviewerName() {
        return reviewerName;
    }

    public void setReviewerName(String reviewerName) {
        this.reviewerName = reviewerName;
    }

    public String getReviewerDescription() {
        return reviewerDescription;
    }

    public void setReviewerDescription(String reviewerDescription) {
        this.reviewerDescription = reviewerDescription;
    }

    public String getReviewerTitle() {
        return reviewerTitle;
    }

    public void setReviewerTitle(String reviewerTitle) {
        this.reviewerTitle = reviewerTitle;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}
