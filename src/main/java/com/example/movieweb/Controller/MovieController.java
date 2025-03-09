package com.example.movieweb.Controller;


import com.example.movieweb.Model.Movie;
import com.example.movieweb.Service.IService.IMovieService;
import com.example.movieweb.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/movie")
public class MovieController {

    @Autowired
    private IMovieService movieService;
    public Movie getMovieById(Long id) {
        return movieService.getMovieById(id);
    }
}
