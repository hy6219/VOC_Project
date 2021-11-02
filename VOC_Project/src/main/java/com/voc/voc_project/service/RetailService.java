package com.voc.voc_project.service;

import com.voc.voc_project.domain.model.Retail;
import com.voc.voc_project.domain.repository.RetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class RetailService {
    @Autowired
    private RetailRepository retailRepository;

    public ResponseEntity<ArrayList<Retail>> searchAllRetail(){
        ArrayList<Retail> list= (ArrayList<Retail>) retailRepository.findAllByRetailIdGreaterThan(1L);
        ResponseEntity<ArrayList<Retail>> retails=ResponseEntity.ok(list);
        return retails;
    }

    public ResponseEntity<Retail> searchByRetailId(Long retailId){
        Retail retail=retailRepository.findById(retailId).orElseThrow(RuntimeException::new);
        ResponseEntity<Retail> response=ResponseEntity.ok(retail);
        return response;
    }
}
