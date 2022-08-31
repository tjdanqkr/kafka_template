package com.example.MsaKafkaTest.service;

import com.example.MsaKafkaTest.dto.Order;
import com.example.MsaKafkaTest.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;
    public List<Order> findAll(){
        return orderRepository.findAll();
    }
}
