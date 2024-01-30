package com.example.apidownloader.service;

import com.example.apidownloader.downloader.DogFactsDownloaderApi;
import com.example.apidownloader.downloader.DogPicturesDownloaderApi;
import com.example.apidownloader.object.Dog;
import com.example.apidownloader.repository.DogRepository;
import org.springframework.stereotype.Service;

@Service
public class DogService {

    private final DogRepository repository;

    public DogService(DogRepository repository) {
        this.repository = repository;
    }
    public void addDog(){
        DogFactsDownloaderApi fact = new DogFactsDownloaderApi();
        String resultFact = fact.factFromApi();

        DogPicturesDownloaderApi photos = new DogPicturesDownloaderApi();
        String resultPics = photos.pictureFromApi();

        Dog dog = new Dog();
        dog.setContent(resultFact);
        dog.setPhotoURL(resultPics);

        this.repository.save(dog);
    }

}
