package com.springbootlatest.Spring3.Test.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.URI;

@RestControllerAdvice
public class GlobalExceptionHandler {


    //Handler for all the Exceptions
    @ExceptionHandler(AgeNotValidException.class)
    public ResponseEntity<ProblemDetail> handleAgeNotValidException(AgeNotValidException exception){
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        problemDetail.setTitle(exception.getMessage());
        problemDetail.setDetail("Age is Not Valid to cast VOTE");
        problemDetail.setType(URI.create("http://localhost:8080/errors"));
        problemDetail.setProperty("port",8080);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(problemDetail);
    }
}
