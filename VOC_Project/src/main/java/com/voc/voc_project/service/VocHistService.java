package com.voc.voc_project.service;

import com.voc.voc_project.domain.model.Hist;
import com.voc.voc_project.domain.repository.VocHistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class VocHistService {

    @Autowired
    private VocHistRepository vocHistRepository;

    public ResponseEntity<ArrayList<Hist>> searchAll(){
        ArrayList<Hist> list= (ArrayList<Hist>) vocHistRepository.findAll();
        ResponseEntity<ArrayList<Hist>> response=ResponseEntity.ok(list);
        return response;
    }

}
