package com.learn.springboot5.controller;

import com.learn.springboot5.model.Product;
import com.learn.springboot5.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController // @Controller + @ResponseBody
@RequestMapping("/products")
public class ProductApi {

    private final ProductService productService;

    @Autowired
    public ProductApi(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(path = "/welcome", produces = "text/plain")
    public String welcome() {
        return "<font color=blue size=5>Welcome to Product API</font>";
    }

    @GetMapping("/sample")
    public Product sampleProduct() {
        return new Product(101, "iPhone", 999.99f, LocalDate.now());
    }

    @GetMapping("/all")
    public List<Product> allProducts() {
        return productService.getAllProducts();
    }
}
