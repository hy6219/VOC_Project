package com.voc.voc_project.service;

import com.voc.voc_project.domain.model.Review;
import com.voc.voc_project.domain.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    public ResponseEntity<ArrayList<Review>> searchAll(){
        ArrayList<Review> list= (ArrayList<Review>) reviewRepository.findAll();
        ResponseEntity<ArrayList<Review>> response=ResponseEntity.ok(list);
        return response;
    }
}
