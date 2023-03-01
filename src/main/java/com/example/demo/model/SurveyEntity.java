package com.example.demo.model;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="TB_SURVEY")
public class SurveyEntity implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="survey_seq")
    private Long surveySeq;

    @Column(name="user_nm")
    private String userNm;

    @Column(name="question_seq")
    private Long questionSeq;

    @Column(name="answer_seq")
    private Long answerSeq;

    @Column(name="secret_key")
    private String secretKey;

    @Column(name="reg_dt")
    private LocalDateTime regDt;

    @OneToMany
    @JoinColumn(name = "question_seq", referencedColumnName = "question_seq")
    List<QuestionStoreEntity> questionStoreEntities = new ArrayList<>();


    @Override
    public String toString() {
        return "SurveyEntity{" +
                "surveySeq=" + surveySeq +
                ", userNm='" + userNm + '\'' +
                ", questionSeq=" + questionSeq +
                ", answerSeq=" + answerSeq +
                ", secretKey='" + secretKey + '\'' +
                ", questionStoreEntities=" + questionStoreEntities +
                '}';
    }
}
