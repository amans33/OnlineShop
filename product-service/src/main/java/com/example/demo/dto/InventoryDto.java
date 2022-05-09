package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryDto {

    private BigInteger productId;
    private BigInteger storeId;
    private Long quantity;
}
