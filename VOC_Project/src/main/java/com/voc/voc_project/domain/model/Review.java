package com.voc.voc_project.domain.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author  jisooJeong
 * */
@Table(name="REVIEW")
@Entity
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="REVIEW_ID")
    private Long reviewId;

    @Column(name="REVIEW_REGDATE")
    private LocalDateTime regDate;

    @OneToOne
    @JoinColumn(name="VOC_ID")
    @ToString.Exclude
    private VOC voc;

    @PrePersist
    public void setPersistDate(){
        this.setRegDate(LocalDateTime.now());
    }
}
