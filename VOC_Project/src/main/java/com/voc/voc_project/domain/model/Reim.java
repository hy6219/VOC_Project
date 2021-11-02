package com.voc.voc_project.domain.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author  jisooJeong
 * */
@Table(name="REIM")
@Entity
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class Reim {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="REIM_ID")
    private Long reimId;

    @Column(name="REIM_DATE")
    private LocalDateTime regDate;

    @JsonManagedReference
    @OneToOne
    @JoinColumn(name="VOC_ID")
    private VOC voc;

    @PrePersist
    public void setPersistDate(){
        this.setRegDate(LocalDateTime.now());
    }
}
