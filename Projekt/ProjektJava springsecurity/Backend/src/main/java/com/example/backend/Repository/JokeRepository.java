package com.example.backend.repository;

import com.example.backend.object.Joke;
import org.springframework.data.repository.CrudRepository;

public interface JokeRepository extends CrudRepository<Joke, Long> {
}
