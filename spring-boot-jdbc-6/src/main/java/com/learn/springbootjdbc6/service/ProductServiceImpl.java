package com.learn.springbootjdbc6.service;

import com.learn.springbootjdbc6.Repository.ProductRepository;
import com.learn.springbootjdbc6.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    public ProductServiceImpl() {}

    @Override
    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    @Override
    public Product addProduct(Product product) {
         return productRepository.addProduct(product);
    }

    @Override
    public Product searchProductById(int productId) {
        return productRepository.searchProductById(productId);
    }

    @Override
    public void deleteProductById(int productId) {
        productRepository.deleteProductById(productId);
    }

    @Override
    public List<Product> searchByPrice(float minPrice, float maxPrice) {
        return productRepository.searchByPrice(minPrice, maxPrice);
    }


}
