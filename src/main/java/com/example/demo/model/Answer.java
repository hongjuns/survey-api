package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "TB_ANSWER")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Answer {

    @Id @GeneratedValue
    @Column(name = "ANSWER_SEQ")
    private Long id;
    @Column(name = "MEMBER_ID")
    private String memberId;
    @Column(name = "ANSWER")
    private String answer;
    @OneToOne
    @JoinColumn(name = "QUESTION_SEQ")
    private Question question;


}
