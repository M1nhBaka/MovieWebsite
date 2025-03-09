package com.example.movieweb.Repository;

import com.example.movieweb.Model.WatchlistItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WatchlistRepository extends JpaRepository<Long, WatchlistItem>  {
}
