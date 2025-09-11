package com.learn.springbootjdbc6.Repository;

import com.learn.springbootjdbc6.model.Product;

import java.util.List;

public interface ProductRepository {
    Product addProduct(Product product);
    List<Product> getAllProducts();
    Product searchProductById(int productId);
    void deleteProductById(int productId);
    List<Product> searchByPrice(float minPrice, float maxPrice);
}
