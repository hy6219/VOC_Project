package com.voc.voc_project.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.annotations.ApiModelProperty;
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

    @ApiModelProperty(value="클레임 분류[0:고객변심, 1: 배송지연, 2:상품문제]",example = "1")
    @Column(name="CLAIM_TYPE")
    private int claimType;

    @ApiModelProperty(value="클레임 내용 상세",example = "고객변심")
    @Column(name="CLAIM_CONTENT")
    private String claimContent;

    @ApiModelProperty(value="배상 요청 여부[N:배상요청X,Y:배상요청O]", example = "Y")
    @Column(name="CLAIM_REIMBURSE")
    private String reimburseChk;

    @ManyToOne
    @JoinColumn(name="BUSINESS_ID")
    @ToString.Exclude
    private Business business;

    @JsonBackReference
    @OneToOne
    @JoinColumn(name="VOC_ID")
    @ToString.Exclude
    private VOC voc;
}
