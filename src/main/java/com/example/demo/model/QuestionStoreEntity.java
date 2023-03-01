package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="TB_QUESTION_STORE")
public class QuestionStoreEntity  {

    @Id
    @Column(name="seq")
    private Long seq;
    @Column(name="type")
    private String type;

    @Column(name="question")
    private String question;

    @Column(name="title")
    private String title;

    @Column(name="question_id")
    private String questionId;

    @Column(name="question_value")
    private String questionValue;

}
