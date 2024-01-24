package com.example.apidownloader.Controller;

import com.example.apidownloader.Service.DogService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class DogController {

    private final DogService dogService;

    public DogController(DogService dogService) {
        this.dogService = dogService;
    }

    @GetMapping("/dog/add")
    public void addCat(HttpServletResponse httpServletResponse) throws IOException {
        this.dogService.addDog();
        httpServletResponse.sendRedirect("http://localhost:8081/user/dogs");
    }

}
