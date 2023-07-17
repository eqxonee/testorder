package com.example.testorder.dtos;

import com.example.testorder.models.OrderDetails;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderGetAllDto {
    private Long id;
    private String customerName;
    private String customerAddress;
    private int totalPrice;
    private Date dateTime;
    private List<OrderDetails> orderDetails;
}
