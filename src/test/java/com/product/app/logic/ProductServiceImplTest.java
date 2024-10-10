package com.product.app.logic;

import com.product.app.dataaccess.dto.ProductDTO;
import com.product.app.dataaccess.entities.Product;
import com.product.app.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {
    @InjectMocks
    ProductServiceImpl productService;
    @Mock

    ProductRepository productRepository;
    @Mock
    private ModelMapper modelMapper;

    private Product product;
    private ProductDTO productDTO;

    @BeforeEach
    void setUp() {
        product = new Product();
        product.setId(1);
        product.setName("Product A");
        product.setCode("PA123");
        product.setDescription("Description of Product A");

        productDTO = new ProductDTO();
        productDTO.setId(1);
        productDTO.setName("Product A");
        productDTO.setCode("PA123");
        productDTO.setDescription("Description of Product A");
    }

    @Test
    void createProduct() {
        // Arrange
        when(modelMapper.map(productDTO, Product.class)).thenReturn(product);
        when(productRepository.save(any(Product.class))).thenReturn(product);
        when(modelMapper.map(product, ProductDTO.class)).thenReturn(productDTO);

        // Act
        ProductDTO createdProduct = productService.createProduct(productDTO);

        // Assert
        assertNotNull(createdProduct);
        assertEquals(productDTO.getName(), createdProduct.getName());
        verify(productRepository, times(1)).save(product);
    }


        @Test
        void getAllProducts() {
            // Arrange
            when(productRepository.findAll()).thenReturn(Arrays.asList(product));
            when(modelMapper.map(product, ProductDTO.class)).thenReturn(productDTO);

            // Act
            List<ProductDTO> productList = productService.getAllProducts();

            // Assert
            assertEquals(1, productList.size());
            verify(productRepository, times(1)).findAll();

    }

    @Test
    void getProductById() {
    }

    @Test
    void updateProduct() {
    }

    @Test
    void deleteProductById() {
    }
}