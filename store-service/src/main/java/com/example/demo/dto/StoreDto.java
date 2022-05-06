package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StoreDto {

    private String storeName;
    private String addressLine1;
    private String addressLine2;
    private Integer pinCode;
    private String city;
    private String state;
    private String country;
    private String phone;
    private String email;
}
