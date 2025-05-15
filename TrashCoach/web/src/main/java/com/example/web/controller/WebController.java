package com.example.web.controller;

import com.example.web.service.WebService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
    public ModelAndView test(Model model) {
//        [Model] [nom] = webService.[fonction()];
//        model.addAttribute("[nom]", [nom]);

//        webService.test();
        return new ModelAndView("[nom du fichier html]");
//        return new ModelAndView("[nom du fichier html]", "[nom formulaire]", new [nom model formulaire]());
    }

//    @PostMapping("/")
//    public String test2(Model model, @ModelAttribute("[nom formulaire]") [nom model formulaire] [nom])
//    {
////        Ta Fonction
//        return "";
//    }
}
