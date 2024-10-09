package com.product.app.controller;

import com.product.app.dataaccess.Product;
import com.product.app.logic.ProductServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class ProductController {
    @Autowired
    private ProductServiceImpl service;

    @PostMapping("products")
    public void createProduct( @RequestBody Product product){
        service.createProduct(product);
    }

    @GetMapping("/get")
    public List<Product> getAll(){
        return service.getAllProducts();
    }

}
