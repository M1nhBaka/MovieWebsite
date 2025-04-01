package com.example.movieweb.Controller;

import com.example.movieweb.DTO.ReviewDTO;
import com.example.movieweb.Service.IService.IReviewService;
import com.example.movieweb.Service.ReviewService;
import jakarta.validation.Valid;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private IReviewService reviewService;

    @GetMapping("/movies/{movieId}")
    public String getMovieReviews(
            @PathVariable Long movieId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            Model model) {
        Page<ReviewDTO> reviews = reviewService.getMovieReviews(movieId, page, size);
        model.addAttribute("reviews", reviews);
        model.addAttribute("movieId", movieId);
        return "review/list";
    }

    @GetMapping("/movies/{movieId}/add")
    public String showAddReviewForm(@PathVariable Long movieId, Model model) {
        model.addAttribute("review", new ReviewDTO());
        model.addAttribute("movieId", movieId);
        return "review/form";
    }

    @PostMapping("/movies/{movieId}/add")
    public String addReview(
            @PathVariable Long movieId,
            @Valid @ModelAttribute ReviewDTO reviewRequest) throws BadRequestException {
        reviewService.addReview(movieId, reviewRequest);
        return "redirect:/reviews/movies/" + movieId;
    }

    @GetMapping("/{reviewId}/edit")
    public String showEditReviewForm(@PathVariable Long reviewId, Model model) {
        ReviewDTO review = reviewService.getReviewById(reviewId);
        model.addAttribute("review", review);
        return "review/form";
    }

    @PostMapping("/{reviewId}/edit")
    public String updateReview(
            @PathVariable Long reviewId,
            @Valid @ModelAttribute ReviewDTO reviewDTO) {
        reviewService.updateReview(reviewId, reviewDTO);
        return "redirect:/reviews/movies/" + reviewDTO.getMovieId();
    }

    @PostMapping("/{reviewId}/delete")
    public String deleteReview(@PathVariable Long reviewId) {
        Long movieId = reviewService.getReviewById(reviewId).getMovieId();
        reviewService.deleteReview(reviewId);
        return "redirect:/reviews/movies/" + movieId;
    }

    @GetMapping("/my-reviews")
    public String getCurrentUserReviews(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            Model model) {
        Page<ReviewDTO> reviews = reviewService.getCurrentUserReviews(page, size);
        model.addAttribute("reviews", reviews);
        return "review/my-reviews";
    }
}
