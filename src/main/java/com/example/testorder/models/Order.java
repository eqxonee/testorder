package com.example.testorder.models;


import com.example.testorder.dtos.OrderDetailsAntiRecDto;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name =  "orders")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "customer_address")
    private String customerAddress;

    @Column(name = "total_price")
    private int totalPrice;

    @Column(name = "datetime")
    private Date dateTime;


}
