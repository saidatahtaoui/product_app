package com.product.app.logic;

import com.product.app.dataaccess.Product;
import com.product.app.logic.ProductService;
import com.product.app.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
        Product createdProduct = productRepository.save(product);
        log.info("Product just created: {}", product);
        return createdProduct;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Integer productId) {
        return productRepository.findById(productId).get();
    }

    @Override
    public Product updateProduct(Product product, Integer productId) {
        return null;
    }

    @Override
    public void deleteProductById(Integer productId) {
        productRepository.deleteById(productId);

    }
}
