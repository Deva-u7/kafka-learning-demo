package com.kafka.producer.service;

import com.kafka.producer.dto.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class ProducerService {
    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;
    @Autowired
    KafkaTemplate<String, Object> kafkaTemplate1;
    public void sendMessage(String message) {
        CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send("test-demo", message);
        future.whenComplete((result, ex)->{
            if (ex == null) {
                System.out.println("Sent message=[" + message +
                        "] with offset=[" + result.getRecordMetadata().offset() + "]");
            } else {
                System.out.println("Unable to send message=[" +
                        message + "] due to : " + ex.getMessage());
            }
        });
    }

    public void produceMessage(MessageDTO message) {
        CompletableFuture<SendResult<String, Object>> future = kafkaTemplate1.send("test-demo1", message);
        future.whenComplete((result, ex)->{
            if (ex == null) {
                System.out.println("Sent message=[" + message.toString() +
                        "] with offset=[" + result.getRecordMetadata().offset() + "]");
            } else {
                System.out.println("Unable to send message=[" +
                        message.toString() + "] due to : " + ex.getMessage());
            }
        });
    }
}
