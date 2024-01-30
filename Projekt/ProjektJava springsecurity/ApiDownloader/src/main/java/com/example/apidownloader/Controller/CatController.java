package com.example.apidownloader.controller;

import com.example.apidownloader.service.CatService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class CatController {

    private final CatService catService;

    public CatController(CatService catService) {
        this.catService = catService;
    }

    @GetMapping("/cat/add")
    public void addCat(HttpServletResponse httpServletResponse) throws IOException {
        this.catService.addCat();
        httpServletResponse.sendRedirect("http://localhost:8081/user/cats");
    }

}
