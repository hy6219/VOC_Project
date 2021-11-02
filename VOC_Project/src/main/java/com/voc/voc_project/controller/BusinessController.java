package com.voc.voc_project.controller;

import com.voc.voc_project.domain.model.Business;
import com.voc.voc_project.service.BusinessService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "고객사 정보 조회 API")
@RestController
@RequestMapping("/business")
public class BusinessController {
    /**
     * 거래사 정보 조회
     * */
    @Autowired
    private BusinessService businessService;

    @ApiOperation(value="고객사 정보 조회")
    @ApiImplicitParam(name="businessName",value="고객사 이름")
    @GetMapping("/search/client")
    public ResponseEntity<Business> searchOurClient(@RequestParam String businessName){
        ResponseEntity<Business> client=businessService.searchOurClient(businessName);
        return client;
    }
}
