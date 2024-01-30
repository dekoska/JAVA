package com.example.apidownloader.downloader;

import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CatFactsDownloaderApi{

    private final RestTemplate restTemplate = new RestTemplate();

    public String factFromApi() {
        String apiURL = "https://meowfacts.herokuapp.com/";
        String jsonFact = restTemplate.getForObject(apiURL, String.class);
        JSONObject result = new JSONObject(jsonFact);
        return result.getJSONArray("data").getString(0);
    }

}
