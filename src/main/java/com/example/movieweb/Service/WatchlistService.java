package com.example.movieweb.Service;

import com.example.movieweb.DTO.WatchlistItemDTO;
import com.example.movieweb.Service.IService.IWatchlistService;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WatchlistService implements IWatchlistService {
//    @Autowired
//    private WatchlistRepository watchlistRepository;
//    @Autowired
//    private MovieRepository movieRepository;
//    @Autowired
//    private UserRepository userRepository;
//    @Autowired
//    private ModelMapper modelMapper;

    public List<WatchlistItemDTO> getCurrentUserWatchlist(Boolean watched) {
//        Long userId = SecurityUtils.getCurrentUserId();
//
//        List<WatchlistItem> watchlistItems;
//        if (watched != null) {
//            watchlistItems = watchlistRepository.findByUserIdAndWatched(userId, watched);
//        } else {
//            watchlistItems = watchlistRepository.findByUserId(userId);
//        }
//
//        return watchlistItems.stream()
//                .map(item -> modelMapper.map(item, WatchlistItemDTO.class))
//                .collect(Collectors.toList());
        return null;
    }

    public WatchlistItemDTO addToWatchlist(Long movieId) throws BadRequestException {
//        Long userId = SecurityUtils.getCurrentUserId();
//
//        // Check if movie exists
//        if (!movieRepository.existsById(movieId)) {
//            throw new ResourceNotFoundException("Movie not found");
//        }
//
//        // Check if already in watchlist
//        if (watchlistRepository.existsByUserIdAndMovieId(userId, movieId)) {
//            throw new BadRequestException("Movie already in watchlist");
//        }
//
//        User user = userRepository.findById(Math.toIntExact(userId))
//                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
//
//        Movie movie = movieRepository.findById(movieId)
//                .orElseThrow(() -> new ResourceNotFoundException("Movie not found"));
//
//        WatchlistItem watchlistItem = new WatchlistItem();
//        watchlistItem.setUser(user);
//        watchlistItem.setMovie(movie);
//        watchlistItem.setAddedAt( LocalDateTime.now());
//        watchlistItem.setWatched(false);
//
//        WatchlistItem savedItem = watchlistRepository.save(watchlistItem);
//
//        return modelMapper.map(savedItem, WatchlistItemDTO.class);
        return null;
    }

    public WatchlistItemDTO updateWatchedStatus(Long itemId, boolean watched) {
//        Long userId = SecurityUtils.getCurrentUserId();
//
//        WatchlistItem watchlistItem = (WatchlistItem) watchlistRepository.findById(itemId)
//                .orElseThrow(() -> new ResourceNotFoundException("Watchlist item not found"));
//
//        // Verify ownership
//        if (!watchlistItem.getUser().getId().equals(userId)) {
//            throw new AccessDeniedException("You don't have permission to update this watchlist item");
//        }
//
//        watchlistItem.setWatched(watched);
//        WatchlistItem updatedItem = watchlistRepository.save(watchlistItem);
//
//        return modelMapper.map(updatedItem, WatchlistItemDTO.class);
        return null;
    }

    public void removeFromWatchlist(Long itemId) {
//        Long userId = SecurityUtils.getCurrentUserId();

//        WatchlistItem watchlistItem = (WatchlistItem) watchlistRepository.findById(itemId)
//                .orElseThrow(() -> new ResourceNotFoundException("Watchlist item not found"));
//
////        // Verify ownership
////        if (!watchlistItem.getUser().getId().equals(userId)) {
////            throw new AccessDeniedException("You don't have permission to delete this watchlist item");
////        }
//
//        watchlistRepository.deleteById(itemId);
    }
}
