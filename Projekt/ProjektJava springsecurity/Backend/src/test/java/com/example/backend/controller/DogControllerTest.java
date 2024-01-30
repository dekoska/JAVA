package com.example.backend.controller;

import com.example.backend.exception.handler.DogExceptionsHandler;
import com.example.backend.exception.exceptions.DogNotFoundException;
import com.example.backend.object.Dog;
import com.example.backend.service.DogService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@TestPropertySource(properties = "spring.main.web-application-type=reactive")

public class DogControllerTest {


    private MockMvc mockMvc;

    @InjectMocks
    private DogController dogController;

    @Mock
    private DogService dogService;

    @BeforeEach
    public void setup(){
        this.mockMvc = MockMvcBuilders.standaloneSetup(
                new DogExceptionsHandler(), dogController).build();
    }

    @Test
    void findById_ExistingDog_ReturnsDog() throws Exception {
        Dog dog = new Dog("fact", "url");
        dog.setId(1L);
        when(dogService.findById(1L)).thenReturn(dog);

        mockMvc.perform(MockMvcRequestBuilders.get("/dog/get/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.content").value("fact"))
                .andExpect(jsonPath("$.photoURL").value("url"));
    }

    @Test
    void findById_NonExistingDog_ReturnsNotFound() throws Exception {
        when(dogService.findById(1L)).thenThrow(new DogNotFoundException());

        mockMvc.perform(MockMvcRequestBuilders.get("/dog/get/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    void getDogs_ExistingDogs_ReturnsDogs() throws Exception {
        Dog dog = new Dog("fact", "url");
        dog.setId(1L);
        when(dogService.getDogs()).thenReturn(Collections.singletonList(dog));

        mockMvc.perform(MockMvcRequestBuilders.get("/dog/all"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].content").value("fact"))
                .andExpect(jsonPath("$[0].photoURL").value("url"));
    }

    @Test
    void getDogs_NoDogs_ReturnsNotFound() throws Exception {
        when(dogService.getDogs()).thenThrow(new DogNotFoundException());

        mockMvc.perform(MockMvcRequestBuilders.get("/dog/all"))
                .andExpect(status().isNotFound());
    }

    @Test
    void deleteDog_ExistingDog_DeletesDog() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/dog/delete/1"))
                .andExpect(status().isOk());

        verify(dogService, times(1)).deleteDog(1L);
    }

    @Test
    void deleteDog_NonExistingDog_ReturnsNotFound() throws Exception {
        doThrow(new DogNotFoundException()).when(dogService).deleteDog(1L);

        mockMvc.perform(MockMvcRequestBuilders.delete("/dog/delete/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    void updateDog_ValidDog_UpdatesDog() throws Exception {
        Dog dogToUpdate = new Dog();
        dogToUpdate.setId(1L);
        dogToUpdate.setContent("fact");
        dogToUpdate.setPhotoURL("url");

        String jokeJson = "{\"id\":1,\"content\":\"fact1\",\"photoURL\":\"url1\"}";

        mockMvc.perform(MockMvcRequestBuilders.put("/dog/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jokeJson))
                .andExpect(status().isOk());

    }
}
