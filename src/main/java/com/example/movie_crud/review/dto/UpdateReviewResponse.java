package com.example.movie_crud.review.dto;

import lombok.Getter;

@Getter
public class UpdateReviewResponse {

    private final Long id;
    private final Long movieId;
    private final String content;
    private final Double rating;

    public UpdateReviewResponse(Long id, Long movieId, String content, Double rating) {
        this.id = id;
        this.movieId = movieId;
        this.content = content;
        this.rating = rating;
    }
}
