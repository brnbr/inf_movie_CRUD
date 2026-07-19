package com.example.movie_crud.movie.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class CreateMovieReqeust {

    @NotBlank
    private String title;
    private String description;
}
