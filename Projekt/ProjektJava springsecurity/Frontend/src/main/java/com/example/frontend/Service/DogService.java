package com.example.frontend.Service;

import com.example.frontend.Object.Dog;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Random;

@Service
public class DogService {

    RestClient restClient;
    public static final String API_URL="http://localhost:8080";

    public DogService() {
        this.restClient = RestClient.create();
    }

    public List<Dog> getDogs(){
        List<Dog> dogs = restClient
                .get()
                .uri(API_URL+"/dog/all")
                .retrieve()
                .body(new ParameterizedTypeReference<>() {});
        return dogs;
    }

    public Dog getNewDog(){
        Random generator = new Random();
        List<Dog> allDogs=getDogs();
        int id = allDogs.size();
        Dog dog= restClient
                .get()
                .uri(API_URL+"/dog/get/"+id)
                .retrieve()
                .body(new ParameterizedTypeReference<>() {});
        return dog;
    }

}
