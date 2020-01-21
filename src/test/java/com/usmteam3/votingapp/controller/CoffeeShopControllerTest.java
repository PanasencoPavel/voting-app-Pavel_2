package com.usmteam3.votingapp.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CoffeeShopControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CoffeeShopController coffeeShopController;

    @Test
    public void mainPageTest() throws Exception {
        this.mockMvc.perform(get("/shop/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Tucano")))
                .andExpect(content().string(containsString("Reviews")));
    }

}
