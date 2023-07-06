package com.example.demo.database.entity;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Index;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Document(collection="question")
public class Question {
    @Id
    String _id;
    String name;
    String level_id;
    String category;
    int displayTime;
    int mark;
    Duration displayDuration=Duration.ofSeconds(displayTime);
    List<Integer> correct_answer_ids=new ArrayList() ;
   // String correctAnswer;
    @DBRef
    User createdBy;
    //instructor created_by;
    LocalDateTime created_at;
   List< Answer> answers;

  public List< Answer> addAnswer(Answer answer){
    this.answers.add(answer);
    System.out.println("aded");
    return answers;
   }
   
  public List<Answer> deleteAnswer(Answer answer) {
       this.answers.remove(answer);
       return answers;
   }
   
   public void setCorrect_answer_ids(){

    answers.forEach((n)->{
      if(n.isRight==1) correct_answer_ids.add(answers.indexOf(n));
    }); 


   }



    
}