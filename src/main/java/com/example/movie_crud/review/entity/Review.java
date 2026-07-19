package com.example.movie_crud.review.entity;

import com.example.movie_crud.movie.entity.Movie;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "reviews")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200)
    private String content;
    @Column(nullable = false)
    private Double rating;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    private Movie movie;

    public Review(String content, Double rating, Movie movie) {
        this.content = content;
        this.rating = rating;
        this.movie = movie;
    }

    public void update(String content, Double rating) {
        this.content = content;
        this.rating = rating;
    }
}
