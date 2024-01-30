package com.example.frontend.Service;

import com.example.frontend.Object.Cat;
import com.example.frontend.Object.Joke;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Random;

@Service
public class JokeService {

    private final RestClient restClient;
    private final String API_URL="http://localhost:8080";

    public JokeService() {
        this.restClient = RestClient.create();
    }

    public List<Joke> getJokes(){
        List<Joke> jokes = restClient
                .get()
                .uri(API_URL+"/joke/all")
                .retrieve()
                .body(new ParameterizedTypeReference<>() {});
        return jokes;
    }

    public Joke getNewJoke(){
        Random generator = new Random();
        List<Joke> allJokes=getJokes();
        int id = allJokes.size();
        Joke joke= restClient
                .get()
                .uri(API_URL+"/joke/get/"+id+"")
                .retrieve()
                .body(new ParameterizedTypeReference<>() {});
        return joke;
    }

}
