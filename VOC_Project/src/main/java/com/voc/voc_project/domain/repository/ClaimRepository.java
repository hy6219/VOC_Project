package com.voc.voc_project.domain.repository;

import com.voc.voc_project.domain.model.Business;
import com.voc.voc_project.domain.model.Claim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ClaimRepository extends JpaRepository<Claim,Long> {
    //클레임 조회(고객사정보로 접근)
    ArrayList<Claim> findAllByBusiness(Business business);
}
