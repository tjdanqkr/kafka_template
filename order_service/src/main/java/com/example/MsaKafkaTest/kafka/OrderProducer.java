package com.example.MsaKafkaTest.kafka;

import com.example.MsaKafkaTest.dto.JoinTable;
import com.example.MsaKafkaTest.dto.JoinTableEvent;
import com.example.MsaKafkaTest.dto.Order;
import com.example.MsaKafkaTest.dto.OrderEvent;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderProducer {

    @Value("${spring.kafka.topic.order_topics}")
    private String order_topic;
    @Value("${spring.kafka.topic.user_topics}")
    private String user_topics;
    private KafkaTemplate<String, OrderEvent> kafkaTemplate;
    private KafkaTemplate<String, JoinTableEvent> kafkaTemplateJoin;
    public OrderProducer(
            KafkaTemplate<String, OrderEvent> kafkaTemplate,
            KafkaTemplate<String, JoinTableEvent> kafkaTemplateJoin
    ){
        this.kafkaTemplate =kafkaTemplate;
        this.kafkaTemplateJoin = kafkaTemplateJoin;
    }

    public void sendMessage(OrderEvent event){
        log.info(String.format("Order event -> %s", event.toString()));

        Message<OrderEvent> message = MessageBuilder
                .withPayload(event)
                .setHeader(KafkaHeaders.TOPIC,order_topic)
                .build();
        kafkaTemplate.send(message);
    }

    public void sendMessageJoin(JoinTableEvent event){
        log.info(String.format("Join event -> %s", event.toString()));


        Message<JoinTableEvent> message = MessageBuilder
                .withPayload(event)
                .setHeader(KafkaHeaders.TOPIC,order_topic)
                .build();
        kafkaTemplateJoin.send(message);
    }

}
