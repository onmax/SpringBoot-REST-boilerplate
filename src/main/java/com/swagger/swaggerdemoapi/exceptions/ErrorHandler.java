package com.swagger.swaggerdemoapi.exceptions;

import com.swagger.swaggerdemoapi.model.ApiError;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.NoSuchElementException;

@ControllerAdvice
public class ErrorHandler extends Exception {

    @ExceptionHandler({UserNotFoundException.class, NoSuchElementException.class, EmptyResultDataAccessException.class})
    public ResponseEntity<Object> handleException(Exception ex,
                                                  WebRequest request) {
        ApiError apiError = new ApiError(ex.getMessage());
        HttpHeaders headers = new HttpHeaders();
        headers.add("status", "404");
        return new ResponseEntity<>(apiError, headers, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex,
                                                            WebRequest request) {
        ApiError apiError = new ApiError(
                "Unknown server error",
                "Server Error 500");
        HttpHeaders headers = new HttpHeaders();
        headers.add("status", "500");
        return new ResponseEntity<>(apiError, headers, HttpStatus.NOT_FOUND);
    }
}