package com.example.demo.service;

import com.example.demo.data.Inventory;

import java.math.BigInteger;
import java.util.List;

public interface InventoryService {

    Inventory createInventory(Inventory inventory);

    List<Inventory> getInventoryList();

    Inventory getInventoryById(BigInteger id);

    List<Inventory> getInventoryByStoreId(BigInteger storeId);

}
