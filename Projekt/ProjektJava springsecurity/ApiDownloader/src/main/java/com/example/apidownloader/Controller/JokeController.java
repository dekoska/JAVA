package com.example.apidownloader.Controller;

import com.example.apidownloader.Service.JokeService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class JokeController {

    private final JokeService jokeService;

    public JokeController(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    @GetMapping("/joke/add")
    public void addJoke(HttpServletResponse httpServletResponse) throws IOException {
        this.jokeService.addJoke();
        httpServletResponse.sendRedirect("http://localhost:8081/user/jokes");
    }
}

