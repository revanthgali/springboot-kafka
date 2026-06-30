package com.codex.kafkaconsumer.controller;

import com.codex.kafkaconsumer.model.User;
import com.codex.kafkaconsumer.service.KafkaConsumer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1")
public class KafkaController {
    // Controller methods will be added here

    private final KafkaConsumer kafkaConsumer;

    public KafkaController(KafkaConsumer kafkaConsumer) {
        this.kafkaConsumer = kafkaConsumer;
    }

}
