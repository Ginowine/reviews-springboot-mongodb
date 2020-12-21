package com.udacity.course3.reviews.repositories;

import com.udacity.course3.reviews.model.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentRepository extends MongoRepository<Comment, String>{

    String findReviewById(String id);

}
