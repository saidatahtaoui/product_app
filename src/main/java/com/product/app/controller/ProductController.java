package com.product.app.controller;

import com.product.app.dataaccess.dto.ProductDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductController {

    ResponseEntity<ProductDTO> createProduct(ProductDTO product);

    // Read operation
    List<ProductDTO> getAllProducts();


    //get one product by Id
    ProductDTO getProductById(Integer productId);

    // Update operation
    ProductDTO updateProduct(ProductDTO product,
                             Integer productId);

    // Delete operation
    void deleteProductById(Integer productId);
}
