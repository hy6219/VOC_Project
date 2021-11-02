package com.voc.voc_project.domain.repository;

import com.voc.voc_project.domain.model.Business;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessRepository extends JpaRepository<Business,Long> {
    //고객사 조회
    Business findByBusinessName(String businessName);
}
