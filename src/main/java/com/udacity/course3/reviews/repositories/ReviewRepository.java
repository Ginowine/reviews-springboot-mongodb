package com.udacity.course3.reviews.repositories;

import com.udacity.course3.reviews.model.Review;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ReviewRepository extends MongoRepository<Review, String> {

    @Override
    Optional<Review> findById(String s);
}
