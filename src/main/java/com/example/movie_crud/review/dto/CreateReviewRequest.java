package com.example.movie_crud.review.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class CreateReviewRequest {

    private String content;
    @NotBlank
    private Double rating;
}
