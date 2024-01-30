package com.example.backend.controller;

import com.example.backend.exception.handler.JokeExceptionsHandler;
import com.example.backend.exception.exceptions.JokeNotFoundException;
import com.example.backend.object.Joke;
import com.example.backend.service.JokeService;
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
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@TestPropertySource(properties = "spring.main.web-application-type=reactive")

public class JokeControllerTest {


    private MockMvc mockMvc;

    @InjectMocks
    private JokeController jokeController;

    @Mock
    private JokeService jokeService;

    @BeforeEach
    public void setup(){
        this.mockMvc = MockMvcBuilders.standaloneSetup(
                new JokeExceptionsHandler(), jokeController).build();
    }

    @Test
    void findById_ExistingJoke_ReturnsJoke() throws Exception {
        Joke joke = new Joke("fact", "url");
        joke.setId(1L);
        when(jokeService.findById(1L)).thenReturn(joke);

        mockMvc.perform(MockMvcRequestBuilders.get("/joke/get/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.content").value("fact"))
                .andExpect(jsonPath("$.photoURL").value("url"));
    }

    @Test
    void findById_NonExistingJoke_ReturnsNotFound() throws Exception {
        when(jokeService.findById(1L)).thenThrow(new JokeNotFoundException());

        mockMvc.perform(MockMvcRequestBuilders.get("/joke/get/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    void getJokes_ExistingJokes_ReturnsDogs() throws Exception {
        Joke joke = new Joke("fact", "url");
        joke.setId(1L);
        when(jokeService.getJokes()).thenReturn(Collections.singletonList(joke));

        mockMvc.perform(MockMvcRequestBuilders.get("/joke/all"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].content").value("fact"))
                .andExpect(jsonPath("$[0].photoURL").value("url"));
    }

    @Test
    void getJokes_NoJokes_ReturnsNotFound() throws Exception {
        when(jokeService.getJokes()).thenThrow(new JokeNotFoundException());

        mockMvc.perform(MockMvcRequestBuilders.get("/joke/all"))
                .andExpect(status().isNotFound());
    }

    @Test
    void deleteJoke_ExistingJoke_DeletesJoke() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/joke/delete/1"))
                .andExpect(status().isOk());

        verify(jokeService, times(1)).deleteJoke(1L);
    }

    @Test
    void deleteJoke_NonExistingJoke_ReturnsNotFound() throws Exception {
        doThrow(new JokeNotFoundException()).when(jokeService).deleteJoke(1L);

        mockMvc.perform(MockMvcRequestBuilders.delete("/joke/delete/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    void updateJoke_ValidJoke_UpdatesJoke() throws Exception {
        Joke jokeToUpdate = new Joke();
        jokeToUpdate.setId(1L);
        jokeToUpdate.setContent("fact");
        jokeToUpdate.setPhotoURL("url");

        String jokeJson = "{\"id\":1,\"content\":\"fact1\",\"photoURL\":\"url1\"}";

        mockMvc.perform(MockMvcRequestBuilders.put("/joke/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jokeJson))
                .andExpect(status().isOk());

    }
}