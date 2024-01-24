package com.example.frontend.WebController;

import com.example.frontend.Service.DogService;
import com.example.frontend.Service.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@CrossOrigin("*")
public class JokeWebController {

    private final JokeService jokeService;

    @Autowired
    public JokeWebController(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    @GetMapping("/user/jokes")
    public String getNewJoke(Model model){
        model.addAttribute("joke",jokeService.getNewJoke());
        return "jokes";
    }
}
