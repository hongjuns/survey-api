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

    @Column(name="title")
    private String title;

    @Column(name="questionid")
    private String questionid;

    @Column(name="questionvalue")
    private String questionvalue;

    @ManyToOne(targetEntity = SurveyEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "questionseq")
    @OrderBy(value = "seq ASC")
    private SurveyEntity survey; // 연관관계 지정


}
