package com.example.demo.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, BigInteger> {
    List<Product> findByProductNameContainingIgnoreCase(@Param("name") String name);
}
