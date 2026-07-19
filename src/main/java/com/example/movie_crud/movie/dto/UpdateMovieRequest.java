package com.example.movie_crud.movie.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class UpdateMovieRequest {

    @NotBlank
    private String title;
    private String description;
}
