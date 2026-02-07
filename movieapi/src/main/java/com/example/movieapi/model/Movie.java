package com.example.movieapi.model;

import jakarta.validation.constraints.NotBlank;

public class Movie {

    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Description is required")
    private String description;

    private String genre;

    public Movie() {}

    public Movie(Long id, String name, String description, String genre) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.genre = genre;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }
}
