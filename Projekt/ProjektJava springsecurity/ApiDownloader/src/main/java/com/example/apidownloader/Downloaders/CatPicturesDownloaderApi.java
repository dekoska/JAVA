package com.example.apidownloader.Downloaders;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.client.RestTemplate;

public class CatPicturesDownloaderApi {

    private final RestTemplate restTemplate = new RestTemplate();

    public String pictureFromApi(){
        String apiURL = "https://api.thecatapi.com/v1/images/search";
        String jsonPicture = restTemplate.getForObject(apiURL, String.class);
        JSONArray array = new JSONArray(jsonPicture);
        JSONObject result = array.getJSONObject(0);
        return result.get("url").toString();
    }
}

