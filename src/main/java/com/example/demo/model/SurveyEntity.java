package com.example.demo.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="TB_SURVEY")
public class SurveyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="seq")
    private Long seq;

    @Column(name="bizid")
    private String bizid;

    @Column(name="questionseq")
    private Long questionseq;

    @Column(name="answerseq")
    private Long answerseq;

    @Column(name="secretkey")
    private String secretkey;

    @Column(name="regdt")
    private LocalDateTime regdt;


}
