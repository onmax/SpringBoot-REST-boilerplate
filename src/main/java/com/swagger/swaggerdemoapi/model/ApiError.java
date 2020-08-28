package com.swagger.swaggerdemoapi.model;

import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class ApiError {

    @ApiModelProperty(example = "Error in the input data", notes="Useful message for the user")
    private String message;

    @ApiModelProperty(example = "User with id 23 does not exists", notes="Useful message for the developer")
    private String details;

    @ApiModelProperty(notes="More detailed error message for the developer")
    private List<String> errors;

    private LocalDateTime timestamp;

    public ApiError(String message, List<String> errors) {
        super();
        this.message = message;
        this.errors = errors;
        this.timestamp = LocalDateTime.now();
    }

    public ApiError(String message, String error) {
        super();
        this.message = message;
        errors = Arrays.asList(error);
        this.timestamp = LocalDateTime.now();
    }

    public ApiError(String message) {
        super();
        this.message = message;
        errors = Arrays.asList();
        this.timestamp = LocalDateTime.now();
    }

    public ApiError(String message, List<String> errors, String details) {
        super();
        this.message = message;
        this.errors = errors;
        this.timestamp = LocalDateTime.now();
        this.details = details;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }

    public List<String> getErrors() {
        return errors;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}