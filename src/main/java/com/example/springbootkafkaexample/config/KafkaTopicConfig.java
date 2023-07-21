package com.example.springbootkafkaexample.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

/*
    Java Class to configure a topic in a Kafka cluster.
 */
@Configuration
public class KafkaTopicConfig {

    //create topic named "myTopic"
    @Bean
    public NewTopic myTopic() {
        return TopicBuilder
                .name("myTopic")
                .build();
    }

    //topic named myJSONTopic
    @Bean
    public NewTopic myJSONTopic() {
        return TopicBuilder
                .name("myJSONTopic")
                .build();
    }

}