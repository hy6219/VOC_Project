package com.voc.voc_project.service;

import com.voc.voc_project.domain.model.Driver;
import com.voc.voc_project.domain.model.Retail;
import com.voc.voc_project.domain.repository.DriverRepository;
import com.voc.voc_project.domain.repository.RetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DriverService {

    @Autowired
    private DriverRepository driverRepository;
    @Autowired
    private RetailRepository retailRepository;

    public ResponseEntity<ArrayList<Driver>> searchAllDrivers(){
        ArrayList<Driver> list= driverRepository.findAllByDriverIdGreaterThan(1L);
        ResponseEntity<ArrayList<Driver>> drivers=ResponseEntity.ok(list);
        return drivers;
    }

    public ResponseEntity<ArrayList<Driver>> searchDriversByRetailCompany(Long retailId){
        Retail retail=retailRepository.findById(retailId).orElseThrow(RuntimeException::new);
        ArrayList<Driver> drivers=driverRepository.findAllByRetail(retail);
        ResponseEntity<ArrayList<Driver>> response=ResponseEntity.ok(drivers);
        return response;
    }
}
