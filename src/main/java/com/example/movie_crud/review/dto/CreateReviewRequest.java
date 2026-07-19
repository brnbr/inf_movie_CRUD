package com.example.movie_crud.review.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class CreateReviewRequest {

    @Size(max = 200)
    private String content;
    @Min(0)
    private Double rating;
}
