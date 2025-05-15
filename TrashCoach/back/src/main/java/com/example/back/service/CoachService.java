package com.example.back.service;

import com.example.back.model.Coach;
import com.example.back.repository.CoachRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoachService {
    private final BackService backService;
    private final CoachRepository coachRepository;

    public CoachService(BackService backService, CoachRepository coachRepository) {
        this.backService = backService;
        this.coachRepository = coachRepository;
    }

    public List<Coach> all() {
        return coachRepository.findAll();
    }

    public Coach add(Coach coach) {
        return coachRepository.save(coach);
    }

    public String getMessage() {
        Integer ratio = backService.calculRatio();
        if (ratio > 0) {
            return "yes";
        } else {
            return "coucou";
        }
    }
}
