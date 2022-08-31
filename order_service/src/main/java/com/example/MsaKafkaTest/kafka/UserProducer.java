package com.example.MsaKafkaTest.kafka;

import com.example.MsaKafkaTest.dto.OrderEvent;
import com.example.MsaKafkaTest.dto.UserEvent;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserProducer {
    @Value("${spring.kafka.topic.user_topics}")
    private String user_topic;
    private KafkaTemplate<String, UserEvent> kafkaTemplate;
    public UserProducer(KafkaTemplate<String, UserEvent> kafkaTemplate){
        this.kafkaTemplate =kafkaTemplate;

    }
    public void sendMessage(UserEvent event){
        log.info(String.format("User event -> %s", event.toString()));

        Message<UserEvent> message = MessageBuilder
                .withPayload(event)
                .setHeader(KafkaHeaders.TOPIC,user_topic)
                .build();
        kafkaTemplate.send(message);
    }
}
