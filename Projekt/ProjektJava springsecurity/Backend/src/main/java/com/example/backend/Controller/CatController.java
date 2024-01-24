package com.example.backend.Controller;

import com.example.backend.Service.CatService;
import com.example.backend.Object.Cat;
import org.springframework.web.bind.annotation.*;

@RestController
public class CatController {

    private final CatService catService;

    public CatController(CatService catService) {
        this.catService = catService;
    }

    @GetMapping("/cat/get/{id}")
    public Cat findById(@PathVariable("id") Long id){
        return this.catService.findById(id);
    }

    @GetMapping("/cat/all")
    public Iterable<Cat> getCats(){
        return this.catService.getCats();
    }

    @DeleteMapping("/cat/delete/{id}")
    public void deleteCat(@PathVariable("id") Long id){
        this.catService.deleteCat(id);
    }

    @PutMapping("/cat/update")
    public void updateCat(@RequestBody Cat cat){
        this.catService.editCat(cat);
    }




}
