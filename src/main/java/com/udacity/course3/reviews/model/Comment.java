package com.udacity.course3.reviews.model;

import javax.persistence.Id;

public class Comment {

    @Id
    private String id;
    private String test;
    private String createdTime;

    public Comment(String id, String test, String createdTime) {
        this.id = id;
        this.test = test;
        this.createdTime = createdTime;
    }

    public Comment() {
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Review{");
        sb.append("id=").append(id);
        sb.append(", test=").append(test);
        sb.append(", createdTime=").append(createdTime);
        sb.append('}');

        return sb.toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
