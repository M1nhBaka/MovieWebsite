package com.example.movieweb.Service.IService;

import com.example.movieweb.DTO.WatchlistItemDTO;
import com.example.movieweb.Exception.ResourceNotFoundException;
import com.example.movieweb.Model.WatchlistItem;
import org.apache.coyote.BadRequestException;

public interface IWatchlistService {

    Object getCurrentUserWatchlist(Boolean watched);

    WatchlistItemDTO addToWatchlist(Long movieId) throws ResourceNotFoundException, BadRequestException;

    WatchlistItemDTO updateWatchedStatus(Long itemId, boolean watched);

    void removeFromWatchlist(Long itemId) throws ResourceNotFoundException;
}
