package com.udacity.course3.reviews;

import com.udacity.course3.reviews.model.Review;
import com.udacity.course3.reviews.repositories.ReviewRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataMongoTest
public class ReviewRepositoryTests {

    @Autowired
    ReviewRepository reviewRepository;

    @Test
    public void createReviewTest(){
        Review review = reviewRepository.save(new Review(1, "Gino Wine", "really great product", "Customer", "12/98/98", "1.0"));
        assertThat(review).hasFieldOrPropertyWithValue("productId", "1.0");
        assertThat(review).hasFieldOrPropertyWithValue("reviewerName", "Gino Wine");
    }

    public void findReviewsById(){
        Review review1 = reviewRepository.save(new Review(1, "Gino Wine", "really great product", "Customer", "12/98/98", "1.0"));
        Review review2 = reviewRepository.save(new Review(2, "Brown", "really bad product", "Mr.", "15/98/98", "2.0"));


    }
}
