package com.example.movieweb.Controller;

import com.example.movieweb.DTO.WatchlistItemDTO;
import com.example.movieweb.Service.IService.IWatchlistService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/watchlist")
public class WatchlistController {
    @Autowired
    private IWatchlistService watchlistService;

    @GetMapping
    public String getUserWatchlist(
            @RequestParam(required = false) Boolean watched,
            Model model) {
        List<WatchlistItemDTO> items = watchlistService.getCurrentUserWatchlist(watched);
        model.addAttribute("items", items);
        model.addAttribute("watched", watched);
        return "watchlist/list";
    }

    @PostMapping("/{movieId}/add")
    public String addToWatchlist(@PathVariable Long movieId) throws BadRequestException {
        watchlistService.addToWatchlist(movieId);
        return "redirect:/watchlist";
    }

    @PostMapping("/{itemId}/watched")
    public String markAsWatched(
            @PathVariable Long itemId,
            @RequestParam boolean watched) {
        watchlistService.updateWatchedStatus(itemId, watched);
        return "redirect:/watchlist";
    }

    @PostMapping("/{itemId}/delete")
    public String removeFromWatchlist(@PathVariable Long itemId) {
        watchlistService.removeFromWatchlist(itemId);
        return "redirect:/watchlist";
    }
}
