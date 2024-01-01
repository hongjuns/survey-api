package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "TB_QUESTION")
@Getter
@Setter
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "QUESTION_SEQ")
    private Long seq;

    @ManyToOne
    @JoinColumn(name = "ITEM_SEQ")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "SURVEY_SEQ")
    private Survey survey;
}
