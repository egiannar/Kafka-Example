package com.example.springbootkafkaexample.controller;

import com.example.springbootkafkaexample.kafka.KafkaProducer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/kafka")
public class MessageController {

    private KafkaProducer kafkaProducer;

    public MessageController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    //localhost:8080/api/v1/kafka/publish?message=hello world
    //message is the query parameter
    //@RequestParam retrieves value from the url
    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message) {
        //inject kafkaProducer to send the message
        kafkaProducer.sendMessage(message);
        return new ResponseEntity<>("Message sent to the topic", HttpStatus.OK);
    }


}