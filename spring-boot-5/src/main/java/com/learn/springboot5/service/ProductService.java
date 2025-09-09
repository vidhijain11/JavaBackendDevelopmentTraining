package com.learn.springboot5.service;

import com.learn.springboot5.model.Product;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductService {
    private final List<Product> productList = new ArrayList<>();

    public ProductService() {
        productList.add(new Product(101, "iPhone", 999.99f, LocalDate.of(2023, 1, 15)));
        productList.add(new Product(102, "Samsung Galaxy", 899.99f, LocalDate.of(2024, 2, 20)));
        productList.add(new Product(103, "Google Pixel", 799.99f, LocalDate.of(2025, 3, 10)));
    }

    public List<Product> getAllProducts() {
        return productList;
    }
}
