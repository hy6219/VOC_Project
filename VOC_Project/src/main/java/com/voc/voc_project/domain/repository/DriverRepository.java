package com.voc.voc_project.domain.repository;

import com.voc.voc_project.domain.model.Driver;
import com.voc.voc_project.domain.model.Retail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface DriverRepository extends JpaRepository<Driver,Long> {
    ArrayList<Driver> findAllByRetail(Retail retail);
    ArrayList<Driver> findAllByDriverIdGreaterThan(Long id);
}
