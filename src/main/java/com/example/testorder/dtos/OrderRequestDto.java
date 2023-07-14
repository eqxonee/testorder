package com.example.testorder.dtos;

import lombok.Data;

@Data
public class OrderRequestDto {
    private Long id;
    private String customerName;
    private String customerAddress;
    private int totalPrice;
}
