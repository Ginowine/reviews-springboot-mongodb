package com.udacity.course3.reviews.controller;

import com.udacity.course3.reviews.exception.ProductNotFound;
import com.udacity.course3.reviews.model.Product;
import com.udacity.course3.reviews.model.Review;
import com.udacity.course3.reviews.repositories.ProductRepository;
import com.udacity.course3.reviews.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Spring REST controller for working with review entity.
 */
@RestController
public class ReviewsController {

    // TODO: Wire JPA repositories here
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ReviewRepository reviewRepository;

    private Optional<Product> existingProduct;

    /**
     * Creates a review for a product.
     * <p>
     * 1. Add argument for review entity. Use {@link RequestBody} annotation.
     * 2. Check for existence of product.
     * 3. If product not found, return NOT_FOUND.
     * 4. If found, save review.
     *
     * @param productId The id of the product.
     * @return The created review or 404 if product id is not found.
     */
    @RequestMapping(value = "/reviews/products/{productId}", method = RequestMethod.POST)
    public Review createReviewForProduct(@RequestBody Review review, @PathVariable("productId") String productId) throws ProductNotFound {
        existingProduct = productRepository.findById(productId);
        if (!existingProduct.isPresent()){
            throw new ProductNotFound("ERROR: NOT_FOUND");
        }else {
            return reviewRepository.save(review);
        }
    }

    /**
     * Lists reviews by product.
     *
     * @param productId The id of the product.
     * @return The list of reviews.
     */
    @RequestMapping(value = "/reviews/products/{productId}", method = RequestMethod.GET)
    public List<Review> listReviewsForProduct(@PathVariable("productId") String productId) throws ProductNotFound{
        existingProduct = productRepository.findById(productId);
        if (!existingProduct.isPresent()){
            throw new ProductNotFound("ERROR: NOT_FOUND");
        }else {
            return reviewRepository.findReviewsByProductId(productId);
        }
    }
}