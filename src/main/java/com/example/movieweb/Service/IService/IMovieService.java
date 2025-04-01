package com.example.movieweb.Service.IService;

import com.example.movieweb.DTO.MovieDTO;
import com.example.movieweb.Model.Movie;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IMovieService {
    public List<Movie> getAllMovies();
    public MovieDTO getMovieById(Long id);
    public Movie addMovie(Movie movie);
    public void deleteMovie(Long id);
    public List<Movie> searchMovies(String query);

    Page<MovieDTO> getAllMovies(int page, int size, String search);
}
