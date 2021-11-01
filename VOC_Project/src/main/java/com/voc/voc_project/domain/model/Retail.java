package com.voc.voc_project.domain.model;

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
@ToString(callSuper = false)
@EqualsAndHashCode(callSuper = false)
public class Retail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="RETAIL_ID")
    private Long retailId;

    @Column(name="RETAIL_NAME")
    private String retailName;

    @Column(name="CEO")
    private String ceo;

    @Column(name="RETAIL_PUBTEL")
    private String retailTel;

    @Column(name="RETAIL_ADDR")
    private String retailAddr;

}
