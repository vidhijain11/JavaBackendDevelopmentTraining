package com.learn.springboot5.exception;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String message) {
        super(message);
        System.out.println("ProductNotFoundException: " + message);
    }
}
