package com.example.demo.service;

import com.example.demo.data.Store;
import com.example.demo.dto.StoreDto;

import java.math.BigInteger;
import java.util.List;

public interface StoreService {

    Store createStore(Store store);

    List<Store> getStores();

    Store getStoreById(BigInteger id);

    List<Store> getStoresByPinCode(Integer pinCode);

}
