package com.example.backend.repository;

import com.example.backend.object.Cat;
import org.springframework.data.repository.CrudRepository;

public interface CatRepository extends CrudRepository<Cat, Long> {


}
