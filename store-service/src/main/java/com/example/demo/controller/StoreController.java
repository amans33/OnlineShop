package com.example.demo.controller;


import com.example.demo.data.Store;
import com.example.demo.dto.StoreDto;
import com.example.demo.service.StoreService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("store")
public class StoreController {

    private final StoreService storeService;

    @PostMapping(path = "/add", consumes = { MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Void> createPost(@RequestBody StoreDto storeDto) {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT);
        Store store = mapper.map(storeDto, Store.class);
        storeService.createStore(store);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Store>> getStores() {
        return ResponseEntity.status(HttpStatus.OK).body(storeService.getStores());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StoreDto> getStoreById(@PathVariable BigInteger id) {
        StoreDto storeDto = new ModelMapper().map(storeService.getStoreById(id), StoreDto.class);
        return ResponseEntity.status(HttpStatus.OK).body(storeDto);
    }

    @GetMapping("/list/pincode/{pinCode}")
    public ResponseEntity<List<StoreDto>> getStoresByPinCode(@PathVariable Integer pinCode) {
        List<Store> stores = storeService.getStoresByPinCode(pinCode);
        return ResponseEntity.status(HttpStatus.OK).body(stores.stream().map(store -> new ModelMapper().map(store,StoreDto.class)).collect(Collectors.toList()));
    }

}
