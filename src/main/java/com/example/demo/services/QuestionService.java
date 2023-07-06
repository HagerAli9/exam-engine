package com.example.demo.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.database.entity.Answer;
import com.example.demo.database.entity.Question;
import com.example.demo.database.entity.User;
import com.example.demo.database.repository.QuestionRepository;
import java.lang.RuntimeException;



@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    public Question createQuestion(Question question) {
        return questionRepository.save(question);
    }

    public Question findQuestion(String id) {
       return  questionRepository.findById(id).orElseThrow(() -> new NoSuchElementException(
               String.format(
                       "question with id [%d] was not found!",
                       id)));
    }

    public List<Question> findAllQuestions() {
        return questionRepository.findAll();
    }

    public String deleteQuestion(String id) {
         questionRepository.deleteById(id);
         return "deleted";
    }

    public Question addAnswer(String id,Answer answer){
        //try and carch
        Question aQuestion = questionRepository.findById(id).orElseThrow(() -> new NoSuchElementException(
                String.format(
                        "question with id [%d] was not found!",
                        id)));
        aQuestion.addAnswer(answer);
       return this.createQuestion(aQuestion);



    }

    public Question deleteAnswer(String id, Answer answer) {

        Question aQuestion = questionRepository.findById(id).orElseThrow(() -> new NoSuchElementException(
                String.format(
                        "question with id [%d] was not found!",
                        id)));
        aQuestion.deleteAnswer(answer);
        return this.createQuestion(aQuestion);

    }
    public List<Question> findByCreated_by(User created_by){
        System.out.println(created_by);
        return questionRepository.findByCreatedBy(created_by);
    }

}