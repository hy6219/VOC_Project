package com.voc.voc_project.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.voc.voc_project.domain.model.Business;
import com.voc.voc_project.domain.model.Claim;
import com.voc.voc_project.domain.model.VOC;
import com.voc.voc_project.domain.repository.BusinessRepository;
import com.voc.voc_project.domain.repository.ClaimRepository;
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
import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class ClaimControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private BusinessRepository businessRepository;
    @Autowired
    private ClaimRepository claimRepository;

    @Test
    public void saveClaimTest() throws Exception {
        Business business=businessRepository.findByBusinessName("TIMF");
        Claim claim = new Claim();
        VOC voc=new VOC();
        voc.setRegDate(LocalDateTime.now());
        voc.setDriverChk("N");
        voc.setPenalty(null);
        voc.setReasonChk("-1");
        claim.setClaimType(1);
        claim.setClaimContent("배송 지연");
        claim.setReimburseChk("Y");
        claim.setBusiness(business);
        claim.setVoc(voc);
        voc.setClaim(claim);

        //MediaType TYPE=new MediaType(MediaType.APPLICATION_JSON, Charset.forName("utf8"));
        ObjectMapper mapper=new ObjectMapper().registerModule(new JavaTimeModule());
        String json=mapper.writeValueAsString(claim);

        mockMvc.perform(
                MockMvcRequestBuilders.post("http://localhost:8089/claim/register/TIMF")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(json)
        ).andExpect(
                MockMvcResultMatchers.status().is2xxSuccessful()
        ).andDo(
                MockMvcResultHandlers.print()
        );
    }


    //클레임 조회
    @Test
    public void searchRegisteredClaim() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("http://localhost:8089/claim/searchBy/business")
                        .param("businessName","TIMF")
        ).andExpect(
                MockMvcResultMatchers.status().is2xxSuccessful()
        ).andDo(
                MockMvcResultHandlers.print()
        );
    }
}