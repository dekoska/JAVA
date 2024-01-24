package com.example.apidownloader.Repository;

import com.example.apidownloader.Object.Dog;
import org.springframework.data.repository.CrudRepository;

public interface DogRepository extends CrudRepository<Dog, Long> {
}
