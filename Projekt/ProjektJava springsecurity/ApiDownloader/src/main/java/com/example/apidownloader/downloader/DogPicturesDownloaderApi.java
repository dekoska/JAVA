package com.example.apidownloader.downloader;

import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DogPicturesDownloaderApi {

    private final RestTemplate restTemplate = new RestTemplate();

    public String pictureFromApi() {
        String apiURL = "https://random.dog/woof.json";
        String jsonPicture = restTemplate.getForObject(apiURL, String.class);
        JSONObject result = new JSONObject(jsonPicture);
        return result.getString("url");
    }
}
