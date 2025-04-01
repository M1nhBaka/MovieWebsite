package com.example.movieweb.DTO;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ReviewDTO {
    private Long movieId;
    private Long id;
    @NotNull(message = "Rating is required")
    @Min(value = 1, message = "Rating must be at least 1")
    @Max(value = 5, message = "Rating cannot be more than 5")
    private Float rating;
    @Size(max = 1000, message = "Comment cannot exceed 1000 characters")
    private String content;
}
