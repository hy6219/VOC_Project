package com.voc.voc_project.controller;

import com.voc.voc_project.domain.model.Driver;
import com.voc.voc_project.domain.model.Retail;
import com.voc.voc_project.domain.model.VOC;
import com.voc.voc_project.service.VocService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Api(tags = "VOC 기록 관리 API(등록된 VOC 수정시 검토/배상건 관리도 진행)")
@RestController
@RequestMapping("/voc")
public class VocController {
    @Autowired
    private VocService vocService;

    /**
     * 귀책 조사 반영하기
     * */
    @ApiOperation(value="귀책조사 여부 반영 및 배상/검토 건 등록 API")
    @PutMapping("/reasonChk/record")
    public void recordReasonChk(@RequestParam Long vocId, @RequestParam String target,
                                @RequestParam int reimTot, @RequestParam String driverChk,
                                @RequestParam String penaltyChk, @RequestParam String disagree,
                                @RequestParam Long retailId, @RequestParam Long driverId){
        vocService.recordReasonChk(vocId,target,reimTot,driverChk,penaltyChk,disagree,retailId,driverId);
    }

    //현재까지 존재하는 voc 기록 조회
    @ApiOperation(value="현재까지 등록된 VOC 리스트 조회 API")
    @GetMapping("/search/vocList")
    public ResponseEntity<ArrayList<VOC>> searchAllVoc(){
        ResponseEntity<ArrayList<VOC>> response=vocService.searchAllVoc();
        return response;
    }

}
