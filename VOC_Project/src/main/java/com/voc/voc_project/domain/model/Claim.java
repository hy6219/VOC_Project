package com.voc.voc_project.domain.model;

import lombok.*;

import javax.persistence.*;

/**
 * @author  jisooJeong
 * */
@Table(name="CLAIM")
@Entity
@NoArgsConstructor
@Data
@ToString(callSuper = false)
@EqualsAndHashCode(callSuper = false)
public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToOne
    @JoinColumn(name="RETAIL_ID")
    @ToString.Exclude
    private Retail retail;

    @ManyToOne
    @JoinColumn(name="DRIVER_ID")
    @ToString.Exclude
    private Driver driver;

    @ManyToOne
    @ToString.Exclude
    private VOC voc;
}
