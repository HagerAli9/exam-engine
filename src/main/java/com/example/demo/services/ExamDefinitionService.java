package com.example.demo.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Service;

import com.example.demo.database.entity.ExamDefenition;
import com.example.demo.database.entity.Instructor;
import com.example.demo.database.entity.Question;
import com.example.demo.database.repository.ExamDefenitionRepository;

@Service
public class ExamDefinitionService  {
   @Autowired
   private ExamDefenitionRepository examDefenitionRepository;
    @Autowired
    private QuestionService questionService;

public ExamDefenition creatExamDefenition(ExamDefenition examDefenition){
        examDefenition.setDuration(calcDuration(examDefenition.getQuestions())); 
         System.out.println(examDefenition.getDuration());
    return examDefenitionRepository.save(examDefenition);

   }
   
public List<ExamDefenition> findByCreatedBy(String userName){
   return examDefenitionRepository.findByCreatedBy(userName);
} 

   public List<ExamDefenition> findAllExamDefinitions() {
      return examDefenitionRepository.findAll();
   }
   
    public String deleteExamDefinition(String id) {
         examDefenitionRepository.deleteById(id);
         return "deleted";
    }


     public ExamDefenition findExamDefinition(String id) {
       return  examDefenitionRepository.findById(id).orElseThrow(() -> new NoSuchElementException(
               String.format(
                       "question with id [%d] was not found!",
                       id)));
    }

    int calcDuration(List<Question> questions){
      int duration=0;
      for (Question question : questions) {
         duration+=question.getDisplayTime();
      }
      return duration;
    }

    public void deleteAll(){
      examDefenitionRepository.deleteAll();
    }
   //  int calcDuration(String[] questionsIds){

   //    List<Question> questions=questionService.findAllQuestions();
      
   //    int duration=0;
   //     for(int i = 0 ; i < questionsIds.length ; i++){
   //        for(int j = 0 ; j < questions.size() ; j++){         
   //          if(questions.get(j).get_id().equals(questionsIds[i])) {
   //             duration+=questions.get(j).getDisplayTime();
   //          }
   //      }

      
   //    }
          
//   return duration;

//     }
   // Question[] questions;
  
      



   
    
}