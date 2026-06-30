package com.codex.kafkaproducer.controller;

import com.codex.kafkaproducer.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1")
public class KafkaController {


    private final KafkaTemplate<String, User> kafkaTemplate;

    public KafkaController(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    private static final String TOPIC = "kafka-codex-producer";

    @GetMapping("/publish/{name}")
    public String postMessage(@PathVariable("name") final String name){
        User user = new User();
        user.setName(name);
        user.setDepartment("Internal");
        user.setSalary(5000000L);

        kafkaTemplate.send(TOPIC, user)
                .whenComplete((result, ex) -> {
                    if (ex == null) {
                        System.out.println("Sent successfully");
                        System.out.println(result.getRecordMetadata().offset());
                    } else {
                        System.out.println("Failed: " + ex.getMessage());
                    }
                });

        return "Message Published Successfully";
    }
}
