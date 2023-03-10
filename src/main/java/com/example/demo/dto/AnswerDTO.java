package com.example.demo.dto;

import com.example.demo.model.AnswerEntity;
import com.example.demo.model.SurveyEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AnswerDTO {
    private String key;
    private String answerInfo;
    private String msg;

    public static AnswerEntity toEntity(AnswerDTO dto){
        return AnswerEntity.builder()
                .secretKey(dto.getKey())
                .answer(dto.getAnswerInfo())
                .build();
    }

}
