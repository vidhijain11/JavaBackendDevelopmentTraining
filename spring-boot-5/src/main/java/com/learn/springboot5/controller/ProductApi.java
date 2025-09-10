package com.learn.springboot5.controller;

import com.learn.springboot5.exception.ProductNotFoundException;
import com.learn.springboot5.model.Product;
import com.learn.springboot5.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<Product>> allProducts() {
        List<Product> productList = productService.getAllProducts();
        if (productList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> searchById(@PathVariable("productId") int productId) {
        Product product = productService.getAllProducts().stream()
                .filter(p -> p.getProductId() == productId)
                .findFirst()
                .orElse(null);
        if (product == null) {
            throw new ProductNotFoundException("Product with ID " + productId + " not found");
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody @Valid Product product) {
        // In a real application, you would save the product to a database
        // Here, we just return the product as a confirmation
        List<Product> products = productService.getAllProducts();
        products.add(product);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @GetMapping("/searchbyprice")
    public ResponseEntity<List<Product>> getProductsByPriceRange(@RequestParam("minPrice") float minPrice, @RequestParam("maxPrice") float maxPrice) {
        List<Product> productList = productService.getAllProducts().stream()
                .filter(p -> p.getProductPrice() >= minPrice && p.getProductPrice() <= maxPrice)
                .toList();
        if( productList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }
}
