package com.kafka.subscriber.service;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;



@Service
@Slf4j
public class EventConsumer {
    Logger log =  LoggerFactory.getLogger(EventConsumer.class);
    @KafkaListener(topics = "test-demo",groupId = "demo")
    public void consumeEvents( String message) {
        log.info("consumer consume the events {} ",message);
    }    @KafkaListener(topics = "test-demo1",groupId = "demo")
    public void consumeEvents1( Object message) {
        log.info("consumer consume the events {} ",message.toString());
    }
}



