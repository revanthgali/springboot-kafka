package com.codex.kafkaconsumer.service;

import com.codex.kafkaconsumer.model.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(
            topics = "kafka-codex-producer",
            groupId = "codex_grp_id",
            containerFactory = "userKafkaListenerFactory"
    )
    public void listenWithHeaders(
            @Payload User message,
            @Header("kafka_receivedPartitionId") int partition) {

        System.out.println("Received Message: " + message);
        System.out.println("from partition: " + partition);
    }
}
