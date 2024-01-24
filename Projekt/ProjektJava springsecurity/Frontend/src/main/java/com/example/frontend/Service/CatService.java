package com.example.frontend.Service;


import com.example.frontend.Object.Cat;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Random;

@Service
public class CatService {

    RestClient restClient;
    public static final String API_URL="http://localhost:8080";

    public CatService() {
        this.restClient = RestClient.create();
    }

    public List<Cat> getCats(){
        List<Cat> cats = restClient
                .get()
                .uri(API_URL+"/cat/all")
                .retrieve()
                .body(new ParameterizedTypeReference<>() {});
        return cats;
    }

    public Cat getNewCat(){
        List<Cat> allCats=getCats();
        int id = allCats.size();
        Cat cat= restClient
                .get()
                  .uri(API_URL+"/cat/get/"+id+"")
                .retrieve()
                .body(new ParameterizedTypeReference<>() {});
        return cat;
    }



}
