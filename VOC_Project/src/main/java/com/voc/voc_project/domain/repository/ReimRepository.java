package com.voc.voc_project.domain.repository;

import com.voc.voc_project.domain.model.Reim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReimRepository extends JpaRepository<Reim,Long> {
}
