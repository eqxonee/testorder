package com.example.testorder.dtos;

import com.example.testorder.models.Order;
import lombok.Data;

@Data
public class OrderDetailsAntiRecDto {
    private int id;
    private String serialNumber;
    private String productName;
    private int quantity;
}
