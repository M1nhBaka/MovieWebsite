package com.example.movieweb.Repository;

import com.example.movieweb.Model.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    Page<Review> findByMovieId(Long movieId, Pageable pageable);
    List<Review> findByMovieId(Long movieId);
    Page<Review> findByUserId(Long userId, Pageable pageable);

    boolean existsByUserIdAndMovieId(Long userId, Long movieId);

    @Query("SELECT AVG(r.rating) FROM Review r WHERE r.movie.id = :movieId")
    Double calculateAverageRatingByMovieId(@Param("movieId") Long movieId);
}