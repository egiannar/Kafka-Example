package com.example.springbootkafkaexample.controller;

import com.example.springbootkafkaexample.kafka.JSONKafkaProducer;
import com.example.springbootkafkaexample.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class JSONMessageController {

    private JSONKafkaProducer jsonKafkaProducer;

    public JSONMessageController(JSONKafkaProducer jsonKafkaProducer) {
        this.jsonKafkaProducer = jsonKafkaProducer;
    }

    //localhost:8080/api/v1/kafka/publish?message=hello world
    //message is the query parameter
    //@RequestParam retrieves value from the url as json
    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody User user) {
        jsonKafkaProducer.sendMessage(user);
        return new ResponseEntity<>("JSON Message sent to kafka topic", HttpStatus.OK);
    }

}
