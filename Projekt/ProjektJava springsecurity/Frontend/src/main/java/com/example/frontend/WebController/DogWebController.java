package com.example.frontend.WebController;

import com.example.frontend.Service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@CrossOrigin("*")
public class DogWebController {

    private final DogService dogService;

    @Autowired
    public DogWebController(DogService dogService) {
        this.dogService = dogService;
    }

    @GetMapping("/user/dogs")
    public String getNewDog(Model model){
        model.addAttribute("dog",dogService.getNewDog());
        return "dogs";
    }
}
