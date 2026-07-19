package com.example.movie_crud.review.dto;

import lombok.Getter;

@Getter
public class CreateReviewResponse {

    public final Long id;
    public final String content;
    public final Double rating;

    public CreateReviewResponse(Long id, String content, Double rating) {
        this.id = id;
        this.content = content;
        this.rating = rating;
    }
}
