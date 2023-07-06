package com.example.demo.database.entity;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Document(collection = "examInstance")
public class ExamInstance {
    @Id
    String _id;
    ExamDefenition examDefinition;
    // @DBRef
    // ExamDefenition examDefinition;
    LocalDateTime startedTime;
    LocalDateTime endTime;
    int duration;
    int mark;
    LocalDateTime completionTime;
    String generatedLink;
    // @DBRef
    // instructor createdBy;
    String createdBy;
    // @DBRef
    // Student takenBy;
    String TakenBy;
    int status;
    List<AnswerdQuestion> answerdQuestions=new ArrayList();
    //Student[] students;
    // 6473d6340e97bfad0194979c

   
    // public void calcDuration(){

    //     for(int i = 0 ; i < answerdQuestions.length ; i++){

    //         duration+=answerdQuestions[i].displayTime;

    //     }
        
  //  }

  public void setAnswerdQuestions(List<Question> questions){

    for (Question question : questions) {
      AnswerdQuestion answerdQuestion =new AnswerdQuestion();
      answerdQuestion.question=question;
      answerdQuestions.add(answerdQuestion);

      
    }

  }

  public void setMark(int mark){
    for (AnswerdQuestion answerdQuestion : this.answerdQuestions) {
      this.mark+=answerdQuestion.mark;
      
    }
  }

    
    
}