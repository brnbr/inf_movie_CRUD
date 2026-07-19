package com.example.movie_crud.review.dto;

import lombok.Getter;

@Getter
public class UpdateReviewRequest {

    private String content;
    private Double rating;
}
