package org.example.labthree;


import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;


@SpringBootTest
@AutoConfigureMockMvc
public class TestingWebApplication {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnAddress() throws Exception {
        this.mockMvc.perform(get("/viewAddressBook?id=1")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Bob")));
    }

    @Test
    void shouldPostAddressBook() throws Exception {
        this.mockMvc.perform(post("/api/create/2")).andDo(print()).andExpect(status().isOk());
        this.mockMvc.perform(get("/viewAddressBook?id=2")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void shouldPostBuddy() throws Exception {
        this.mockMvc.perform(post("/api/1/add/Steve/613-333-4444")).andDo(print()).andExpect(status().isOk());
        this.mockMvc.perform(get("/viewAddressBook?id=1")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Steve")));
    }

    @Test
    void shouldDeleteBuddy() throws Exception {
        this.mockMvc.perform(delete("/api/1/remove/613-123-4567")).andDo(print()).andExpect(status().isOk());
        this.mockMvc.perform(get("/viewAddressBook?id=1")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(not(containsString("Bob"))));
    }
}
