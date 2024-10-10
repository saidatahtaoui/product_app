package com.product.app.controller;

import com.product.app.dataaccess.dto.ProductDTO;
import com.product.app.logic.ProductServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class ProductControllerImpl implements ProductController{
    @Autowired
    private ProductServiceImpl service;

    @PostMapping("products")
    public ResponseEntity<ProductDTO> createProduct(@Valid @RequestBody ProductDTO product){
          ProductDTO productDTO =service.createProduct(product);
          return new ResponseEntity<>(productDTO, HttpStatus.OK);
    }

    @Override
    @GetMapping("/products/all")
    public List<ProductDTO> getAllProducts(){
        return service.getAllProducts();
    }

    @Override
    @GetMapping("/products/{id}")
    public ProductDTO getProductById(@PathVariable("id") Integer productId) {
        return service.getProductById(productId);
    }

    @Override
    @PatchMapping("/products/update/{id}")
    public ProductDTO updateProduct(ProductDTO product, @PathVariable Integer productId) {
        return null;
    }

    @Override
    public void deleteProductById(Integer productId) {

    }









}
