package com.example.back.service;

import com.example.back.model.DTO.Ratio;
import com.example.back.model.User;
import com.example.back.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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

    public void delete(Long userid) {
        userRepository.delete(userRepository.getReferenceById(userid));
    }

    public Integer calculRatio() {
        LocalDate today = LocalDate.now();
        LocalDateTime start = today.atStartOfDay();         // 00:00:00
        LocalDateTime end = today.atTime(LocalTime.MAX);

        Integer ratio;

        Integer positif = userRepository.countPositif(start, end);
        Integer all = userRepository.countAll(start, end);
        if (all == 0) {
            ratio = 50;
        } else {
            ratio = (positif * 100) / all;
        }
        return ratio;
    }

    public Ratio getRatio() {
        LocalDate today = LocalDate.now();
        LocalDateTime start = today.atStartOfDay();         // 00:00:00
        LocalDateTime end = today.atTime(LocalTime.MAX);

        Ratio ratio = new Ratio();

        ratio.setPositive(userRepository.countPositif(start, end));
        ratio.setNegative(userRepository.countNegatif(start, end));

        return ratio;
    }
}
