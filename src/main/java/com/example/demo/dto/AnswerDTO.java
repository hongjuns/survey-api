package com.example.demo.dto;

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
    @Override
    public String toString() {
        return "AnswerDTO{" +
                "key='" + key + '\'' +
                ", answerInfo='" + answerInfo + '\'' +
                '}';
    }
}
