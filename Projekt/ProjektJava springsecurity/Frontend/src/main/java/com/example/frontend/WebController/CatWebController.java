package com.example.frontend.WebController;

import com.example.frontend.Service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@CrossOrigin("*")
public class CatWebController {

    private final CatService catService;

    @Autowired
    public CatWebController(CatService catService) {
        this.catService = catService;
    }

    @GetMapping("/user/cats")
    public String getNewCat(Model model){
        model.addAttribute("cat",catService.getNewCat());
        return "cats";
    }
}