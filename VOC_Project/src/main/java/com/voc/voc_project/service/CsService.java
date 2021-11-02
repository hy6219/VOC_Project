package com.voc.voc_project.service;

import com.voc.voc_project.domain.model.CS;
import com.voc.voc_project.domain.repository.CSRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CsService {
    @Autowired
    private CSRepository csRepository;

    public CS matchingToService(int part){
        ArrayList<CS> candidate= csRepository.findAllByPartAndAffordAndAtWork(part, "Y", "Y");
        int idx=0;
        ResponseEntity<CS> response;
        idx=(int)Math.random()* candidate.size()+1;
        //afford가 모두 N일 수도 있는데, 그때에는 우선 배치를 해둔 후 대기하는 것으로
        if(idx>=1){
            idx--;
        }
        CS target=candidate.get(idx);
        return target;
    }
}
