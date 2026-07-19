package com.example.movie_crud.review.exception;

import com.example.movie_crud.exception.ServiceException;
import org.springframework.http.HttpStatus;

public class ReviewNotFoundException extends ServiceException {
    public ReviewNotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }
}
