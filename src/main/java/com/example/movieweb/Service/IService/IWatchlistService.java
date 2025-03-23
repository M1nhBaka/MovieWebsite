package com.example.movieweb.Service.IService;

import com.example.movieweb.DTO.WatchlistItemDTO;
import com.example.movieweb.Model.WatchlistItem;

public interface IWatchlistService {
    public WatchlistItem getAllWatchlist();

    Object getCurrentUserWatchlist(Boolean watched);

    WatchlistItemDTO addToWatchlist(Long movieId);

    WatchlistItemDTO updateWatchedStatus(Long itemId, boolean watched);

    void removeFromWatchlist(Long itemId);
}
