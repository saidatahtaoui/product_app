package com.product.logic.api;

import com.product.dataaccess.Product;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {
    // Save operation
    Product createProduct(Product product);

    // Read operation
    List<Product> getAllProducts();


    //get one product by Id
    Product getProductById(Integer productId);

    // Update operation
    Product updateProduct(Product product,
                                Integer productId);

    // Delete operation
    void deleteProductById(Integer productId);
}
