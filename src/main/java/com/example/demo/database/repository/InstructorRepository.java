package com.example.demo.database.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.database.entity.Instructor;


public interface InstructorRepository extends MongoRepository<Instructor, String>{
    
}