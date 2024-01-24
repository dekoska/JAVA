package com.example.apidownloader.Service;

import com.example.apidownloader.Downloaders.JokeFactsDownloaderApi;
import com.example.apidownloader.Downloaders.JokePicturesDownloaderApi;
import com.example.apidownloader.Object.Joke;
import com.example.apidownloader.Repository.JokeRepository;
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