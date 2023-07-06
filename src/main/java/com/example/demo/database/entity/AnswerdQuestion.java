package com.example.demo.database.entity;

import java.time.Duration;

import org.springframework.data.mongodb.core.mapping.DBRef;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AnswerdQuestion {
    Question question;
    
    int selectedAnswerId;
   // Duration displayTime;
    //Duration answerTime;
    int displayTime;
    int answerTime;
    int mark;
    
}