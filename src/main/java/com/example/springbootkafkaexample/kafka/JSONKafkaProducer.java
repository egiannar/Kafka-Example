package com.example.springbootkafkaexample.kafka;

import com.example.springbootkafkaexample.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

/**
 *  This JAVA Kafka Producer class sends messages to the broker as a JSON
 */

@Service
public class JSONKafkaProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(JSONKafkaProducer.class);

    private KafkaTemplate<String, User> kafkaTemplate;

    public JSONKafkaProducer(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(User data) {
        //sends a user object as json
        LOGGER.info(String.format("Message sent -> " + data.toString()));

        Message<User> message = MessageBuilder
                .withPayload(data)
                .setHeader(KafkaHeaders.TOPIC, "myJSONTopic")
                .build();

        kafkaTemplate.send(message);
    }

}
