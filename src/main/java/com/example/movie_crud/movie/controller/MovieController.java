package com.example.movie_crud.movie.controller;

import com.example.movie_crud.movie.dto.*;
import com.example.movie_crud.movie.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @PostMapping("/movies")
    public ResponseEntity<CreateMovieResponse> create(@RequestBody CreateMovieReqeust reqeust) {
        return ResponseEntity.ok(movieService.create(reqeust));
    }

    @GetMapping("/movies")
    public ResponseEntity<List<GetMovieResponse>> getAllMovies() {
        return ResponseEntity.ok(movieService.getAll());
    }

    @GetMapping("/movies/{movieId}")
    public ResponseEntity<GetMovieResponse> getOneMovie(@PathVariable Long movieId) {
        return ResponseEntity.ok(movieService.getOne(movieId));
    }

    @PutMapping("/movies/{movieId}")
    public ResponseEntity<UpdateMovieResponse> update(
            @PathVariable Long movieId,
            @RequestBody UpdateMovieRequest request
    ) {
        return ResponseEntity.ok(movieService.update(movieId, request));
    }

    @DeleteMapping("/movies/{movieId}")
    public ResponseEntity<Void> delete(@PathVariable Long movieId) {
        movieService.delete(movieId);
        return ResponseEntity.noContent().build();
    }
}
