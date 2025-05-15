package com.example.back.controller;

import com.example.back.model.Coach;
import com.example.back.model.User;
import com.example.back.service.BackService;
import com.example.back.service.CoachService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coach")
public class CoachController {
    private final CoachService coachService;

    public CoachController(CoachService coachService) {
        this.coachService = coachService;
    }

    @GetMapping("/all")
    public List<Coach> allMessages() {
        return coachService.all();
    }

    @PostMapping("/add")
    public Coach ajoutMessages(@RequestBody Coach coach){
        return coachService.add(coach);
    }

    @PostMapping("/message")
    public String getMessage() {
        return coachService.getMessage();
    }

    @PostMapping("/messages")
    public List<String> getMessages() {
        return coachService.getMessages();
    }
}
