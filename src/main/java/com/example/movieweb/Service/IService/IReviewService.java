package com.example.movieweb.Service.IService;

import com.example.movieweb.DTO.ReviewDTO;
import jakarta.validation.Valid;
import org.apache.coyote.BadRequestException;
import org.springframework.data.domain.Page;

public interface IReviewService {
    public Page<ReviewDTO> getMovieReviews(Long movieId, int page, int size);
    public ReviewDTO addReview(Long movieId, ReviewDTO reviewRequest) throws BadRequestException;
    public ReviewDTO updateReview(Long reviewId, @Valid ReviewDTO reviewDTO);
    public void deleteReview(Long reviewId);
    public Page<ReviewDTO> getCurrentUserReviews(int page, int size);
    public ReviewDTO getReviewById(Long reviewId);
}
