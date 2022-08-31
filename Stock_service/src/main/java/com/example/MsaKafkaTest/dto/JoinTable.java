package com.example.MsaKafkaTest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JoinTable {
    private Integer orderId;
    private String name;
    private int qty;
    private double price;
    private String userId;
    private String userName;
    private Integer age;
}
