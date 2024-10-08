package com.product.controller;

import com.product.dataaccess.Product;
import com.product.logic.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    @Autowired
    private ProductServiceImpl service;

    @PostMapping("products")
    public void createProduct( @RequestBody Product product){
        service.createProduct(product);


    }
    @GetMapping("/api/example")
    public String displayData() {
        String message = "Welcome to GeeksForGeeks";
        return message;
    }
}
