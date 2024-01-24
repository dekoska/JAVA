package com.example.backend.Repository;

import com.example.backend.Object.Dog;
import org.springframework.data.repository.CrudRepository;

public interface DogRepository extends CrudRepository<Dog, Long> {
}
