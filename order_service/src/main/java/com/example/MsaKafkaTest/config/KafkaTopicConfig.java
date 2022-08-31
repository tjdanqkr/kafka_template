package com.example.MsaKafkaTest.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;


@Configuration
public class KafkaTopicConfig {
    @Value("${spring.kafka.topic.user_topics}")
    private String user_topic;
    @Value("${spring.kafka.topic.order_topics}")
    private String order_topic;
    @Bean
    public KafkaAdmin.NewTopics topics(){
        return  new KafkaAdmin.NewTopics(
                TopicBuilder.name(user_topic)
                .build(),
                TopicBuilder.name(order_topic)
                .build());
    }
//    @Bean
//    public NewTopic makeUserTopic(){
//        return TopicBuilder.name(user_topic)
//                .build();
//    }
//    @Bean
//    public NewTopic makeOrderTopic(){
//        return TopicBuilder.name(order_topic)
//                .build();
//    }
}
