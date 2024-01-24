package com.example.apidownloader.Service;

import com.example.apidownloader.Downloaders.CatFactsDownloaderApi;
import com.example.apidownloader.Downloaders.CatPicturesDownloaderApi;
import com.example.apidownloader.Object.Cat;
import com.example.apidownloader.Repository.CatRepository;
import org.springframework.stereotype.Service;

@Service
public class CatService {

    private final CatRepository repository;

    public CatService(CatRepository repository) {
        this.repository = repository;
    }

    public void addCat() {
        CatFactsDownloaderApi fact = new CatFactsDownloaderApi();
        String resultFact = fact.factFromApi();

        CatPicturesDownloaderApi photos = new CatPicturesDownloaderApi();
        String resultPics = photos.pictureFromApi();

        Cat cat = new Cat();
        cat.setContent(resultFact);
        cat.setPhotoURL(resultPics);

        this.repository.save(cat);
    }

}