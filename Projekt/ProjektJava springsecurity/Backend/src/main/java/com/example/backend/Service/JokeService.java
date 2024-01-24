package com.example.backend.Service;

import com.example.backend.Exceptions.JokeAlreadyExistsException;
import com.example.backend.Exceptions.JokeNotFoundException;
import com.example.backend.Object.Joke;
import com.example.backend.Repository.JokeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JokeService {

    private final JokeRepository repository;

    public JokeService(JokeRepository repository) {
        this.repository = repository;
    }

    public Joke findById(Long id){
        Optional<Joke> joke = this.repository.findById(id);
        if(joke.isPresent())
            return joke.get();
        else throw new JokeNotFoundException();
    }

    public Iterable<Joke> getJokes(){
        if(this.repository.count()>0)
            return this.repository.findAll();
        else  throw new JokeNotFoundException();
    }
    public void deleteJoke(Long id){
        if(this.repository.findById(id).isPresent())
            this.repository.deleteById(id);
        else throw new JokeNotFoundException();
    }

    public void editJoke(Joke joke){
        Optional<Joke> optionalJoke = this.repository.findById(joke.getId());
        if(optionalJoke.isPresent()) {
            Joke newJoke = optionalJoke.get();
            newJoke.setContent(joke.getContent());
            newJoke.setPhotoURL(joke.getPhotoURL());
            this.repository.save(newJoke);
        }
        else  throw new JokeNotFoundException();
    }


}
