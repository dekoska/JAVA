package com.example.backend.Service;

import com.example.backend.Exceptions.DogAlreadyExistsException;
import com.example.backend.Exceptions.DogNotFoundException;
import com.example.backend.Object.Dog;
import com.example.backend.Repository.DogRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DogService {

    private final DogRepository repository;

    public DogService(DogRepository repository) {
        this.repository = repository;
    }

    public Dog findById(Long id){
        Optional<Dog> dog = this.repository.findById(id);
        if(dog.isPresent())
            return dog.get();
        else throw new DogNotFoundException();
    }

    public Iterable<Dog> getDogs(){
        if(this.repository.count()>0)
            return this.repository.findAll();
        else  throw new DogNotFoundException();
    }
    public void deleteDog(Long id){
        if(this.repository.findById(id).isPresent())
            this.repository.deleteById(id);
        else throw new DogNotFoundException();
    }

    public void editDog(Dog dog){
        Optional<Dog> optionalDog = this.repository.findById(dog.getId());
        if(optionalDog.isPresent()) {
            Dog newDog = optionalDog.get();
            newDog.setContent(dog.getContent());
            newDog.setPhotoURL(dog.getPhotoURL());
            this.repository.save(newDog);
        }
        else  throw new DogNotFoundException();
    }


}
