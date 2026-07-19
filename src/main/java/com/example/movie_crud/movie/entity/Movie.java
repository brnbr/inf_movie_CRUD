package com.example.movie_crud.movie.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "movies")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String title;
    private String description;

    public Movie(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public void update(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
