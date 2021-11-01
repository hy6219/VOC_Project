package com.voc.voc_project.domain.repository;

import com.voc.voc_project.domain.model.CS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface CSRepository extends JpaRepository<CS,Long> {
    //클레임분류+여유여부+근무여부로 찾기
    ArrayList<CS> findAllByPartAndAffordAndAtWork(int part,String afford,String atWork);
}
