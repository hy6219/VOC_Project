package com.voc.voc_project.controller;

import com.voc.voc_project.domain.model.Product;
import com.voc.voc_project.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@Api(tags = "물품 거래 정보 API")
@RestController
@RequestMapping("/products")
public class ProductController {
    /**
     * 클레임 이후 귀책조사에 필요한 고객사별 거래 내역 조회
     * */
    @Autowired
    private ProductService productService;

    @ApiOperation(value="고객사별 물품 조회 API")
    @ApiImplicitParam(name="businessName", value="고객사 이름")
    @GetMapping("/searchBy/business")
    public ResponseEntity<ArrayList<Product>> productsByBusiness(@RequestParam String businessName){
        ResponseEntity<ArrayList<Product>> response=productService.productsByBusiness(businessName);
        return response;
    }
}
