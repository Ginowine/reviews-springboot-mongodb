package com.udacity.course3.reviews.model;

import javax.persistence.Id;

public class Comment {

    @Id
    private Long id;
    private String test;
    private String createdTime;

    public Comment(Long id, String test, String createdTime) {
        this.id = id;
        this.test = test;
        this.createdTime = createdTime;
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
}
