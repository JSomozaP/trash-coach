package com.example.back.service;

import com.example.back.model.Coach;
import com.example.back.model.CoachCustom;
import com.example.back.model.User;
import com.example.back.repository.CoachCustomRepository;
import com.example.back.repository.CoachRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
public class CoachService {
    private final BackService backService;
    private final CoachRepository coachRepository;
    private final CoachCustomRepository coachCustomRepository;
    private final Random random = new Random();
    private final Map<String, List<String>> tagKeywords;
    private final Map<String, Integer> categoryCodes = Map.of(
            "procrastination", 1,
            "excuse", 2,
            "bouffe", 3,
            "réussite", 4
    );

    public CoachService(BackService backService, CoachRepository coachRepository, CoachCustomRepository coachCustomRepository) {
        this.backService = backService;
        this.coachRepository = coachRepository;
        this.coachCustomRepository = coachCustomRepository;

        tagKeywords = new HashMap<>();
        tagKeywords.put("procrastination", List.of("tiktok", "youtube", "rien", "scroll", "traîner", "flemme"));
        tagKeywords.put("excuse", List.of("pas le temps", "fatigué", "pluie", "malade"));
        tagKeywords.put("bouffe", List.of("croissant", "burger", "pizza", "fast-food", "manger", "snack"));
        tagKeywords.put("réussite", List.of("sport", "étude", "code", "clean", "productif"));
    }

    public List<Coach> all() {
        return coachRepository.findAll();
    }

    public Coach add(Coach coach) {
        return coachRepository.save(coach);
    }

    public CoachCustom addCustom(CoachCustom coach) {
        return coachCustomRepository.save(coach);
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

    public List<String> getCustomMessages() {
        Integer ratio = (Math.round(backService.calculRatio() / 10.0f) * 10) / 10;
        List<String> messages = coachRepository.getMessage(ratio);
        List<String> rareMessages = coachRepository.getMessage(ratio + 20);
        List<User> userPrompt = backService.all();


        Map<String, Integer> categoryPoints = new HashMap<>();
        for (String category : tagKeywords.keySet()) {
            categoryPoints.put(category, 0);
        }

        for (User user : userPrompt) {
            String msgLower = user.getText().toLowerCase();
            for (Map.Entry<String, List<String>> entry : tagKeywords.entrySet()) {
                String category = entry.getKey();
                for (String keyword : entry.getValue()) {
                    if (msgLower.contains(keyword)) {
                        categoryPoints.put(category, categoryPoints.get(category) + 1);
                        break;
                    }
                }
            }
        }

        String dominantCategory = categoryPoints.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("default");

        Integer categorieCode = categoryCodes.getOrDefault(dominantCategory, 0);

        System.out.printf("categorie Code", categorieCode);

        messages.addAll(coachCustomRepository.getMessages(ratio,categorieCode));
        
        if (rareMessages.size() != 0) {
            int luck = random.nextInt(1, 21);
            if (luck == 20) {
                return rareMessages;
            }
        }
        if (messages.size() == 0) {
            messages.add("T'as de la chance. J'ai rien à te dire pour l'instant.");
        }
        return messages;
    }
}
