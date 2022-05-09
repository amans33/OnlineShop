package com.example.demo.service;

import com.example.demo.data.Inventory;
import com.example.demo.data.InventoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
@AllArgsConstructor
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;

    @Override
    public Inventory createInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    @Override
    public List<Inventory> getInventoryList() {
        return inventoryRepository.findAll();
    }

    @Override
    public Inventory getInventoryById(BigInteger id) {
        return inventoryRepository.findById(id).get();
    }

    @Override
    public List<Inventory> getInventoryByStoreId(BigInteger storeId) {
        return inventoryRepository.getInventoryByStoreId(storeId);
    }
}
