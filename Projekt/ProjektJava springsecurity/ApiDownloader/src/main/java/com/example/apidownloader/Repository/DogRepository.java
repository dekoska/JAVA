package com.example.apidownloader.repository;

import com.example.apidownloader.object.Dog;
import org.springframework.data.repository.CrudRepository;

public interface DogRepository extends CrudRepository<Dog, Long> {
}
