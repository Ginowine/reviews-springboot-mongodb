package com.udacity.course3.reviews.model;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Document(collection = "comments")
public class Comment {

    @Id
    private Long id;
    private String test;
    private String createdTime;
    private String reviewId;

    @ManyToOne
    private Review review;

    public Comment(Long id, String test, String createdTime, String reviewId, Review review) {
        this.id = id;
        this.test = test;
        this.createdTime = createdTime;
        this.reviewId = reviewId;
        this.review = review;
    }

    public Comment() {
    }

    @Override
    public String toString() {
        //return String.format("Comment[id=%s, test='%s', createdTime='%s', revieweId='%s']", id, test, createdTime, reviewId);
        final StringBuffer sb = new StringBuffer("Review{");
        sb.append("id=").append(id);
        sb.append(", test=").append(test);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", reviewerId=").append(reviewId);
        sb.append('}');

        return sb.toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getReviewId() {
        return reviewId;
    }

    public void setReviewId(String reviewId) {
        this.reviewId = reviewId;
    }
}
