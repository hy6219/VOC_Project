package com.voc.voc_project.controller;

import com.voc.voc_project.domain.model.Hist;
import com.voc.voc_project.domain.model.VOC;
import com.voc.voc_project.service.VocHistService;
import com.voc.voc_project.service.VocService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Api(tags = "VOC 진행 중 기록된 모든 과정을 확인할 수 있는 API")
@RestController
@RequestMapping("/voc/hist")
@Slf4j
public class HistController {
    /**
     * ClaimController와 VocController 등에서
     * 수정과정을 거칠때마다 히스토리 테이블에 저장하였기 때문에
     * 이 컨트롤러에서는 히스토리 테이블에 저장된 데이터를 확인하는 과정만 진행하도록 하겠습니다
     * */

    @Autowired
    private VocHistService vocHistService;

    @ApiOperation(value="VOC 히스토리 확인 API")
    @GetMapping("/search/list")
    public ResponseEntity<ArrayList<Hist>> searchAll(){
        ResponseEntity<ArrayList<Hist>> response=vocHistService.searchAll();
        log.info("[현재까지 기록된 VOC 기록들 :{}]",response);
        return response;
    }
}
