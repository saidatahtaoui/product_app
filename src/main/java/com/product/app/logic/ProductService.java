package com.product.app.logic;

import com.product.app.dataaccess.dto.ProductDTO;
import com.product.app.dataaccess.entities.Product;

import java.util.List;


public interface ProductService {
    // Save operation
    ProductDTO createProduct(ProductDTO product);

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
