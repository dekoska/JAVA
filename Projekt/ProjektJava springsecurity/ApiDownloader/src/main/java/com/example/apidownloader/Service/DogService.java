package com.example.apidownloader.Service;

import com.example.apidownloader.Downloaders.DogFactsDownloaderApi;
import com.example.apidownloader.Downloaders.DogPicturesDownloaderApi;
import com.example.apidownloader.Object.Dog;
import com.example.apidownloader.Repository.DogRepository;
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
