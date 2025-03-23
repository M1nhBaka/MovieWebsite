package com.example.movieweb.Controller;

import com.example.movieweb.DTO.WatchlistItemDTO;
import com.example.movieweb.Service.IService.IWatchlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController(value = "/watchlist")
public class WatchlistController {
    @Autowired
    public IWatchlistService watchlistService;
    @GetMapping
    public ResponseEntity<List<WatchlistItemDTO>> getUserWatchlist(
            @RequestParam(required = false) Boolean watched) {
        return ResponseEntity.ok(watchlistService.getCurrentUserWatchlist(watched));
    }

    @PostMapping("/{movieId}")
    public ResponseEntity<WatchlistItemDTO> addToWatchlist(@PathVariable Long movieId) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(watchlistService.addToWatchlist(movieId));
    }

    @PutMapping("/{itemId}/watched")
    public ResponseEntity<WatchlistItemDTO> markAsWatched(
            @PathVariable Long itemId,
            @RequestParam boolean watched) {
        return ResponseEntity.ok(watchlistService.updateWatchedStatus(itemId, watched));
    }

    @DeleteMapping("/{itemId}")
    public ResponseEntity<Void> removeFromWatchlist(@PathVariable Long itemId) {
        watchlistService.removeFromWatchlist(itemId);
        return ResponseEntity.noContent().build();
    }
}
