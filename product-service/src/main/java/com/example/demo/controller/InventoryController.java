package com.example.demo.controller;


import com.example.demo.data.Inventory;
import com.example.demo.dto.InventoryDto;
import com.example.demo.service.InventoryService;
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
@RequestMapping("inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    @PostMapping(path = "/add", consumes = { MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Void> createInventory(@RequestBody InventoryDto inventoryDto) {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT);
        Inventory inventory = mapper.map(inventoryDto, Inventory.class);
        inventoryService.createInventory(inventory);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Inventory>> getInventoryList() {
        return ResponseEntity.status(HttpStatus.OK).body(inventoryService.getInventoryList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<InventoryDto> getInventoryById(@PathVariable BigInteger id) {
        InventoryDto inventoryDto = new ModelMapper().map(inventoryService.getInventoryById(id), InventoryDto.class);
        return ResponseEntity.status(HttpStatus.OK).body(inventoryDto);
    }

}
