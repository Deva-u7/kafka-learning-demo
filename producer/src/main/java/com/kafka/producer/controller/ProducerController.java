package com.kafka.producer.controller;

import com.kafka.producer.service.ProducerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

    private  ProducerService producerService;
    @GetMapping("api/produce/{message}")
    ResponseEntity<String> sendMessage(@PathVariable String message){
        producerService.sendMessage(message);
        return ResponseEntity.ok("Message send to consumer....");
    }
}
