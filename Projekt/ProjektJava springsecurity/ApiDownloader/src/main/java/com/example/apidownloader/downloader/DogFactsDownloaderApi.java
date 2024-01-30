package com.example.apidownloader.downloader;

import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DogFactsDownloaderApi {

    private final RestTemplate restTemplate = new RestTemplate();

    public String factFromApi() {
        String apiURL = "https://dog-api.kinduff.com/api/facts";
        String jsonFact = restTemplate.getForObject(apiURL, String.class);
        JSONObject result = new JSONObject(jsonFact);
        return result.getJSONArray("facts").getString(0);
    }
}
