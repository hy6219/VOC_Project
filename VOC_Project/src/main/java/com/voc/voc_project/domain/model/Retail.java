package com.voc.voc_project.domain.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;

/**
 * @author  jisooJeong
 * */
@Table(name="RETAIL")
@Entity
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class Retail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="RETAIL_ID")
    private Long retailId;

    @ApiModelProperty(value="운송사 이름",example = "팀파이브")
    @Column(name="RETAIL_NAME")
    private String retailName;

    @ApiModelProperty(value="운송사 대표",example ="김길동")
    @Column(name="CEO")
    private String ceo;

    @ApiModelProperty(value = "운송사 연락처",example = "02-000-0000")
    @Column(name="RETAIL_PUBTEL")
    private String retailTel;

    @ApiModelProperty(value="운송사 주소",example = "서울특별시 가나다구 가나다동")
    @Column(name="RETAIL_ADDR")
    private String retailAddr;

}
