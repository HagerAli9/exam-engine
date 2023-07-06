package com.example.demo.config;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaLisitner {

    @KafkaListener(topics = "hagar" , groupId = "id")
    void listener(String data){
        System.out.println(data);
    }

    
    
}