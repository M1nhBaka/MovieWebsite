package com.example.movieweb.Repository;

import com.example.movieweb.Model.WatchlistItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WatchlistRepository extends JpaRepository<WatchlistItem, Long> {
    List<WatchlistItem> findByUserIdAndWatched(Long userId, Boolean watched);

    List<WatchlistItem> findByUserId(Long userId);

    boolean existsByUserIdAndMovieId(Long userId, Long movieId);
}
