package com.example.movie_crud.review.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class UpdateReviewRequest {

    private String content;
    @NotBlank
    private Double rating;
}
