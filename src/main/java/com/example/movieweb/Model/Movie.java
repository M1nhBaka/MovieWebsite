package com.example.movieweb.Model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Data
@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(length = 50, nullable = false)
    private String genre;

    @Column(name = "release_date")
    private Date releaseDate;

    @Column(length = 10)
    private String duration;

    @Column(length = 1000)
    private String description;

    @Column
    private Float rating;

    @Column(length = 20)
    private String language;

    @Column(length = 50)
    private String country;

    @Column(length = 100)
    private String director;

    @Column(length = 500)
    private String cast;

    @Column(name = "poster_url")
    private String posterUrl;

    @Column(name = "video_url")
    private String videoUrl;
}
