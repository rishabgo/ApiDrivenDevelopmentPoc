package com.rishabh.BooksProject.exception;

import org.books.models.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.time.OffsetDateTime;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> illegalArgumentExceptionHandler(IllegalArgumentException ex) {
        final ErrorResponse errorResponse = new ErrorResponse()
                .message(ex.getMessage())
                .type(HttpStatus.BAD_REQUEST.toString())
                .time(OffsetDateTime.now());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);

    }

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleAllException(Exception ex) {

        final ErrorResponse errorResponse = new ErrorResponse()
                .message(ex.getMessage())
                .type(HttpStatus.INTERNAL_SERVER_ERROR.toString())
                .time(OffsetDateTime.now());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
