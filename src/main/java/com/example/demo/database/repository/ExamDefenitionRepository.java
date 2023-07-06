package com.example.demo.database.repository;
import com.example.demo.database.entity.ExamDefenition;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamDefenitionRepository extends MongoRepository<ExamDefenition, String> {
    public List<ExamDefenition> findByCreatedBy(String createdBy);
}