package com.example.movieweb.Service;

import com.example.movieweb.Model.Movie;
import com.example.movieweb.Repository.MovieRepository;
import com.example.movieweb.Service.IService.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService implements IMovieService {
    @Autowired
    private MovieRepository movieRepository;
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }
    public Movie getMovieById(Long id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found"));
    }
    public List<Movie> searchMovies(String query) {
        return movieRepository.findByTitleContaining(query);
    }

    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }
    @Override
    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }

}
