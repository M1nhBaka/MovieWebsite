package com.example.movieweb.Controller;


import com.example.movieweb.Model.Movie;
import com.example.movieweb.Service.IService.IMovieService;
import com.example.movieweb.Service.MovieService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController(value = "/movie")
public class MovieController {

    @Autowired
    private IMovieService movieService;
    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id) {
        return ResponseEntity.ok(movieService.getMovieById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Movie>> searchMovies(@RequestParam String query) {
        return ResponseEntity.ok(movieService.searchMovies(query));
    }

    @PostMapping
    public ResponseEntity<Movie> addMovie(@Valid @RequestBody Movie movie) {
        return ResponseEntity.status(HttpStatus.CREATED).body(movieService.addMovie(movie));
    }
}
