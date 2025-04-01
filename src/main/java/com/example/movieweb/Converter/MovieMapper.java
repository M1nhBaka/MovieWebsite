package com.example.movieweb.Converter;

import com.example.movieweb.DTO.MovieDTO;
import com.example.movieweb.Model.Movie;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {
    private ModelMapper modelMapper;
    public MovieDTO toDTO(Movie movie) {
        return modelMapper.map(movie, MovieDTO.class);
    }
}
