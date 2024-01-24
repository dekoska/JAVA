package com.example.backend.Repository;

import com.example.backend.Object.Joke;
import org.springframework.data.repository.CrudRepository;

public interface JokeRepository extends CrudRepository<Joke, Long> {
}
