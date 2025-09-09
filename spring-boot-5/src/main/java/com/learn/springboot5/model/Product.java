package com.learn.springboot5.model;

import java.time.LocalDate;


public class Product {
    private int productId;
    private String productName;
    private float productPrice;
    private LocalDate manufactureDate;

    public Product(int productId, String productName, float productPrice, LocalDate manufactureDate) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.manufactureDate = manufactureDate;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    public void setManufactureDate(LocalDate manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public LocalDate getManufactureDate() {
        return manufactureDate;
    }


}
