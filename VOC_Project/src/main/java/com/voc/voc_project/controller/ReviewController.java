package com.voc.voc_project.controller;

import com.voc.voc_project.domain.model.Review;
import com.voc.voc_project.service.ReviewService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@Api(tags = "검토할 대상으로 반영된 건들을 확인하는 API")
@RestController
@RequestMapping("/review")
@Slf4j
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    /**
     *ClaimController와 VocController에서 대부분의 등록 절차가 진행되었기 때문에
     * 이의 결과물인
     * ReviewController과 ReimController에서는 결과조회만을 수행하도록 하겠습니다
     * */
    @ApiOperation(value="검토건을 조회하는 API")
    @GetMapping("/search/list")
    public ResponseEntity<ArrayList<Review>> searchAll(){
        ResponseEntity<ArrayList<Review>> response=reviewService.searchAll();
        log.info("[검토 건 모두 조회: {}]",response);
        return response;
    }

}
