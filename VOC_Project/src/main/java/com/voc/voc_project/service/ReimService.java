package com.voc.voc_project.service;

import com.voc.voc_project.domain.model.Reim;
import com.voc.voc_project.domain.repository.ReimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ReimService {
    @Autowired
    private ReimRepository reimRepository;

    public ResponseEntity<ArrayList<Reim>> searchAll(){
        ArrayList<Reim> list= (ArrayList<Reim>) reimRepository.findAll();
        ResponseEntity<ArrayList<Reim>> response=ResponseEntity.ok(list);
        return response;
    }
}
