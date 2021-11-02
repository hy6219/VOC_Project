package com.voc.voc_project.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class DriverControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void searchAllTest() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("http://localhost:8089/retail/drivers/info/search")
        ).andExpect(
                MockMvcResultMatchers.status().is2xxSuccessful()
        ).andDo(
                MockMvcResultHandlers.print()
        );
    }

    @Test
    void searchDriversByRetail() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("http://localhost:8089/retail/drivers/info/searchByRetail")
                        .param("retailId","2")
        ).andExpect(
                MockMvcResultMatchers.status().is2xxSuccessful()
        ).andDo(
                MockMvcResultHandlers.print()
        );
    }
}