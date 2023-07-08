package com.example.testorder.dtos;

import lombok.Data;

import java.util.Date;

@Data
public class OrderResponseDto {
    private int id;
    private String customerName;
    private String customerAddress;
    private int totalPrice;
    private Date dateTime;
}
