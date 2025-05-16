package com.example.back.controller;

import com.example.back.model.User;
import com.example.back.service.BackService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BackController {
    private final BackService backService;

    public BackController(BackService backService) {
        this.backService = backService;
    }

    @GetMapping("/all")
    public List<User> allInfos() {
        return backService.all();
    }

    @PostMapping("/add")
    public User ajoutInfo(@RequestBody User user){
        return backService.add(user);
    }

    @PostMapping("/delete")
    public void deleteInfo(@RequestBody Long userid) {
        backService.delete(userid);
    }

}
