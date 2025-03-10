package com.example.movieweb.Repository;

import com.example.movieweb.Model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Long, Review> {
    List<Review> findByMovieId(Long movieId);
    List<Review> findByUserId(Long userId);
}
