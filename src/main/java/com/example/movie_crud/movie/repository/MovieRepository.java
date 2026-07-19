package com.example.movie_crud.movie.repository;

import com.example.movie_crud.movie.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
