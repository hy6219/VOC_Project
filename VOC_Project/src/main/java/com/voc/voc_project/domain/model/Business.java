package com.voc.voc_project.domain.model;

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

    @Column(name="BUSINESS_CODE")
    private String businessCode;

    @Column(name="BUSINESS_NAME")
    private String businessName;

    @Column(name="BUSINESS_TEL")
    private String businessTel;

    @Column(name="BUSINESS_ADDR")
    private String businessAddr;

}
