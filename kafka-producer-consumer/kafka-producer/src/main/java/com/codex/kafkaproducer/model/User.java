package com.codex.kafkaproducer.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
public class User {

    public User(){

    }

    private String name;
    private String department;
    private long salary;
}
