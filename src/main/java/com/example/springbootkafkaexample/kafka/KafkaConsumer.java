package com.example.springbootkafkaexample.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * This is a Kafka consumer, meaning consuming the messages from the broker
 */
@Service
public class KafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    //groupId is taken from the properties file
    @KafkaListener(topics = "myTopic", groupId = "myGroup")
    public void consume(String message) {
        LOGGER.info(String.format("Message received -> " + message));
    }

}