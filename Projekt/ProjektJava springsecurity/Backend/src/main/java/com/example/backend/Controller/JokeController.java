package com.example.backend.controller;

import com.example.backend.object.Joke;
import com.example.backend.service.JokeService;
import org.springframework.web.bind.annotation.*;

@RestController
public class JokeController {

    private final JokeService jokeService;

    public JokeController(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    @GetMapping("/joke/get/{id}")
    public Joke findById(@PathVariable("id") Long id){
        return this.jokeService.findById(id);
    }

    @GetMapping("/joke/all")
    public Iterable<Joke> getJokes(){
        return this.jokeService.getJokes();
    }

    @DeleteMapping("/joke/delete/{id}")
    public void deleteJoke(@PathVariable("id") Long id){
        this.jokeService.deleteJoke(id);
    }

    @PutMapping("/joke/update")
    public void updateJoke(@RequestBody Joke joke){
        this.jokeService.editJoke(joke);
    }
}
