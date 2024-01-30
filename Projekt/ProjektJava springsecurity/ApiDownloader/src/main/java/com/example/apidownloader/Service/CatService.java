package com.example.apidownloader.service;

import com.example.apidownloader.downloader.CatFactsDownloaderApi;
import com.example.apidownloader.downloader.CatPicturesDownloaderApi;
import com.example.apidownloader.object.Cat;
import com.example.apidownloader.repository.CatRepository;
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