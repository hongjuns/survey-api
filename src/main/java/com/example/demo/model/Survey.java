package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "TB_SURVEY")
@Getter
@Setter
public class Survey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SURVEY_SEQ")
    private Long seq;
    @Column(name = "SURVEY_TYPE")
    private String surveyTp;
    @Column(name = "SURVEY_TITLE")
    private String surveyTtl;
    @Column(name = "USE_YN")
    private String useYn;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "REG_DT")
    private Date regDt;
    @OneToMany(mappedBy = "survey")
    private List<Question> questions = new ArrayList<>();
}
