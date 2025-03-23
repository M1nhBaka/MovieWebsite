package com.example.movieweb.Controller;

import com.example.movieweb.DTO.Request.ReviewRequest;
import com.example.movieweb.DTO.ReviewDTO;
import com.example.movieweb.Service.ReviewService;
import jakarta.validation.Valid;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class ReviewController {

    @Autowired
    private ReviewService reviewService;
    @GetMapping("/api/movies/{movieId}/reviews")
    public ResponseEntity<Page<ReviewDTO>> getMovieReviews(
            @PathVariable Long movieId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(reviewService.getMovieReviews(movieId, page, size));
    }

    @PostMapping("/api/movies/{movieId}/reviews")
    public ResponseEntity<ReviewDTO> addReview(
            @PathVariable Long movieId,
            @Valid @RequestBody ReviewRequest reviewRequest) throws BadRequestException {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(reviewService.addReview(movieId, reviewRequest));
    }

    @PutMapping("/api/reviews/{reviewId}")
    public ResponseEntity<ReviewDTO> updateReview(
            @PathVariable Long reviewId,
            @Valid @RequestBody ReviewRequest reviewRequest) {
        return ResponseEntity.ok(reviewService.updateReview(reviewId, reviewRequest));
    }

    @DeleteMapping("/api/reviews/{reviewId}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long reviewId) {
        reviewService.deleteReview(reviewId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/api/users/me/reviews")
    public ResponseEntity<Page<ReviewDTO>> getCurrentUserReviews(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(reviewService.getCurrentUserReviews(page, size));
    }
}
