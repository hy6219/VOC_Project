package com.voc.voc_project.domain.model;

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
@ToString(callSuper = false)
@EqualsAndHashCode(callSuper = false)
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="DRIVER_ID")
    private Long driverId;

    @Column(name="DRIVER_NAME")
    private String driverName;

    @Column(name="DRIVER_TEL")
    private String driverTel;

    @Column(name="DRIVER_ADDR")
    private String driverAddr;

    @Column(name="DRIVER_SALARY")
    private int originSal;

    @Column(name="DRIVER_CLSAL")
    private int clSal;

    @ManyToOne
    @JoinColumn(name="RETAIL_ID")
    @ToString.Exclude
    private Retail retail;


}
