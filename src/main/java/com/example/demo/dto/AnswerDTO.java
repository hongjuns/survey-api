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
    @Override
    public String toString() {
        return "AnswerDTO{" +
                "key='" + key + '\'' +
                ", answerInfo='" + answerInfo + '\'' +
                '}';
    }

    public static AnswerEntity toEntity(AnswerDTO dto){
        return AnswerEntity.builder()
                .secretkey(dto.getKey())
                .answer(dto.getAnswerInfo())
                .build();
    }

}
