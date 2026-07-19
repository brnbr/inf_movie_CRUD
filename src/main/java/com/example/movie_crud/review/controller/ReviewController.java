package com.example.movie_crud.review.controller;

import com.example.movie_crud.review.dto.*;
import com.example.movie_crud.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping("/movies/{movieId}/reviews")
    public ResponseEntity<CreateReviewResponse> create(
            @PathVariable Long movieId,
            @RequestBody CreateReviewRequest request
    ) {
        return ResponseEntity.ok(reviewService.create(movieId, request));
    }

    @GetMapping("/movies/{movieId}/reviews")
    public ResponseEntity<List<GetReviewResponse>> getAllReviews(@PathVariable Long movieId) {
        return ResponseEntity.ok(reviewService.getAllByMovieId(movieId));
    }

    @GetMapping("/movies/{movieId}/reviews/{reviewId}")
    public ResponseEntity<GetReviewResponse> getOneReview(
            @PathVariable Long movieId,
            @PathVariable Long reviewId
    ) {
        return ResponseEntity.ok(reviewService.getOne(movieId, reviewId));
    }

    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<UpdateReviewResponse> update(
            @PathVariable Long reviewId,
            @RequestBody UpdateReviewRequest request
    ) {
        return ResponseEntity.ok(reviewService.update(reviewId, request));
    }

    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<Void> delete(@PathVariable Long reviewId) {
        reviewService.delete(reviewId);
        return ResponseEntity.noContent().build();
    }
}
