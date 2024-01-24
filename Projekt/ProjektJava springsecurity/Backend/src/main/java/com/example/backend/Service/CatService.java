package com.example.backend.Service;

import com.example.backend.Exceptions.CatNotFoundException;
import com.example.backend.Object.Cat;
import com.example.backend.Repository.CatRepository;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CatService {

    private final CatRepository repository;

    public CatService(CatRepository repository) {
        this.repository = repository;
    }

    public Cat findById(Long id){
        Optional<Cat> cat = this.repository.findById(id);
        if(cat.isPresent())
            return cat.get();
        else throw new CatNotFoundException();
    }

    public Iterable<Cat> getCats(){
        if(this.repository.count()>0)
        return this.repository.findAll();
        else  throw new CatNotFoundException();
    }

    public void deleteCat(Long id){
        if(this.repository.findById(id).isPresent())
            this.repository.deleteById(id);
        else throw new CatNotFoundException();
    }

    public void editCat(Cat cat){
       Optional<Cat> optionalCat = this.repository.findById(cat.getId());
       if(optionalCat.isPresent()) {
           Cat newCat = optionalCat.get();
           newCat.setContent(cat.getContent());
           newCat.setPhotoURL(cat.getPhotoURL());
            this.repository.save(newCat);
       }
       else  throw new CatNotFoundException();
    }


}
