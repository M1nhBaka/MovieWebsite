package com.example.movieweb.DTO;

import com.example.movieweb.Model.Movie;
import com.example.movieweb.Model.User;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class WatchlistItemDTO {
    private Long id;

    private User user;

    private Movie movie;

    private LocalDateTime addedAt = LocalDateTime.now();
    private boolean watched = false;
}
