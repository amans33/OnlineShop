package com.example.demo.service;

import com.example.demo.data.Store;
import com.example.demo.data.StoreRepository;
import com.example.demo.dto.StoreDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
@AllArgsConstructor
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;

    @Override
    public Store createStore(Store store) {
        return storeRepository.save(store);
    }

    @Override
    public List<Store> getStores() {
        return storeRepository.findAll();
    }

    @Override
    public Store getStoreById(BigInteger id) {
        return storeRepository.findById(id).get();
    }

    @Override
    public List<Store> getStoresByPinCode(Integer pinCode) {
        return storeRepository.getStoresByPinCode(pinCode);
    }
}
