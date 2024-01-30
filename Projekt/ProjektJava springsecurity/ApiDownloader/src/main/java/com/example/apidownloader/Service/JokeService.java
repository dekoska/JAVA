package com.example.apidownloader.service;

import com.example.apidownloader.downloader.JokeFactsDownloaderApi;
import com.example.apidownloader.downloader.JokePicturesDownloaderApi;
import com.example.apidownloader.object.Joke;
import com.example.apidownloader.repository.JokeRepository;
import org.springframework.stereotype.Service;

@Service
public class JokeService {

    private final JokeRepository repository;

    public JokeService(JokeRepository repository) {
        this.repository = repository;
    }

    public void addJoke() {
        JokeFactsDownloaderApi fact = new JokeFactsDownloaderApi();
        String resultFact = fact.factFromApi();

        JokePicturesDownloaderApi photos = new JokePicturesDownloaderApi();
        String resultPics = photos.pictureFromApi();

        Joke joke = new Joke();
        joke.setContent(resultFact);
        joke.setPhotoURL(resultPics);

        this.repository.save(joke);
    }
}