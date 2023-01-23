package com.example.demo.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="TB_QUESTIONDETAIL")
@ToString(exclude = "survey")
public class QuestionDetailEntity {
    @Id
    @Column(name="seq")
    private Long seq;

    @Column(name="type")
    private String type;

    @Column(name="question")
    private String question;

    @Column(name="useyn")
    private String useYn;

    @ManyToOne(targetEntity = SurveyEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "questionseq")
    private SurveyEntity survey; // 연관관계 지정


}
