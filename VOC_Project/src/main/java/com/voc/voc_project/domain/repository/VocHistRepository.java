package com.voc.voc_project.domain.repository;

import com.voc.voc_project.domain.model.Hist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VocHistRepository  extends JpaRepository<Hist,Long> {

}
