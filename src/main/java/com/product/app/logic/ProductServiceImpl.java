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

import javax.swing.text.html.Option;
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
            Product product = modelMapper.map(productDTO,Product.class);
            Product createdProduct = productRepository.save(product);
            log.info("Product with - {} just created at {} ", createdProduct.getName(), createdProduct.getCreatedAt());
            return modelMapper.map(createdProduct, ProductDTO.class);
        }

    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> products= productRepository.findAll();
        List<ProductDTO> productDTOS=products.stream().map( p -> modelMapper.map(p, ProductDTO.class)).collect(Collectors.toList());
        return productDTOS ;
    }

    @Override
    public ProductDTO getProductById(Integer productId) {
        ProductDTO productDTO= null;
        Optional<Product> optionalProduct=productRepository.findById(productId);
        if(optionalProduct.isPresent()){
            productDTO=modelMapper.map(optionalProduct.get(), ProductDTO.class);
        }else{
            log.error("product with id {}  not found" , productId);
            throw new ProductNotFoundException("product not found");
        }
        return productDTO;
    }

    @Override
    public ProductDTO updateProduct(ProductDTO product, Integer productId) {
        return null;
    }

    @Override
    public void deleteProductById(Integer productId) {
        productRepository.deleteById(productId);

    }
}
