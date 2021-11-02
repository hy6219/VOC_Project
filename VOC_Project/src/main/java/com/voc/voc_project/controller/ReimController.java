package com.voc.voc_project.controller;

import com.voc.voc_project.domain.model.Reim;
import com.voc.voc_project.service.ReimService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@Api(tags = "보상(배상) 건을 관리하는 API")
@RestController
@RequestMapping("/reimbursement")
@Slf4j
public class ReimController {
    /**
     *ClaimController와 VocController에서 대부분의 등록 절차가 진행되었기 때문에
     * 이의 결과물인
     * ReviewController과 ReimController에서는 결과조회만을 수행하도록 하겠습니다
     * */
    @Autowired
    private ReimService reimService;

    //모든 보상(배상)건들을 조회
    @ApiOperation(value="현재까지 진행된 모든 보상/배상 건들을 조회하는 API")
    @GetMapping("/search/list")
    public ResponseEntity<ArrayList<Reim>> searchAll(){
        ResponseEntity<ArrayList<Reim>> response=reimService.searchAll();
        log.info("[현재까지 진행된 모든 보상/배상 건: {}]",response);
        return response;
    }
}
