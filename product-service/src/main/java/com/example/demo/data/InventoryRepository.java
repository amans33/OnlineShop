package com.example.demo.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, BigInteger> {
    List<Inventory> getInventoryByStoreId(BigInteger storeId);
}
