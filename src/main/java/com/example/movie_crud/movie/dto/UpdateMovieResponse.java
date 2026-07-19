package com.example.movie_crud.movie.dto;

import lombok.Getter;

@Getter
public class UpdateMovieResponse {

    private final Long id;
    private final String title;
    private final String description;

    public UpdateMovieResponse(Long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }
}
