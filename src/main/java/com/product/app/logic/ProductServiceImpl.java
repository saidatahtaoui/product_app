package com.product.app.logic;

import com.product.app.dataaccess.dto.ProductDTO;
import com.product.app.dataaccess.entities.Product;
import com.product.app.exception.ProductNotFoundException;
import com.product.app.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = modelMapper.map(productDTO, Product.class);
        Product createdProduct = productRepository.save(product);
        log.info("Product with - {} just created at {} ", createdProduct.getName(), createdProduct.getCreatedAt());
        return modelMapper.map(createdProduct, ProductDTO.class);
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductDTO> productDTOS = products.stream().map(p -> modelMapper.map(p, ProductDTO.class)).collect(Collectors.toList());
        return productDTOS;
    }

    @Override
    public ProductDTO getProductById(Integer productId) {
        ProductDTO productDTO = null;
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (optionalProduct.isPresent()) {
            productDTO = modelMapper.map(optionalProduct.get(), ProductDTO.class);
        } else {
            log.error("product with id {}  not found", productId);
            throw new ProductNotFoundException("product not found");
        }
        return productDTO;
    }

    @Override
    public ProductDTO updateProduct(ProductDTO productDTO, Integer productId) {
        ProductDTO result = null;
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (optionalProduct.isPresent()) {

            Product product = optionalProduct.get();

            log.info("update started for product with {} name", product.getName());

            product.setName(productDTO.getName());
            product.setCode(productDTO.getCode());
            product.setDescription(productDTO.getDescription());
            product.setCategory(productDTO.getCategory());
            product.setInternalReference(productDTO.getInternalReference());
            product.setPrice(productDTO.getPrice());
            product.setImage(productDTO.getImage());
            product.setQuantity(productDTO.getQuantity());
            product.setRating(productDTO.getRating());
            product.setCreatedAt(productDTO.getCreatedAt());
            product.setUpdatedAt(productDTO.getUpdatedAt());
            product.setShellId(productDTO.getShellId());

            Product product1 = productRepository.save(product);
            result = modelMapper.map(product1, ProductDTO.class);

            log.info("update finished for product with {} name successfully", product.getName());

        } else {
            log.error("product with id {}  not found, cannot proceed the update", productId);
            throw new ProductNotFoundException("product not found");
        }
        return result;
    }

    @Override
    public void deleteProductById(Integer productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (optionalProduct.isPresent()) {
            productRepository.deleteById(productId);
            log.info("product with Id {} deleted successfuly", productId);
        }else {
            log.error("product with id {}  not found, cannot proceed the delete", productId);
            throw new ProductNotFoundException("product not found");
        }

    }
}
