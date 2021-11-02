package com.voc.voc_project.domain.repository;

import com.voc.voc_project.domain.model.Retail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface RetailRepository extends JpaRepository<Retail,Long> {
    ArrayList<Retail> findAllByRetailIdGreaterThan(Long id);
}
