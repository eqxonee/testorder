package com.example.testorder.dtos;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailsRequestDto {
    private int id;
    private String serialNumber;
    private String productName;
    private int orderId;
    private int quantity;
}
