package com.example.MsaKafkaTest.kafka;

import com.example.MsaKafkaTest.dto.*;
import com.example.MsaKafkaTest.repository.OrderRepository;
import com.example.MsaKafkaTest.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class JoinTableConsumer {

    @Autowired
    UserRepository userRepository;
    @Autowired
    OrderRepository orderRepository;

    @KafkaListener(
            topics = "order_topics",
            groupId = "stock"
    )
    public void consume(JoinTableEvent event){
        log.info(event.toString());
        JoinTable joinTable = event.getJoinTable();
        User user = new User();
        user.setAge(joinTable.getAge());
        user.setId(joinTable.getUserId());
        user.setName(joinTable.getUserName());
        Order order = new Order();
        order.setOrderId(joinTable.getOrderId());
        order.setUserId(joinTable.getUserId());
        order.setName(joinTable.getName());
        order.setQty(joinTable.getQty());
        orderRepository.save(order);
        userRepository.save(user);
        log.info(String.format("Join event recieved in stock service -> %s",event.toString()));
    }
}
