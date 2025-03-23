package com.example.movieweb.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String title;
    @Column
    private String genre;
    @Column
    private Date releaseDate;
    @Column
    private String duration;
    @Column
    private String description;
    @Column
    private Float rating;
    @Column
    private String language;
    @Column
    private String videoURL;


}
