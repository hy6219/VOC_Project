package com.voc.voc_project.service;

import com.voc.voc_project.domain.model.Hist;
import com.voc.voc_project.domain.model.VOC;
import com.voc.voc_project.domain.repository.VOCRepository;
import com.voc.voc_project.domain.repository.VocHistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VocService {
    @Autowired
    private VOCRepository vocRepository;
    @Autowired
    private VocHistRepository vocHistRepository;

    //저장
    public void saveVoc(VOC voc){
        Hist hist=new Hist();
        hist.setVoc(voc);
        vocRepository.save(voc);
        vocHistRepository.save(hist);
    }
}
