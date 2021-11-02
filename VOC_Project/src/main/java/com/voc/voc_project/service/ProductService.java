package com.voc.voc_project.service;

import com.voc.voc_project.domain.model.Business;
import com.voc.voc_project.domain.model.Product;
import com.voc.voc_project.domain.repository.BusinessRepository;
import com.voc.voc_project.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private BusinessRepository businessRepository;

    //고객사별 거래 내역 조회
    public ResponseEntity<ArrayList<Product>> productsByBusiness(String businessName){
        //먼저 고객사를 조회
        Business business=businessRepository.findByBusinessName(businessName);
        //그다음에 고객사별 거래내역을 조회
        ArrayList<Product> list=productRepository.findAllByBusiness(business);
        ResponseEntity<ArrayList<Product>> response=ResponseEntity.ok(list);
        return response;
    }
}
