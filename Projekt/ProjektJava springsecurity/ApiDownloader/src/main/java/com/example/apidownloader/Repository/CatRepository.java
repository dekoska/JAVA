package com.example.apidownloader.repository;

import com.example.apidownloader.object.Cat;
import org.springframework.data.repository.CrudRepository;

public interface CatRepository extends CrudRepository<Cat, Long> {
}
