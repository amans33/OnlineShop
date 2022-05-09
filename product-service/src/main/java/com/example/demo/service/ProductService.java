package com.example.demo.service;

import com.example.demo.data.Product;
import com.example.demo.dto.ProductDto;

import java.math.BigInteger;
import java.util.List;

public interface ProductService {

    Product createProduct(Product product);

    List<Product> getProducts();

    Product getProductById(BigInteger id);

    List<Product> searchProductByProductName(String productName);

}
