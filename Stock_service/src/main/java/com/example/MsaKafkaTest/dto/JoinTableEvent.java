package com.example.MsaKafkaTest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JoinTableEvent {
    private String message;
    private String status;
    private JoinTable joinTable;
}
