package com.udacity.course3.reviews.controller;

import com.udacity.course3.reviews.exception.ReviewNotFound;
import com.udacity.course3.reviews.model.Comment;
import com.udacity.course3.reviews.model.Review;
import com.udacity.course3.reviews.repositories.CommentRepository;
import com.udacity.course3.reviews.repositories.ReviewRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Spring REST controller for working with comment entity.
 */
@RestController
@RequestMapping("/comments")
public class CommentsController {
    // TODO: Wire needed JPA repositories here
    CommentRepository commentRepository;
    ReviewRepository reviewRepository;
    private Optional<Review> existingReviewId;

    /**
     * Creates a comment for a review.
     *
     * 1. Add argument for comment entity. Use {@link RequestBody} annotation.
     * 2. Check for existence of review.
     * 3. If review not found, return NOT_FOUND.
     * 4. If found, save comment.
     *
     * @param reviewId The id of the review.
     */
    @RequestMapping(value = "/reviews/{reviewId}", method = RequestMethod.POST)
    public Comment createCommentForReview(@RequestBody Comment comment, @PathVariable("reviewId") String reviewId) throws ReviewNotFound{
        existingReviewId = reviewRepository.findById(reviewId);

    //.findReviewById(reviewId.toString());
        if (!existingReviewId.isPresent()){
            throw new ReviewNotFound("ERROR: REVIEW_NOT_FOUND");
        }else {
            return commentRepository.save(comment);
        }
    }

    /**
     * List comments for a review.
     *
     * 2. Check for existence of review.
     * 3. If review not found, return NOT_FOUND.
     * 4. If found, return list of comments.
     *
     * @param reviewId The id of the review.
     */
    @RequestMapping(value = "/reviews/{reviewId}", method = RequestMethod.GET)
    public List<Comment> listCommentsForReview(@PathVariable("reviewId") String reviewId) throws ReviewNotFound{
        existingReviewId = reviewRepository.findById(reviewId);
        if (!existingReviewId.isPresent()){
            throw new ReviewNotFound("ERROR: NOT_FOUND");
        }else {
            return commentRepository.findCommentsByReviewId(reviewId);
        }
    }
}