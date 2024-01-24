package com.example.backend.Controller;

import com.example.backend.Object.Dog;
import com.example.backend.Service.DogService;
import org.springframework.web.bind.annotation.*;

@RestController
public class DogController {

    private final DogService dogService;

    public DogController(DogService dogService) {
        this.dogService = dogService;
    }

    @GetMapping("/dog/get/{id}")
    public Dog findById(@PathVariable("id") Long id){
        return this.dogService.findById(id);
    }

    @GetMapping("/dog/all")
    public Iterable<Dog> getDogs(){
        return this.dogService.getDogs();
    }

    @DeleteMapping("/dog/delete/{id}")
    public void deleteDog(@PathVariable("id") Long id){
        this.dogService.deleteDog(id);
    }

    @PutMapping("/dog/update")
    public void updateDog(@RequestBody Dog dog){
        this.dogService.editDog(dog);
    }
}
