package com.example.apidownloader.Repository;

import com.example.apidownloader.Object.Cat;
import org.springframework.data.repository.CrudRepository;

public interface CatRepository extends CrudRepository<Cat, Long> {
}
