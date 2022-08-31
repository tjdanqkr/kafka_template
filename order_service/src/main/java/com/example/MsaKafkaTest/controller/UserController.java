package com.example.MsaKafkaTest.controller;


import com.example.MsaKafkaTest.dto.Order;
import com.example.MsaKafkaTest.dto.OrderEvent;
import com.example.MsaKafkaTest.dto.User;
import com.example.MsaKafkaTest.kafka.UserProducer;
import com.example.MsaKafkaTest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    UserProducer userProducer;

    @GetMapping
    public List<User> findAll(){
        return userService.findAll();
    }
    @PostMapping("")
    public String placeUser(@RequestBody User user){


        return "Order placed successfully....";
    }
}
