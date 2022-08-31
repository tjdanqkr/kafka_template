package com.example.MsaKafkaTest.controller;

import com.example.MsaKafkaTest.dto.JoinTable;
import com.example.MsaKafkaTest.dto.JoinTableEvent;
import com.example.MsaKafkaTest.dto.Order;
import com.example.MsaKafkaTest.dto.OrderEvent;
import com.example.MsaKafkaTest.kafka.OrderProducer;
import com.example.MsaKafkaTest.kafka.UserProducer;
import com.example.MsaKafkaTest.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
    @Autowired
    private OrderProducer orderProducer;
    @Autowired
    private UserProducer userProducer;
    @Autowired
    private OrderService orderService;
    @PostMapping("")
    public String placeOrder(@RequestBody Order order){
        order.setUserId(UUID.randomUUID().toString());

        OrderEvent orderEvent = new OrderEvent();
        orderEvent.setStatus("PENDING");
        orderEvent.setMessage("order status is in pending state");
        orderEvent.setOrder(order);

        orderProducer.sendMessage(orderEvent);

        return "Order placed successfully....";
    }
    @GetMapping
    public List<Order> findAll(){
        return orderService.findAll();
    }

    @PostMapping("/join")
    public String placeTable(@RequestBody JoinTable joinTable){
        joinTable.setUserId(UUID.randomUUID().toString());
        joinTable.setAge(20);
        joinTable.setUserName("kim");

        JoinTableEvent joinTableEvent = new JoinTableEvent();
        joinTableEvent.setStatus("PENDING");
        joinTableEvent.setMessage("joinTableEvent status is in pending state");
        joinTableEvent.setJoinTable(joinTable);

        orderProducer.sendMessageJoin(joinTableEvent);

        return "Order placed successfully....";
    }
}
