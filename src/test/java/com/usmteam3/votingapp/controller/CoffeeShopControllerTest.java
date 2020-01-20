package com.usmteam3.votingapp.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(CoffeeShopController.class)
public class CoffeeShopControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void coffeePage() throws Exception {
//        this.mockMvc.perform(get("/shop/{id}")
//                .contentType("string"))
//                    .andExpect(status().isOk());
    }

    @Test
    public void addRating() {

    }

    @Test
    public void testAddRating() {

    }
}
