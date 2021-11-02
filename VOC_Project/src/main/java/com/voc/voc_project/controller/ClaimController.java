package com.voc.voc_project.controller;

import com.voc.voc_project.domain.model.Claim;
import com.voc.voc_project.service.ClaimService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Api(tags = "클레임 등록(VOC 및 히스토리 포함 등록), 조회 API")
@RestController
@RequestMapping("/claim")
public class ClaimController {
    /*
    * 1.고객사가 클레임을 등록
    * 2.클레임 조회
    * */
    @Autowired
    private ClaimService claimService;

    @ApiOperation(value="고객사의 클레임 등록")
    @ApiImplicitParam(name="claim",value="고객사 정보를 포함한 클레임 정보")
    @PostMapping(value = "/register/{businessName}",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveClaim(@ModelAttribute Claim claim,@PathVariable(name="businessName") String businessName){
        claimService.saveClaim(claim,businessName);
    }

    @ApiOperation(value="고객사별 클레임 조회 API")
    @ApiImplicitParam(name="businessName", value = "고객사 이름")
    @GetMapping("/searchBy/business")
    public ResponseEntity<ArrayList<Claim>> searchClaim(String businessName){
        ResponseEntity<ArrayList<Claim>> response=claimService.searchClaim(businessName);
        return response;
    }
}
