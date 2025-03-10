package com.example.movieweb.Controller;

import com.example.movieweb.Service.IService.IWatchlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/watchlist")
public class WatchlistController {
    @Autowired
    public IWatchlistService watchlistService;

}
