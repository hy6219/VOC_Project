package com.voc.voc_project.service;

import com.voc.voc_project.domain.model.Business;
import com.voc.voc_project.domain.repository.BusinessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BusinessService {
    @Autowired
    private BusinessRepository businessRepository;

    public ResponseEntity<Business> searchOurClient(String businessName){
        Business business=businessRepository.findByBusinessName(businessName);
        ResponseEntity<Business> response=ResponseEntity.ok(business);
        return response;
    }
}
