package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "TB_QUESTION_ITEM")
@Getter
@Setter
public class Item {
    @Id @GeneratedValue
    @Column(name = "ITEM_SEQ")
    private Long id;
    @Column(name = "TYPE")
    private String itemTp;
    @Column(name = "TITLE")
    private String itemTtl;
    @Column(name = "QUESTION")
    private String question;
    @Column(name = "USE_YN")
    private String useYn;
}
