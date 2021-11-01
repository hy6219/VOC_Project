package com.voc.voc_project.service;

import com.voc.voc_project.domain.model.CS;
import com.voc.voc_project.domain.repository.CSRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CsService {
    @Autowired
    private CSRepository csRepository;

    public ArrayList<CS> matchingToService(int part,String afford,String atWork){
        return csRepository.findAllByPartAndAffordAndAtWork(part, afford, atWork);
    }
}
