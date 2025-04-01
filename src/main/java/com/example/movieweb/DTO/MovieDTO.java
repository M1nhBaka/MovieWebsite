package com.example.movieweb.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.util.Date;

@Data
public class MovieDTO {
    @NotNull
    private Long id;
    private String title;
    private String genre;
    private Date releaseDate;
    private String duration;
    private String description;
    private Float rating;
    private String language;
    private String country;
    private String director;
    private String cast;
    private String posterUrl;
    private String videoUrl;
}
