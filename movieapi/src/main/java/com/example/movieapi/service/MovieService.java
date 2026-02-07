package com.example.movieapi.service;

import com.example.movieapi.model.Movie;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    private List<Movie> movies = new ArrayList<>();
    private Long idCounter = 1L;

    public Movie addMovie(Movie movie) {
        movie.setId(idCounter++);
        movies.add(movie);
        return movie;
    }

    public Movie getMovieById(Long id) {
        return movies.stream()
                .filter(m -> m.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Movie> getAllMovies() {
        return movies;
    }
}
