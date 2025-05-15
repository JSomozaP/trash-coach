package com.example.back.service;

import com.example.back.model.User;
import com.example.back.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BackService {
    private final UserRepository userRepository;

    public BackService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> all(){
        return userRepository.findAll();
    }

    public User add(User user){
        return userRepository.save(user);
    }

    public Integer calculRatio() {
        Integer positif = userRepository.countPositif();
        return positif;
    }
}
