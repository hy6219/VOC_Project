package com.voc.voc_project.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;

/**
 * @author  jisooJeong
 * */
@Table(name="claim")
@Entity
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="CLAIM_ID")
    private Long claimId;

    @Column(name="CLAIM_TYPE")
    private int claimType;

    @Column(name="CLAIM_CONTENT")
    private String claimContent;

    @Column(name="CLAIM_REIMBURSE")
    private String reimburseChk;

    @ManyToOne
    @JoinColumn(name="BUSINESS_ID")
    @ToString.Exclude
    private Business business;

    @JsonBackReference
    @OneToOne(mappedBy = "claim")
    @ToString.Exclude
    private VOC voc;
}
