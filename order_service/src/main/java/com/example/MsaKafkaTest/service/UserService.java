package com.example.MsaKafkaTest.service;

import com.example.MsaKafkaTest.dto.User;
import com.example.MsaKafkaTest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }
}
