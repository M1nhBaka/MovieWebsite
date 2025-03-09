package com.example.movieweb.Service.IService;

import com.example.movieweb.Model.Movie;

import java.util.List;

public interface IMovieService {
    public List<Movie> getAllMovies();
    public Movie getMovieById(Long id);
    public Movie addMovie(Movie movie);
    public void deleteMovie(Long id);
    public List<Movie> searchMovies(String query);
}
