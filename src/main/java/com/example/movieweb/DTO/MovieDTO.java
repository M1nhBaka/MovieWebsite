package com.example.movieweb.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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
    private String videoURL;

}
