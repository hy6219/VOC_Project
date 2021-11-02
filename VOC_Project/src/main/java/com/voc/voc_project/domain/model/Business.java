package com.voc.voc_project.domain.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;

@Table(name="BUSINESS")
@Entity
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class Business {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="BUSINESS_ID")
    private Long businessId;

    @ApiModelProperty(value="고객사 코드", example="AA12345")
    @Column(name="BUSINESS_CODE")
    private String businessCode;

    @ApiModelProperty(value="고객사 이름",example = "abc")
    @Column(name="BUSINESS_NAME")
    private String businessName;

    @ApiModelProperty(value="고객사 연락처", example = "02-1234-5678")
    @Column(name="BUSINESS_TEL")
    private String businessTel;

    @ApiModelProperty(value="고객사 주소",example = "서울특별시 가나다구 가나다동")
    @Column(name="BUSINESS_ADDR")
    private String businessAddr;

}
