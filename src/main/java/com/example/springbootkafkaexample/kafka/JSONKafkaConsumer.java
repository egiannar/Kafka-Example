package com.example.springbootkafkaexample.kafka;

import com.example.springbootkafkaexample.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JSONKafkaConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(JSONKafkaConsumer.class);

    @KafkaListener(topics = "myJSONTopic", groupId = "myGroup")
    public void consume(User user) {
        LOGGER.info(String.format("JSON message received -> " + user.toString()));

    }

}