package com.example.backend.service;

import com.example.backend.exception.exceptions.CatNotFoundException;
import com.example.backend.object.Cat;
import com.example.backend.repository.CatRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CatServiceTest {

    @Mock
    private CatRepository repository;

    @InjectMocks
    private CatService catService;

    @Test
    void findById_ExistingCat_ReturnsCat() {
        Long catId = 1L;
        Cat expectedCat = new Cat("fact", "url");
        expectedCat.setId(catId);


        when(repository.findById(catId)).thenReturn(Optional.of(expectedCat));

        Cat actualCat = catService.findById(catId);

        assertNotNull(actualCat);
        assertEquals(expectedCat, actualCat);
    }

    @Test
    void findById_NonExistingCat_ThrowsCatNotFoundException() {
        Long catId = 2L;

        when(repository.findById(catId)).thenReturn(Optional.empty());

        assertThrows(CatNotFoundException.class, () -> catService.findById(catId));
    }

    @Test
    void getCats_ExistingCats_ReturnsCats() {
        Cat cat1 = new Cat("fact1", "url1");
        Cat cat2 = new Cat("fact2", "url2");
        List<Cat> expectedCats = Arrays.asList(cat1, cat2);

        when(repository.count()).thenReturn((long) expectedCats.size());
        when(repository.findAll()).thenReturn(expectedCats);

        Iterable<Cat> actualCats = catService.getCats();

        assertNotNull(actualCats);
        assertEquals(expectedCats, actualCats);
    }

    @Test
    void getCats_NoCats_ThrowsCatNotFoundException() {
        when(repository.count()).thenReturn(0L);

        assertThrows(CatNotFoundException.class, () -> catService.getCats());
    }

    @Test
    void deleteCat_ExistingCat_DeletesCat() {
        long catId = 1L;
        Cat existingCat = new Cat("fact", "url");
        existingCat.setId(catId);

        when(repository.findById(catId)).thenReturn(Optional.of(existingCat));

        catService.deleteCat(catId);

        verify(repository, times(1)).deleteById(catId);
    }

    @Test
    void deleteCat_NonExistingCat_ThrowsCatNotFoundException() {
        long catId = 1L;

        when(repository.findById(catId)).thenReturn(Optional.empty());

        assertThrows(CatNotFoundException.class, () -> catService.deleteCat(catId));

        verify(repository, never()).deleteById(catId);
    }

    @Test
    void editCat_ExistingCat_EditsCat() {

        long catId = 1L;
        Cat existingCat = new Cat("fact", "url");
        Cat editedCat = new Cat("fact2", "url2");
        existingCat.setId(catId);
        editedCat.setId(catId);

        when(repository.findById(catId)).thenReturn(Optional.of(existingCat));

        catService.editCat(editedCat);

        verify(repository, times(1)).save(existingCat);
        assertEquals("fact2", existingCat.getContent());
        assertEquals("url2", existingCat.getPhotoURL());
    }

    @Test
    void editCat_NonExistingCat_ThrowsCatNotFoundException() {
        long catId = 1L;
        Cat nonExistingCat = new Cat("fact", "url");
        nonExistingCat.setId(catId);

        when(repository.findById(catId)).thenReturn(Optional.empty());

        assertThrows(CatNotFoundException.class, () -> catService.editCat(nonExistingCat));

        verify(repository, never()).save(any());
    }
}
