package com.example.demo.database.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.database.entity.Question;
import com.example.demo.database.entity.User;

import java.util.List;


@Repository
public interface QuestionRepository extends MongoRepository<Question,String> {

    public List<Question>  findByCreatedBy(User created_by);
    
}