package com.voc.voc_project.domain.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;

/**
 * @author  jisooJeong
 * */
@Table(name="DRIVER")
@Entity
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="DRIVER_ID")
    private Long driverId;

    @ApiModelProperty(value = "기사 이름",example = "홍길동")
    @Column(name="DRIVER_NAME")
    private String driverName;

    @ApiModelProperty(value = "기사 연락처",example = "010-1234-5678")
    @Column(name="DRIVER_TEL")
    private String driverTel;

    @ApiModelProperty(value = "기사 주소",example = "서울특별시 가나다구 가나다동")
    @Column(name="DRIVER_ADDR")
    private String driverAddr;

    @ApiModelProperty(value = "클레임 없을 경우 월급",example="2000000")
    @Column(name="DRIVER_SALARY")
    private int originSal;

    @ApiModelProperty(value = "클레임이 있을 경우 적용되는 월급",example = "1500000")
    @Column(name="DRIVER_CLSAL")
    private int clSal;

    @ManyToOne
    @JoinColumn(name="RETAIL_ID")
    @ToString.Exclude
    private Retail retail;


}
