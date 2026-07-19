package com.example.movie_crud.movie.dto;

import lombok.Getter;

@Getter
public class CreateMovieResponse {

    private final Long id;
    private final String title;
    private final String description;

    public CreateMovieResponse(Long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }
}
