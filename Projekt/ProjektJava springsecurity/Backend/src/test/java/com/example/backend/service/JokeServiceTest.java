package com.example.backend.service;

import com.example.backend.exception.exceptions.JokeNotFoundException;
import com.example.backend.object.Joke;
import com.example.backend.repository.JokeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.never;

@ExtendWith(MockitoExtension.class)
public class JokeServiceTest {

    @Mock
    private JokeRepository repository;

    @InjectMocks
    private JokeService jokeService;

    @Test
    void findById_ExistingJoke_ReturnsJoke() {
        Long jokeId = 1L;
        Joke expectedJoke = new Joke("fact", "url");
        expectedJoke.setId(jokeId);


        when(repository.findById(jokeId)).thenReturn(Optional.of(expectedJoke));

        Joke actualJoke = jokeService.findById(jokeId);

        assertNotNull(actualJoke);
        assertEquals(expectedJoke, actualJoke);
    }

    @Test
    void findById_NonExistingJoke_ThrowsJokeNotFoundException() {
        Long jokeId = 2L;

        when(repository.findById(jokeId)).thenReturn(Optional.empty());

        assertThrows(JokeNotFoundException.class, () -> jokeService.findById(jokeId));
    }

    @Test
    void getJoke_ExistingJoke_ReturnsJoke() {
        Joke joke1 = new Joke("fact1", "url1");
        Joke joke2 = new Joke("fact2", "url2");
        List<Joke> expectedJokes = Arrays.asList(joke1, joke2);

        when(repository.count()).thenReturn((long) expectedJokes.size());
        when(repository.findAll()).thenReturn(expectedJokes);

        Iterable<Joke> actualJokes = jokeService.getJokes();

        assertNotNull(actualJokes);
        assertEquals(expectedJokes, actualJokes);
    }

    @Test
    void getJokes_NoJokes_ThrowsJokeNotFoundException() {
        when(repository.count()).thenReturn(0L);

        assertThrows(JokeNotFoundException.class, () -> jokeService.getJokes());
    }

    @Test
    void deleteJoke_ExistingJoke_DeletesJoke() {
        long jokeId = 1L;
        Joke existingJoke = new Joke("fact", "url");
        existingJoke.setId(jokeId);

        when(repository.findById(jokeId)).thenReturn(Optional.of(existingJoke));

        jokeService.deleteJoke(jokeId);

        verify(repository, times(1)).deleteById(jokeId);
    }

    @Test
    void deleteJoke_NonExistingJoke_ThrowsJokeNotFoundException() {
        long jokeId = 1L;

        when(repository.findById(jokeId)).thenReturn(Optional.empty());

        assertThrows(JokeNotFoundException.class, () -> jokeService.deleteJoke(jokeId));

        verify(repository, never()).deleteById(jokeId);
    }

    @Test
    void editJoke_ExistingJoke_EditsJoke() {

        long jokeId = 1L;
        Joke existingJoke = new Joke("fact", "url");
        Joke editedJoke = new Joke("fact2", "url2");
        existingJoke.setId(jokeId);
        editedJoke.setId(jokeId);

        when(repository.findById(jokeId)).thenReturn(Optional.of(existingJoke));

        jokeService.editJoke(editedJoke);

        verify(repository, times(1)).save(existingJoke);
        assertEquals("fact2", existingJoke.getContent());
        assertEquals("url2", existingJoke.getPhotoURL());
    }

    @Test
    void editJoke_NonExistingJoke_ThrowsJokeNotFoundException() {
        long jokeId = 1L;
        Joke nonExistingJoke = new Joke("fact", "url");
        nonExistingJoke.setId(jokeId);

        when(repository.findById(jokeId)).thenReturn(Optional.empty());

        assertThrows(JokeNotFoundException.class, () -> jokeService.editJoke(nonExistingJoke));

        verify(repository, never()).save(any());
    }
}
