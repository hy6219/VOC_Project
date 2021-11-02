package com.voc.voc_project.service;

import com.voc.voc_project.domain.model.*;
import com.voc.voc_project.domain.repository.BusinessRepository;
import com.voc.voc_project.domain.repository.ClaimRepository;
import com.voc.voc_project.domain.repository.VOCRepository;
import com.voc.voc_project.domain.repository.VocHistRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Slf4j
public class ClaimService {
    @Autowired
    private ClaimRepository claimRepository;
    @Autowired
    private BusinessRepository businessRepository;
    @Autowired
    private CsService csService;
    @Autowired
    private VOCRepository vocRepository;
    @Autowired
    private VocHistRepository vocHistRepository;

    //클레임 등록
    public void saveClaim(Claim claim,String businessName){
       claimRepository.save(claim);
       //클레임 분류에 맞는 직원을 배치
        int type=claim.getClaimType();
        CS employee=csService.matchingToService(type);
        VOC voc = new VOC();
        voc.setEmployee(employee);
        voc.setClaim(claim);
        Hist hist=new Hist();
        hist.setVoc(voc);
        vocRepository.save(voc);
        vocHistRepository.save(hist);
        log.info("[클레임 인입완료][VOC 등록][VOC 히스토리 기록 시작]");
        log.info("VOC: {}",voc);
    }

    //클레임 조회
    public ResponseEntity<ArrayList<Claim>> searchClaim(String businessName){
        Business business=businessRepository.findByBusinessName(businessName);
        ArrayList<Claim> list=claimRepository.findAllByBusiness(business);
        ResponseEntity<ArrayList<Claim>> response=ResponseEntity.ok(list);
        return response;
    }


}
