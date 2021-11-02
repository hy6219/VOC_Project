package com.voc.voc_project.domain.repository;

import com.voc.voc_project.domain.model.VOC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VOCRepository extends JpaRepository<VOC,Long> {
}
