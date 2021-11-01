package com.voc.voc_project.domain.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name="PRODUCT")
@Entity
@NoArgsConstructor
@Data
@ToString(callSuper = false)
@EqualsAndHashCode(callSuper = false)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="PRODUCT_ID")
    private Long productId;

    @Column(name="PRODUCT_TYPE")
    private int productType;

    @Column(name="PRODUCT_NAME")
    private String productName;

    @Column(name="PRODUCT_CODE")
    private String productCode;

    @Column(name="PRODUCT_RECDATE")
    private LocalDateTime recTime;

    @Column(name="PRODUCT_DEPOSIT_CHK")
    private String depositChk;

    @ManyToOne
    @JoinColumn(name="BUSINESS_ID")
    @ToString.Exclude
    private Business business;
}
