package com.voc.voc_project.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

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

    @ApiModelProperty(value = "기사 확인 여부[-1: 귀책사유 조사하지 않았음 0: 귀책사유 조사하는 중, 1: 귀책사유 조사 완료]",example = "0")
    @Column(name="REASON_CHK")
    private String reasonChk;

    @ApiModelProperty(value = "귀책 담당자[R:운송사, D:기사]",example = "R")
    @Column(name="VOC_TARGET")
    private String target;

    @ApiModelProperty(value = "패널티 내용",example = "조사완료")
    @Column(name="VOC_PENALTY")
    private String penalty;

    @ApiModelProperty(value="보상금액",example = "100000")
    @Column(name="VOC_REIM")
    private Integer reimTot;

    @ApiModelProperty(value="기사 확인 여부[ -1 : 기사님 학인하지 않은 상태 0: 확인한 상태]",example = "0")
    @Column(name="DRIVER_CHK")
    private String driverChk;

    @ApiModelProperty(value="기사 패널티 확인 여부[ -1 : 기사님 학인하지 않은 상태 0: 확인한 상태]",example = "-1")
    @Column(name="DRIVER_PCHK")
    private String penaltyChk;

    @ApiModelProperty(value="이의제기여부(기사님)[ -1: 확인하기 전이라서 이의 제기 여부 확인이 어려운 경우, N:이의제기X,Y:이의제기O]",example = "N")
    @Column(name="DRIVER_DISAGREE")
    private String disagree;

    @ApiModelProperty(value = "VOC 등록일")
    @Column(name="VOC_REGDATE")
    private LocalDateTime regDate;

    @ApiModelProperty(value="VOC 최근 수정일")
    @Column(name="VOC_RECENT")
    private LocalDateTime recent;

    @ManyToOne
    @JoinColumn(name = "EID")
    @ToString.Exclude
    private CS employee;

    @JsonBackReference
    @OneToOne
    @JoinColumn(name="REIM_ID")
    @ToString.Exclude
    private Reim reim;

    @JsonManagedReference
    @OneToOne
    @JoinColumn(name="CLAIM_ID")
    @ToString.Exclude
    private Claim claim;

    @JsonBackReference
    @OneToOne
    @JoinColumn(name="REVIEW_ID")
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
