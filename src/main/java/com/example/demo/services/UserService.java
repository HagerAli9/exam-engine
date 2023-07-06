package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.database.entity.User;
import com.example.demo.database.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User FindByUserName(String userName){
        return userRepository.findByUsername(userName);

    }
    
}