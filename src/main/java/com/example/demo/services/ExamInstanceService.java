package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.database.entity.ExamDefenition;
import com.example.demo.database.entity.ExamInstance;
import com.example.demo.database.repository.ExamInstanceRepository;

@Service
public class ExamInstanceService {
    @Autowired
    private ExamInstanceRepository examInstanceRepository;
    
    @Autowired
    KafkaTemplate<String,String>kafkaTemplate;

    
 public void deleteAll(){
      examInstanceRepository.deleteAll();
    }

    public ExamInstance createExamInstance(ExamInstance examInstance){
        System.out.println(examInstance);
        examInstance.setAnswerdQuestions(examInstance.getExamDefinition().getQuestions());
        System.out.println(examInstance);
        return examInstanceRepository.save(examInstance);
        
    }
    public List<ExamInstance> findByCreatedBy(String createdBy){
        return examInstanceRepository.findByCreatedBy(createdBy);

    }
    public List<ExamInstance> findByTakenBy(String takenBy){
        return examInstanceRepository.findByTakenBy(takenBy);

    }
    
     public List<ExamInstance> createExamInstances(ExamInstance examInstance,String [] students){
        List<ExamInstance> examInstances=new ArrayList<>();
            for (int i=0;i<students.length;i++){
            examInstance.setTakenBy(students[0]);
            examInstances.add( examInstanceRepository.save(examInstance));
            kafkaTemplate.send("hagar", "hello "+examInstance.getTakenBy()+"you have a new exam");
            }
            return examInstances;
     }

     public ExamInstance putExamInstance(ExamInstance examInstance){
         System.out.println(examInstance);
        examInstance.setMark(0);
        System.out.println(examInstance.getMark());
        kafkaTemplate.send("hagar", "hello "+examInstance.getCreatedBy()+
        " student "+examInstance.getTakenBy()+" has taken your exam");
        return examInstanceRepository.save(examInstance);
    }


   public List<ExamInstance> findAllExamInstances() {
      return examInstanceRepository.findAll();
   }

    public ExamInstance findExamInstance(String id) {
       return  examInstanceRepository.findById(id).orElseThrow(() -> new NoSuchElementException(
               String.format(
                       "question with id [%d] was not found!",
                       id)));
    }
    
}