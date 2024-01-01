package com.example.demo.dto;


import com.example.demo.model.Answer;
import com.example.demo.model.Question;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AnswerDTO {

    private int id;
    private String userId;
    private  String answer;

    public static Answer toEntity(AnswerDTO dto){
        Question question = new Question();
        question.setSeq(Long.valueOf(dto.getId()));
        return Answer.builder()
                .answer(dto.answer)
                .memberId(dto.userId)
                .question(question)
                .build();
    }
}
