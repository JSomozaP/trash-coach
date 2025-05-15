package com.example.web.controller;

import com.example.web.model.User;
import com.example.web.service.WebService;
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
    public ModelAndView test(Model model) {

//        [Model] [nom] = webService.[fonction()];
//        model.addAttribute("[nom]", [nom]);
        return new ModelAndView("[nom du fichier html]");
//        return new ModelAndView("[nom du fichier html]", "[nom formulaire]", new [nom model formulaire]());
    }

@GetMapping("/")
public ModelAndView showHomePage(Model model) {
    List<User> trashList = webService.getAllTrash();
    model.addAttribute("trashList", trashList);
    return new ModelAndView("index", "trashForm", new User());

}

@PostMapping("/add")
public User addTrash(@RequestBody User trash) {
    return webService.addTrash(trash);
}

@DeleteMapping("/delete/{id}")
public void deleteTrash(@PathVariable Long id) {
    webService.deleteTrash(id);
}


@GetMapping("/stats")
public Object getTrashStats() {
    List<User> trashList = webService.getAllTrash();
    long positiveCount = trashList.stream().filter(t-> !t.isNegative()).count();
    long negativeCount = trashList.stream().filter(User::isNegative).count();

    return new Object() {
        public final long positive = positiveCount;
        public final long negative = negativeCount;
    };
}

}
