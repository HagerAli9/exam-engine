package com.example.demo.database.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.database.entity.User;
import java.util.List;


@Repository
public interface UserRepository extends MongoRepository<User,String> {

    public User findByUsername(String username);

    
}