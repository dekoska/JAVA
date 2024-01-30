package com.example.apidownloader.repository;

import com.example.apidownloader.object.Joke;
import org.springframework.data.repository.CrudRepository;

public interface JokeRepository extends CrudRepository<Joke, Long> {
}
