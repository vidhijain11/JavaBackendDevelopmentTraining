package com.learn.springbootjdbc6.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.time.LocalDate;

@XmlRootElement
public class Product {
    @NotNull(message = "Product ID is mandatory")
    @Positive(message = "Product ID must be positive")
    private int productId;
    @NotBlank(message = "Product name is mandatory")
    private String productName;
    @Min(value = 0, message = "Product price must be non-negative")
    private float productPrice;
    @JsonFormat(pattern = "dd-MM-yyyy")
    @PastOrPresent(message = "Manufacture date must be in the past or present")
    private LocalDate manufactureDate;

    public Product() {
    }

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
