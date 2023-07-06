package com.example.demo.database.repository;

import com.example.demo.database.entity.ExamInstance;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamInstanceRepository extends MongoRepository<ExamInstance, String> {

    public List<ExamInstance> findByCreatedBy(String createdBy);
    public List<ExamInstance> findByTakenBy(String takenBy);
    
}