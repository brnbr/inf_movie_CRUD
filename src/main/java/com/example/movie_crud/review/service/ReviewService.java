package com.example.movie_crud.review.service;

import com.example.movie_crud.exception.MovieNotFoundException;
import com.example.movie_crud.movie.entity.Movie;
import com.example.movie_crud.movie.repository.MovieRepository;
import com.example.movie_crud.review.dto.*;
import com.example.movie_crud.review.entity.Review;
import com.example.movie_crud.review.exception.ReviewNotFoundException;
import com.example.movie_crud.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final MovieRepository movieRepository;

    @Transactional
    public CreateReviewResponse create(Long movieId, CreateReviewRequest request) {
        Movie movie = movieRepository.findById(movieId).orElseThrow(
                () -> new MovieNotFoundException("해당 영화가 없습니다.")
        );

        Review review = new Review(request.getContent(), request.getRating(), movie);
        Review saved = reviewRepository.save(review);

        return new CreateReviewResponse(
                saved.getId(),
                saved.getContent(),
                saved.getRating()
        );
    }

    @Transactional(readOnly = true)
    public List<GetReviewResponse> getAllByMovieId(Long movieId) {
        Movie movie = movieRepository.findById(movieId).orElseThrow(
                () ->  new MovieNotFoundException("해당 영화가 없습니다.")
        );

        List<Review> reviews = reviewRepository.findAllByMovieId(movie.getId());
        if (reviews.isEmpty()) {
            throw new ReviewNotFoundException("해당 리뷰가 없습니다.");
        }

        return reviews.stream().map(r -> new GetReviewResponse(
                r.getId(),
                r.getMovie().getId(),
                r.getContent(),
                r.getRating()
        )).toList();
    }

    @Transactional(readOnly = true)
    public GetReviewResponse getOne(Long movieid, Long reviewId) {
        movieRepository.findById(movieid).orElseThrow(
                () -> new MovieNotFoundException("영화가 없습니다.")
        );

        Review review = reviewRepository.findById(reviewId).orElseThrow(
                () -> new ReviewNotFoundException("리뷰를 찾을 수 없습니다.")
        );

        return new GetReviewResponse(review.getId(), review.getMovie().getId(), review.getContent(), review.getRating());
    }

    @Transactional
    public UpdateReviewResponse update(Long reviewId, UpdateReviewRequest request) {
        Review review = reviewRepository.findById(reviewId).orElseThrow(
                () -> new ReviewNotFoundException("리뷰를 찾을 수 없습니다.")
        );

        review.update(request.getContent(), request.getRating());
        return new UpdateReviewResponse(review.getId(), review.getMovie().getId(), review.getContent(), review.getRating());
    }

    @Transactional
    public void delete(Long reviewId) {
        boolean exist = reviewRepository.existsById(reviewId);
        if (!exist) {
            throw new ReviewNotFoundException("리뷰를 찾을 수 없습니다.");
        }
        reviewRepository.deleteById(reviewId);
    }
}