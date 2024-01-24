package com.example.apidownloader.Repository;

import com.example.apidownloader.Object.Joke;
import org.springframework.data.repository.CrudRepository;

public interface JokeRepository extends CrudRepository<Joke, Long> {
}
