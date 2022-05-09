package com.example.demo.service;

import com.example.demo.data.Product;
import com.example.demo.data.ProductRepository;
import com.example.demo.dto.ProductDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(BigInteger id) {
        return productRepository.findById(id).get();
    }

    @Override
    public List<Product> searchProductByProductName(String productName) {
        return productRepository.findByProductNameContainingIgnoreCase(productName);
    }
}
