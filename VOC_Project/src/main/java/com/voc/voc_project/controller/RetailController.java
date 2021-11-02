package com.voc.voc_project.controller;

import com.voc.voc_project.domain.model.Retail;
import com.voc.voc_project.service.RetailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@Api(tags = "운송사 정보 API")
@RestController
@RequestMapping("/retail")
@Slf4j
public class RetailController {

    @Autowired
    private RetailService retailService;
    //모든 운송사 정보 찾기
    @ApiOperation(value="모든 운송사 정보 찾기")
    @GetMapping("/list")
    public ResponseEntity<ArrayList<Retail>> searchAllRetail(){
        ResponseEntity<ArrayList<Retail>> response=retailService.searchAllRetail();
        log.info("[모든 운송사 정보 확인:{}]",response);
        return response;
    }
    //운송사 id로 운송사 정보 찾기
    @ApiOperation(value="운송사 id로 운송사 정보 찾기")
    @GetMapping("/searchById")
    public ResponseEntity<Retail> searchByRetailId(@RequestParam Long retailId){
        ResponseEntity<Retail> response=retailService.searchByRetailId(retailId);
        log.info("[운송사 id로 운송사 정보 확인:{}]",response);
        return response;
    }
}
