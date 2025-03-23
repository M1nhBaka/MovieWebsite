package com.example.movieweb.Service;

import com.example.movieweb.DTO.Request.ReviewRequest;
import com.example.movieweb.DTO.ReviewDTO;
import com.example.movieweb.Exception.ResourceNotFoundException;
import com.example.movieweb.Model.Movie;
import com.example.movieweb.Model.Review;
import com.example.movieweb.Model.User;
import com.example.movieweb.Repository.MovieRepository;
import com.example.movieweb.Repository.ReviewRepository;
import com.example.movieweb.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Transactional
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final MovieRepository movieRepository;
    private final ModelMapper modelMapper;

    public Page<ReviewDTO> getMovieReviews(Long movieId, int page, int size) {
        // Check if movie exists
        if (!movieRepository.existsById(movieId)) {
            throw new ResourceNotFoundException("Movie not found");
        }

        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());
        Page<Review> reviewPage = reviewRepository.findByMovieId(movieId, pageable);

        return reviewPage.map(review -> modelMapper.map(review, ReviewDTO.class));
    }

    public ReviewDTO addReview(Long movieId, ReviewRequest reviewRequest) throws BadRequestException {
        Long userId = SecurityUtils.getCurrentUserId();

        // Check if movie exists
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new ResourceNotFoundException("Movie not found"));

        // Check if user already reviewed this movie
        if (reviewRepository.existsByUserIdAndMovieId(userId, movieId)) {
            throw new BadRequestException("You have already reviewed this movie");
        }

        User user = userRepository.findById(Math.toIntExact(userId))
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        Review review = new Review();
        review.setMovie(movie);
        review.setUser(user);
        review.setRating(Float.valueOf(reviewRequest.getRating()));
        review.setCreatedAt(LocalDateTime.now());

        Review savedReview = reviewRepository.save(review);

        // Update movie average rating (optional)
        updateMovieAverageRating(movieId);

        return modelMapper.map(savedReview, ReviewDTO.class);
    }

    public ReviewDTO updateReview(Long reviewId, ReviewRequest reviewRequest) {
        Long userId = SecurityUtils.getCurrentUserId();

        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new ResourceNotFoundException("Review not found"));

        // Verify ownership
        if (!review.getUser().getId().equals(userId)) {
            throw new AccessDeniedException("You don't have permission to update this review");
        }

        // Update review data
        review.setRating(reviewRequest.getRating());
        review.setComment(reviewRequest.getComment());

        Review updatedReview = reviewRepository.save(review);

        // Update movie average rating (optional)
        updateMovieAverageRating(review.getMovie().getId());

        return modelMapper.map(updatedReview, ReviewDTO.class);
    }

    public void deleteReview(Long reviewId) {
        Long userId = SecurityUtils.getCurrentUserId();

        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new ResourceNotFoundException("Review not found"));

        // Verify ownership or admin role
        if (!review.getUser().getId().equals(userId) && !SecurityUtils.hasRole("ADMIN")) {
            throw new AccessDeniedException("You don't have permission to delete this review");
        }

        Long movieId = review.getMovie().getId();
        reviewRepository.delete(review);

        // Update movie average rating (optional)
        updateMovieAverageRating(movieId);
    }


    public Page<ReviewDTO> getCurrentUserReviews(int page, int size) {
        Long userId = SecurityUtils.getCurrentUserId();

        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());
        Page<Review> reviewPage = reviewRepository.findByUserId(userId, pageable);

        return reviewPage.map(review -> modelMapper.map(review, ReviewDTO.class));
    }

    private void updateMovieAverageRating(Long movieId) {
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new ResourceNotFoundException("Movie not found"));

        Double averageRating = reviewRepository.calculateAverageRatingByMovieId(movieId);

        // If the movie has a ratings field, update it
        // This assumes you've added a rating field to your Movie entity
        if (movie.getClass().getDeclaredFields().length > 0) {
            try {
                java.lang.reflect.Field ratingField = movie.getClass().getDeclaredField("rating");
                ratingField.setAccessible(true);
                ratingField.set(movie, averageRating != null ? averageRating : 0.0);
                movieRepository.save(movie);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                // Rating field doesn't exist or can't be accessed, that's okay
            }
        }
    }
}