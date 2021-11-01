package com.voc.voc_project.domain.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author  jisooJeong
 * */
@Table(name="VOC_HIST")
@Entity
@NoArgsConstructor
@Data
@ToString(callSuper = false)
@EqualsAndHashCode(callSuper = false)
public class Hist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="HIST_ID")
    private Long histId;

    @Column(name="HIST_REGDATE")
    private LocalDateTime regDate;

    @ManyToOne
    @JoinColumn(name="VOC_ID")
    @ToString.Exclude
    private VOC voc;

    @PrePersist
    @PostUpdate
    public void updateDateForHistoryData(){
        this.setRegDate(LocalDateTime.now());
    }
}
