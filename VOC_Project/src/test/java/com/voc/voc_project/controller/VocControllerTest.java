package com.voc.voc_project.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.transaction.Transactional;

import java.nio.charset.Charset;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class VocControllerTest {

    @Autowired
    private MockMvc mockMvc;

    //voc 귀책조사 이후 검토, 배상 처리
    @Test
    void registerReimOrReviewTest() throws Exception{

        mockMvc.perform(
                MockMvcRequestBuilders.put("http://localhost:8089/voc/reasonChk/record")
                        .param("vocId","5")
                        .param("target","D")
                        .param("reimTot","200000")
                        .param("driverChk","0")
                        .param("penaltyChk","0")
                        .param("disagree","N")
                        .param("retailId","3")
                        .param("driverId","5")
        ).andExpect(
                MockMvcResultMatchers.status().is2xxSuccessful()
        ).andDo(
                MockMvcResultHandlers.print()
        );
        //가짜객체로 5번 voc 기록 수정 후 바로 확인!
        //위의 가짜데이터는 주어진 조건이었던
        //"보상을 신청했고, 기사님이 확인후 이의제기를 하지 않았을 때를 모두 반영한 데이터"입니다
        searchList();
    }

    //전체 목록 조회
    @Test
    void searchList() throws Exception{
        mockMvc.perform(
                MockMvcRequestBuilders.get("http://localhost:8089/voc/search/vocList")
        ).andExpect(
                MockMvcResultMatchers.status().is2xxSuccessful()
        ).andDo(
                MockMvcResultHandlers.print()
        );
    }
}