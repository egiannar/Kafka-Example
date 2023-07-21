package com.example.springbootkafkaexample.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    //log messages
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

    /**
     * key-value pair: -First argument the name of the topic writing.
     * -Second argument the message sent.
     */
    private KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    //method to send message to the topic and logging the message
    public void sendMessage(String message) {
        LOGGER.info(String.format("Message sent " + message));
        kafkaTemplate.send("myTopic", message);
    }

}