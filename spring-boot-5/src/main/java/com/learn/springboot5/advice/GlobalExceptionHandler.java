package com.learn.springboot5.advice;

import com.learn.springboot5.dto.ApiException;
import com.learn.springboot5.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    //response entity represents the whole HTTP response: status code, headers, and body.
    //it allows you to control everything that goes into it.
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<?> handleProductNotFoundException(ProductNotFoundException ex) {
        System.out.println("GlobalExceptionHandler: " + ex.getMessage());
        ApiException apiException = new ApiException();
        apiException.setMessage(ex.getMessage());
        apiException.setStatus(HttpStatus.NOT_FOUND.value());
        apiException.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(apiException, HttpStatus.NOT_FOUND);
    }
}
