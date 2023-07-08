package com.example.testorder.dtos;

import com.example.testorder.models.Order;
import jakarta.persistence.*;
import lombok.Data;

@Data
public class OrderDetailsResponseDto {
    private int id;
    private String serialNumber;
    private String productName;
    private Order orderId;
    private int quantity;
}
