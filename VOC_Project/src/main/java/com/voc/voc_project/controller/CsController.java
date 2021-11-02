package com.voc.voc_project.controller;

import com.voc.voc_project.domain.model.CS;
import com.voc.voc_project.service.CsService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@Api(tags = "고객 관리부 내에서 클레임 분류에 따른 직원 배치도에 대한 API 입니다")
@RestController
@RequestMapping("/cs")
public class CsController {
    /**
     * 간단하게 직원조회 기능만 진행되는 컨트롤러로 설정해두겠습니다
     * 이에 해당될 데이터는 더미데이터로 넣고 시작했습니다
     * 더미 데이터는 메모리로 넣지 않았습니다. 해당 부분은 README.md에 기재해두었습니다
     * */
    @Autowired
    private CsService csService;

    @ApiOperation(value="클레임 분류, 클레임 요청을 받을 여유가 있는지, 근무중인지를 조회")
    @ApiImplicitParam(name="part",value="클레임 분류[0:고객변심, 1: 배송지연, 2:상품문제]")
    @ApiResponses({
            @ApiResponse(code = 200, message = "서버 정상 작동"),
            @ApiResponse(code = 400, message = "입력을 확인해주시거나, 요청 경로를 확인부탁드립니다"),
            @ApiResponse(code = 500, message = "서버 관리자에게 확인부탁드립니다")
    })
    @GetMapping("/matching")
    public ResponseEntity<CS> matching(@RequestParam int part){
        CS candidate=csService.matchingToService(part);

        ResponseEntity<CS> response=ResponseEntity.status(HttpStatus.OK).body(candidate);
        return response;
    }

}
