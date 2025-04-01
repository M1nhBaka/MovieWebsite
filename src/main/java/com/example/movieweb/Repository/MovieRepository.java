package com.example.movieweb.Repository;

import com.example.movieweb.Model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    public Movie findByTitle(String title);
    public Movie getMovieById(int id);
    List<Movie> findByTitleContaining(String query);    
}
