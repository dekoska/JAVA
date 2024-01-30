package com.example.backend.controller;

import com.example.backend.exception.handler.CatExceptionsHandler;
import com.example.backend.exception.exceptions.CatNotFoundException;
import com.example.backend.object.Cat;
import com.example.backend.service.CatService;
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

public class CatControllerTest {


    private MockMvc mockMvc;

    @InjectMocks
    private CatController catController;

    @Mock
    private CatService catService;

    @BeforeEach
    public void setup(){
        this.mockMvc = MockMvcBuilders.standaloneSetup(
                new CatExceptionsHandler(), catController).build();
    }

    @Test
    void findById_ExistingCat_ReturnsCat() throws Exception {
        Cat cat = new Cat("fact", "url");
        cat.setId(1L);
        when(catService.findById(1L)).thenReturn(cat);

        mockMvc.perform(MockMvcRequestBuilders.get("/cat/get/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.content").value("fact"))
                .andExpect(jsonPath("$.photoURL").value("url"));
    }

    @Test
    void findById_NonExistingCat_ReturnsNotFound() throws Exception {
        when(catService.findById(1L)).thenThrow(new CatNotFoundException());

        mockMvc.perform(MockMvcRequestBuilders.get("/cat/get/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    void getCats_ExistingCats_ReturnsCats() throws Exception {
        Cat cat = new Cat("fact", "url");
        cat.setId(1L);
        when(catService.getCats()).thenReturn(Collections.singletonList(cat));

        mockMvc.perform(MockMvcRequestBuilders.get("/cat/all"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].content").value("fact"))
                .andExpect(jsonPath("$[0].photoURL").value("url"));
    }

    @Test
    void getCats_NoCats_ReturnsNotFound() throws Exception {
        when(catService.getCats()).thenThrow(new CatNotFoundException());

        mockMvc.perform(MockMvcRequestBuilders.get("/cat/all"))
                .andExpect(status().isNotFound());
    }

    @Test
    void deleteCat_ExistingCat_DeletesCat() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/cat/delete/1"))
                .andExpect(status().isOk());

        verify(catService, times(1)).deleteCat(1L);
    }

    @Test
    void deleteCat_NonExistingCat_ReturnsNotFound() throws Exception {
        doThrow(new CatNotFoundException()).when(catService).deleteCat(1L);

        mockMvc.perform(MockMvcRequestBuilders.delete("/cat/delete/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    void updateCat_ValidCat_UpdatesCat() throws Exception {
        Cat catToUpdate = new Cat();
        catToUpdate.setId(1L);
        catToUpdate.setContent("fact");
        catToUpdate.setPhotoURL("url");

        String catJson = "{\"id\":1,\"content\":\"fact1\",\"photoURL\":\"url1\"}";

        mockMvc.perform(MockMvcRequestBuilders.put("/cat/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(catJson))
                .andExpect(status().isOk());

    }
}
