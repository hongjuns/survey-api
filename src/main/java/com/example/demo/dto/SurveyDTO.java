package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class SurveyDTO {

    private int id;
    private String surveyTtl;

    private List<ItemDTO> itemDTOList;

    private List<AnswerDTO> answerDTOList;
}
