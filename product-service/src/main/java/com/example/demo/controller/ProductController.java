package com.example.demo.controller;


import com.example.demo.data.Product;
import com.example.demo.dto.ProductDto;
import com.example.demo.service.ProductService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("product")
public class ProductController {

    private final ProductService productService;

    @PostMapping(path = "/add", consumes = { MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Void> createPost(@RequestBody ProductDto productDto) {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT);
        Product product = mapper.map(productDto, Product.class);
        productService.createProduct(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Product>> getProducts() {
        return ResponseEntity.status(HttpStatus.OK).body(productService.getProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable BigInteger id) {
        ProductDto productDto = new ModelMapper().map(productService.getProductById(id), ProductDto.class);
        return ResponseEntity.status(HttpStatus.OK).body(productDto);
    }

    @GetMapping("/search")
    public ResponseEntity<List<ProductDto>> searchProductByProductName(@RequestParam String name) {
        List<Product> products = productService.searchProductByProductName(name);
        return ResponseEntity.status(HttpStatus.OK).body(products.stream().map(product -> new ModelMapper().map(product,ProductDto.class)).collect(Collectors.toList()));
    }

}
