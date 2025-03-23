package com.example.movieweb.Repository;

import com.example.movieweb.Model.WatchlistItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface WatchlistRepository extends JpaRepository<Long, WatchlistItem>  {
    List<WatchlistItem> findByUserId(Long userId);
    Optional<WatchlistItem> findByUserIdAndMovieId(Long userId, Long movieId);

    List<WatchlistItem> findByUserIdAndWatched(Long userId, Boolean watched);

    boolean existsByUserIdAndMovieId(Long userId, Long movieId);

    Optional<Object> findById(Long itemId);

    void deleteById(Long itemId);
}
