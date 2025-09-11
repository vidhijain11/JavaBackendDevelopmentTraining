package com.learn.springbootjdbc6.controller;

import com.learn.springbootjdbc6.exception.ProductNotFoundException;
import com.learn.springbootjdbc6.model.Product;
import com.learn.springbootjdbc6.service.ProductService;
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

    @GetMapping(value = "/welcome", produces = "text/plain")
    public String welcome() {
        return "<font color=blue size=5>Welcome to Product API</font>";
    }

    @GetMapping("/sample")
    public Product sampleProduct() {
        return new Product(101, "iPhone", 999.99f, LocalDate.now());
    }

    @GetMapping(value = "/all", produces = {"application/json", "application/xml"})
    public ResponseEntity<List<Product>> allProducts() {
        List<Product> productList = productService.getAllProducts();
        if (productList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @GetMapping(value = "/{productId}", produces = {"application/json", "application/xml"})
    public ResponseEntity<Product> searchById(@PathVariable("productId") int productId) {
        Product product = productService.searchProductById(productId);
        if (product == null) {
            throw new ProductNotFoundException("Product with ID " + productId + " not found");
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping(consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    public ResponseEntity<Product> addProduct(@RequestBody @Valid Product product) {
       Product newProduct = productService.addProduct(product);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    @GetMapping(value = "/searchbyprice", produces = "application/json")
    public ResponseEntity<List<Product>> getProductsByPriceRange(@RequestParam("minPrice") float minPrice, @RequestParam("maxPrice") float maxPrice) {
        List<Product> productList = productService.searchByPrice(minPrice, maxPrice);
        if( productList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @DeleteMapping("/{productId}")
    public  ResponseEntity<Void> delete(@PathVariable int productId) {
        productService.deleteProductById(productId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
