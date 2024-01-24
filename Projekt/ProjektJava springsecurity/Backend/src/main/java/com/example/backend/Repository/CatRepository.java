package com.example.backend.Repository;

import com.example.backend.Object.Cat;
import org.springframework.data.repository.CrudRepository;

public interface CatRepository extends CrudRepository<Cat, Long> {


}
