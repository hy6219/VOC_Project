package com.voc.voc_project.domain.repository;

import com.voc.voc_project.domain.model.Business;
import com.voc.voc_project.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    //고객사별 거래 내역 조회
    ArrayList<Product> findAllByBusiness(Business business);
}
