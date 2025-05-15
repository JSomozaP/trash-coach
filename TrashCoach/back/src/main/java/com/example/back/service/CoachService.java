package com.example.back.service;

import com.example.back.model.Coach;
import com.example.back.repository.CoachRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class CoachService {
    private final BackService backService;
    private final CoachRepository coachRepository;
    private final Random random = new Random();

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

    public List<String> getMessages() {
        Integer ratio = (Math.round(backService.calculRatio() / 10.0f) * 10) / 10;
        List<String> messages;
        messages = coachRepository.getMessage(ratio);
        return messages;
    }

    public String getMessage() {
        List<String> messages = getMessages();
        int index = random.nextInt(messages.size());
        return messages.get(index);
    }
}
