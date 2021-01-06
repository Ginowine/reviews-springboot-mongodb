package com.udacity.course3.reviews.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty
    @Column
    private String id;

    @Column
    private String reviewerName;
    @Column
    private String reviewerDescription;
    @Column
    private String reviewerTitle;
    @Column
    private String createdDate;

    @ManyToOne
    @JsonProperty
    private Product product;

    @ManyToMany
    @JsonProperty
    @Column
    private List<Comment> comments;

    public Review(String id, String reviewerName, String reviewerDescription, String reviewerTitle, String date, Product product, List<Comment> comments) {
        this.id = id;
        this.reviewerName = reviewerName;
        this.reviewerDescription = reviewerDescription;
        this.reviewerTitle = reviewerTitle;
        this.createdDate = date;
        this.product = product;
        this.comments = comments;
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
}
