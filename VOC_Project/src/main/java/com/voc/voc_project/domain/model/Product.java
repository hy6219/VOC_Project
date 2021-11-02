package com.voc.voc_project.domain.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name="PRODUCT")
@Entity
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="PRODUCT_ID")
    private Long productId;

    @ApiModelProperty(value = "물품 분류[0: 화물, 1: 신선식품, 2: 식자재]")
    @Column(name="PRODUCT_TYPE")
    private int productType;

    @ApiModelProperty(value = "물품명",example = "맛있는 영희네 핫도그")
    @Column(name="PRODUCT_NAME")
    private String productName;

    @ApiModelProperty(value = "물품 코드",example = "ABC123")
    @Column(name="PRODUCT_CODE")
    private String productCode;

    @ApiModelProperty(value = "거래일자")
    @Column(name="PRODUCT_RECDATE")
    private LocalDateTime recTime;

    @ApiModelProperty(value = "입금확인여부[Y:입금확인O,N:입금확인X]",example = "Y")
    @Column(name="PRODUCT_DEPOSIT_CHK")
    private String depositChk;

    @ManyToOne
    @JoinColumn(name="BUSINESS_ID")
    private Business business;
}
