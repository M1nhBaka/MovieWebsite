package com.example.movieweb.Controller;

import com.example.movieweb.DTO.MovieDTO;
import com.example.movieweb.Service.IService.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private IMovieService movieService;

    @GetMapping
    public String listMovies(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "12") int size,
            @RequestParam(required = false) String search,
            Model model) {
        Page<MovieDTO> movies = movieService.getAllMovies(page, size, search);
        model.addAttribute("movies", movies);
        model.addAttribute("search", search);
        return "movie/list";
    }

    @GetMapping("/{id}")
    public String getMovieDetails(@PathVariable Long id, Model model) {
        MovieDTO movie = movieService.getMovieById(id);
        model.addAttribute("movie", movie);
        return "movie/details";
    }

    @GetMapping("/{id}/reviews")
    public String getMovieReviews(
            @PathVariable Long id,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            Model model) {
        return "redirect:/reviews/movies/" + id;
    }
}
