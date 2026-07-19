package com.example.movie_crud.review.dto;

import lombok.Getter;

@Getter
public class CreateReviewRequest {

    private String content;
    private Double rating;
}
