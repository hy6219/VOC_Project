package com.voc.voc_project.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Table(name="voc")
@Entity
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class VOC {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="VOC_ID")
    private Long vocId;

    @Column(name="REASON_CHK")
    private String reasonChk;

    @Column(name="VOC_TARGET")
    private String target;

    @Column(name="VOC_PENALTY")
    private String penalty;

    @Column(name="VOC_REIM")
    private int reimTot;

    @Column(name="DRIVER_CHK")
    private String driverChk;

    @Column(name="DRIVER_PCHK")
    private String penaltyChk;

    @Column(name="DRIVER_DISAGREE")
    private String disagree;

    @Column(name="VOC_REGDATE")
    private LocalDateTime regDate;

    @Column(name="VOC_RECENT")
    private LocalDateTime recent;

    @ManyToOne
    @JoinColumn(name = "EID")
    @ToString.Exclude
    private CS employee;


    @OneToOne(mappedBy = "voc")
    @ToString.Exclude
    private Reim reim;

    @JsonManagedReference
    @OneToOne
    @ToString.Exclude
    private Claim claim;


    @OneToOne(mappedBy = "voc")
    @ToString.Exclude
    private Review review;

    @ManyToOne
    @JoinColumn(name="DRIVER_ID")
    @ToString.Exclude
    private Driver driver;

    @ManyToOne
    @JoinColumn(name="RETAIL_ID")
    @ToString.Exclude
    private Retail retail;

    /*
    이벤트리스너를 이용해서 날짜는 자동세팅될 수 있도록 설정
    * */
    @PrePersist
    public void setDefaultDate(){
        this.setRegDate(LocalDateTime.now());
        this.setRecent(LocalDateTime.now());
    }

    @PostUpdate
    public void setUpdateDate(){
        this.setRegDate(LocalDateTime.now());
    }

}
