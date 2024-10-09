package com.product.app.logic;

import com.product.app.dataaccess.Product;

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
