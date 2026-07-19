package com.example.movie_crud.movie.service;

import com.example.movie_crud.exception.MovieNotFoundException;
import com.example.movie_crud.movie.dto.*;
import com.example.movie_crud.movie.entity.Movie;
import com.example.movie_crud.movie.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    @Transactional
    public CreateMovieResponse create(CreateMovieReqeust reqeust) {
        Movie movie = new Movie(reqeust.getTitle(), reqeust.getDescription());
        Movie savedMovie = movieRepository.save(movie);

        return new CreateMovieResponse(
                savedMovie.getId(),
                savedMovie.getTitle(),
                savedMovie.getDescription()
        );
    }

    @Transactional(readOnly = true)
    public List<GetMovieResponse> getAll() {
        List<Movie> movies = movieRepository.findAll();
        return movies.stream().map(m -> new GetMovieResponse(
                m.getId(),
                m.getTitle(),
                m.getDescription()
        )).toList();
    }

    @Transactional(readOnly = true)
    public GetMovieResponse getOne(Long movieId) {
        Movie movie = movieRepository.findById(movieId).orElseThrow(
                () -> new MovieNotFoundException("해당 영화가 없습니다.")
        );

        return new GetMovieResponse(
                movie.getId(),
                movie.getTitle(),
                movie.getDescription()
        );
    }

    @Transactional
    public UpdateMovieResponse update(Long movieId, UpdateMovieRequest request) {
        Movie movie = movieRepository.findById(movieId).orElseThrow(
                () -> new MovieNotFoundException("해당 영화가 없습니다.")
        );

        movie.update(request.getTitle(), request.getDescription());
        return new UpdateMovieResponse(movie.getId(), movie.getTitle(), movie.getDescription());
    }

    @Transactional
    public void delete(Long movieId) {
        boolean exist = movieRepository.existsById(movieId);
        if (!exist) {
            throw new MovieNotFoundException("해당 영화가 없습니다.");
        }
        movieRepository.deleteById(movieId);
    }

}
