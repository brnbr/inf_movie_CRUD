package com.example.movie_crud.review.dto;

import lombok.Getter;

@Getter
public class GetReviewResponse {

    private final Long id;
    private final Long movieId;
    private final String content;
    private final Double rating;

    public GetReviewResponse(Long id, Long movieId, String content, Double rating) {
        this.id = id;
        this.movieId = movieId;
        this.content = content;
        this.rating = rating;
    }
}
