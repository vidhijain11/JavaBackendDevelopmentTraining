package com.learn.springbootjdbc6.advice;

import com.learn.springbootjdbc6.dto.ApiException;
import com.learn.springbootjdbc6.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    //response entity represents the whole HTTP response: status code, headers, and body.
    //it allows you to control everything that goes into it.
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<?> handleProductNotFoundException(ProductNotFoundException ex) {
        ApiException apiException = new ApiException();
        apiException.setMessage(ex.getMessage());
        apiException.setStatus(HttpStatus.NOT_FOUND.value());
        apiException.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(apiException, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleInvalidArgumentValidationException(MethodArgumentNotValidException ex) {
        List<ApiException> errors = ex.getAllErrors().stream()
                .map(error -> {
                    ApiException apiError = new ApiException();
                    apiError.setMessage(error.getDefaultMessage());
                    apiError.setStatus(HttpStatus.BAD_REQUEST.value());
                    apiError.setTimestamp(System.currentTimeMillis());
                    return apiError;
                }).toList();
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
