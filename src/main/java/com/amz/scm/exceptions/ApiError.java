package com.amz.scm.exceptions;

public class ApiError extends RuntimeException {
    
    public ApiError(String message) {
        super(message != null ? message : "Something Went Wrong");
    }

}
