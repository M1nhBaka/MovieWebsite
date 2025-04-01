package com.example.movieweb.Service;

import com.example.movieweb.Converter.MovieMapper;
import com.example.movieweb.DTO.MovieDTO;
import com.example.movieweb.Model.Movie;
import com.example.movieweb.Repository.MovieRepository;
import com.example.movieweb.Service.IService.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService implements IMovieService {
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private MovieMapper movieMapper;
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }
    public MovieDTO getMovieById(Long id) {
        Movie movie =  movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found"));
        MovieDTO movieDTO = movieMapper.toDTO(movie);
        return movieDTO;
    }
    public List<Movie> searchMovies(String query) {
        return movieRepository.findByTitleContaining(query);
    }

    @Override
    public Page<MovieDTO> getAllMovies(int page, int size, String search) {
        return null;
    }

    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }
    @Override
    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }


}
