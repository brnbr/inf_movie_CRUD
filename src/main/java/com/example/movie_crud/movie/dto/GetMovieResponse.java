package com.example.movie_crud.movie.dto;

import lombok.Getter;

@Getter
public class GetMovieResponse {

    private final Long id;
    private final String title;
    private final String descripton;

    public GetMovieResponse(Long id, String title, String descripton) {
        this.id = id;
        this.title = title;
        this.descripton = descripton;
    }
}
