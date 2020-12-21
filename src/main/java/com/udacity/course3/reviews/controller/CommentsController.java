package com.udacity.course3.reviews.controller;

import com.udacity.course3.reviews.exception.ReviewNotFound;
import com.udacity.course3.reviews.model.Comment;
import com.udacity.course3.reviews.repositories.CommentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;

import java.util.List;

/**
 * Spring REST controller for working with comment entity.
 */
@RestController
@RequestMapping("/comments")
public class CommentsController {
    // TODO: Wire needed JPA repositories here
    CommentRepository commentRepository;
    private String existingReview;

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
    public Comment createCommentForReview(@RequestBody Comment comment, @PathVariable("reviewId") Integer reviewId) throws ReviewNotFound{
        existingReview = commentRepository.findReviewById(reviewId.toString());
        if (existingReview == null){
            throw new ReviewNotFound("ERROR: REVIEW_NOT_FOUND");
        }

        return commentRepository.save(comment);
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
    public List<?> listCommentsForReview(@PathVariable("reviewId") Integer reviewId) {
        throw new HttpServerErrorException(HttpStatus.NOT_IMPLEMENTED);
    }
}