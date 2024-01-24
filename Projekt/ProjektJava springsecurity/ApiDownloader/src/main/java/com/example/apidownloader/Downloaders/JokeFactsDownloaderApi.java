package com.example.apidownloader.Downloaders;

import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class JokeFactsDownloaderApi {

    private final RestTemplate restTemplate = new RestTemplate();

    public String factFromApi() {
        String apiURL = "https://v2.jokeapi.dev/joke/Any?type=single";
        String jsonFact = restTemplate.getForObject(apiURL, String.class);
        JSONObject result = new JSONObject(jsonFact);
        return result.getString("joke");
    }
}
