package com.example.backend.service;

import com.example.backend.exception.exceptions.DogNotFoundException;
import com.example.backend.object.Dog;
import com.example.backend.repository.DogRepository;
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
class DogServiceTest {

    @Mock
    private DogRepository repository;

    @InjectMocks
    private DogService dogService;

    @Test
    void findById_ExistingDog_ReturnsDog() {
        Long dogId = 1L;
        Dog expectedDog = new Dog("fact", "url");
        expectedDog.setId(dogId);


        when(repository.findById(dogId)).thenReturn(Optional.of(expectedDog));

        Dog actualDog = dogService.findById(dogId);

        assertNotNull(actualDog);
        assertEquals(expectedDog, actualDog);
    }

    @Test
    void findById_NonExistingDog_ThrowsDogNotFoundException() {
        Long dogId = 2L;

        when(repository.findById(dogId)).thenReturn(Optional.empty());

        assertThrows(DogNotFoundException.class, () -> dogService.findById(dogId));
    }

    @Test
    void getDogs_ExistingDogs_ReturnsDogs() {
        Dog dog1 = new Dog("fact1", "url1");
        Dog dog2 = new Dog("fact2", "url2");
        List<Dog> expectedDogs = Arrays.asList(dog1, dog2);

        when(repository.count()).thenReturn((long) expectedDogs.size());
        when(repository.findAll()).thenReturn(expectedDogs);

        Iterable<Dog> actualDogs = dogService.getDogs();

        assertNotNull(actualDogs);
        assertEquals(expectedDogs, actualDogs);
    }

    @Test
    void getDogs_NoDog_ThrowsDogNotFoundException() {
        when(repository.count()).thenReturn(0L);

        assertThrows(DogNotFoundException.class, () -> dogService.getDogs());
    }

    @Test
    void deleteDog_ExistingDog_DeletesDog() {
        long dogId = 1L;
        Dog existingDog = new Dog("fact", "url");
        existingDog.setId(dogId);

        when(repository.findById(dogId)).thenReturn(Optional.of(existingDog));

        dogService.deleteDog(dogId);

        verify(repository, times(1)).deleteById(dogId);
    }

    @Test
    void deleteDog_NonExistingDog_ThrowsDogNotFoundException() {
        long dogId = 1L;
        when(repository.findById(dogId)).thenReturn(Optional.empty());

        assertThrows(DogNotFoundException.class, () -> dogService.deleteDog(dogId));

        verify(repository, never()).deleteById(dogId);
    }

    @Test
    void editDog_ExistingDog_EditsDog() {
        long dogId = 1L;
        Dog existingDog = new Dog("fact", "url");
        Dog editedDog = new Dog("fact2", "url2");
        existingDog.setId(dogId);
        editedDog.setId(dogId);

        when(repository.findById(dogId)).thenReturn(Optional.of(existingDog));

        dogService.editDog(editedDog);

        verify(repository, times(1)).save(existingDog);
        assertEquals("fact2", existingDog.getContent());
        assertEquals("url2", existingDog.getPhotoURL());
    }

    @Test
    void editDog_NonExistingDog_ThrowsDogNotFoundException() {
        long dogId = 1L;
        Dog nonExistingDog = new Dog("fact", "url");
        nonExistingDog.setId(dogId);

        when(repository.findById(dogId)).thenReturn(Optional.empty());

        assertThrows(DogNotFoundException.class, () -> dogService.editDog(nonExistingDog));

        verify(repository, never()).save(any());
    }
}
