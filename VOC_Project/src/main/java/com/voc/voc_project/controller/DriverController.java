package com.voc.voc_project.controller;

import com.voc.voc_project.domain.model.Driver;
import com.voc.voc_project.service.DriverService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Api(tags = "등록된 기사 정보 확인 API")
@RestController
@RequestMapping("/retail/drivers/info")
@Slf4j
public class DriverController {
    //등록된 기사 조회
    @Autowired
    private DriverService driverService;

    @ApiOperation(value="모든 기사 정보를 확인하는 API")
    @GetMapping("/search")
    public ResponseEntity<ArrayList<Driver>> searchAllDrivers(){
        ResponseEntity<ArrayList<Driver>> drivers=driverService.searchAllDrivers();
        log.info("[현재 서버에 등록된 모든 기사 정보는 아래와 같습니다]");
        log.info("[기사 정보: {}]",drivers);
        return drivers;
    }

    //고객사별 등록된 기사 정보 확인
    @ApiOperation(value="운송사별 기사 정보를 확인하는 API")
    @ApiImplicitParam(name = "retailId",value = "운송사 id")
    @GetMapping("/searchByRetail")
    public ResponseEntity<ArrayList<Driver>> searchDriversByRetailCompany(@RequestParam Long retailId){
        ResponseEntity<ArrayList<Driver>> drivers=driverService.searchDriversByRetailCompany(retailId);
        log.info("[운송사 식별자: {}]",retailId);
        log.info("[운송사별 기사 정보: {}]",drivers);
        return drivers;
    }
}
