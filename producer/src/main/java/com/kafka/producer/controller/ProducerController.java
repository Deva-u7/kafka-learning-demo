package com.kafka.producer.controller;

import com.kafka.producer.dto.MessageDTO;
import com.kafka.producer.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProducerController {
    @Autowired
    ProducerService producerService;
    @GetMapping("api/produce/{message}")
    ResponseEntity<String> sendMessage(@PathVariable String message){
        producerService.sendMessage(message);
        return ResponseEntity.ok("Message send to consumer....");
    }


    @GetMapping("api/produce/message")
    ResponseEntity<String> produceMessage(@RequestBody MessageDTO message){
        producerService.produceMessage(message);
        return ResponseEntity.ok("Message send to consumer....");
    }
}
