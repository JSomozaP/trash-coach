package com.example.web.controller;

import com.example.web.model.User;
import com.example.web.model.DTO.Ratio;
import com.example.web.service.WebService;
import com.example.web.service.form.UserForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@Controller
public class WebController {
    private final WebService webService;

    public WebController(WebService webService) {
        this.webService = webService;
    }

    @GetMapping("/")
    public ModelAndView showHomePage(Model model) {
        List<User> trashList = webService.getAllTrash();
        model.addAttribute("trashList", trashList);
        List<String> trashCoachmsg = webService.getCoachMessages();
        model.addAttribute("trashCoachmsg", trashCoachmsg);
        Ratio ratio = webService.getRatio();
        model.addAttribute("ratio", ratio);
        return new ModelAndView("index", "trashForm", new UserForm());
    }

    @PostMapping("/add")
    public String addTrash(UserForm trash) {
        webService.addTrash(trash);
        return "redirect:/";
    }

    @PostMapping("/delete/{id}")
    public String deleteTrash(@PathVariable Long id) {
        webService.deleteTrash(id);
        return "redirect:/";
    }
}
