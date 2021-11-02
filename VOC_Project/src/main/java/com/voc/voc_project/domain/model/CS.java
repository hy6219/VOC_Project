package com.voc.voc_project.domain.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;


@Table(name="CS")
@Entity
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class CS {
    @ApiModelProperty(value="고객 지원부 식별자")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="EID")
    private Long eId;

    @ApiModelProperty(value="클레임 분류[0:고객변심, 1: 배송지연, 2:상품문제]",example = "2")
    @Column(name="EPART")
    private int part;

    @ApiModelProperty(value="직원 이름",example = "김길동")
    @Column(name="ENAME")
    private String eName;

    @ApiModelProperty(value="이메일",example = "abc@defg.hr")
    @Column(name="EMAIL")
    private String email;

    @ApiModelProperty(value="직원이 현재 업무를 수용할수 있다면, 해당 값을 직원이 설정해둘 것입니다[Y:여유,N:여유없음]",example = "Y")
    @Column(name="AFFORD")
    private String afford;

    @ApiModelProperty(value="직원이 휴가 중 등의 이유로 업무를 진행할 수 없는지를 표기합니다[Y:업무가능, N:업무불가]",example = "Y")
    @Column(name="AT_WORK")
    private String atWork;
}
