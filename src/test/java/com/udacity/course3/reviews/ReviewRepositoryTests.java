package com.udacity.course3.reviews;

import com.udacity.course3.reviews.model.Review;
import com.udacity.course3.reviews.repositories.ReviewRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataMongoTest
public class ReviewRepositoryTests {

    @Autowired
    ReviewRepository reviewRepository;

    @Test
    public void createReviewTest(){
        Review review = reviewRepository.save(new Review("1", "Gino Wine", "really great product", "Customer", "12/98/98", "1.0"));
        assertThat(review).hasFieldOrPropertyWithValue("productId", "1.0");
        assertThat(review).hasFieldOrPropertyWithValue("reviewerName", "Gino Wine");
    }

    @Test
    public void findReviewsById(){
        Review review1 = reviewRepository.save(new Review("1", "Gino Wine", "really great product", "Customer", "12/98/98", "1.0"));
        Review review2 = reviewRepository.save(new Review("2", "Brown", "really bad product", "Mr.", "15/98/98", "2.0"));

        Review review = reviewRepository.findById(review2.getId()).get();
        assertThat(review).isEqualTo(review2);
        assertThat(review.getId()).isNotNull();
        assertThat(review.getId()).contains("2");
    }

    @Test
    public void findReviewByProductId(){
        Review review1 = reviewRepository.save(new Review("1", "Gino Wine", "really great product", "Customer", "12/98/98", "1.0"));
        Review review2 = reviewRepository.save(new Review("2", "Brown", "really bad product", "Mr.", "15/98/98", "2.0"));
        Review review3 = reviewRepository.save(new Review("3", "Eghosa", "great product", "Mr", "15/98/98", "1.0"));
        Review review4 = reviewRepository.save(new Review("4", "Eseosa", " product", "Mr.", "15/98/98", "1.0"));

        List<Review> review = reviewRepository.findReviewsByProductId(review1.getProductId());
        assertThat(review.size()).isNotNull();
        assertThat(review.get(1).getId()).isNotNull();
        assertThat(review.get(1).getId()).contains("1");
    }
}
