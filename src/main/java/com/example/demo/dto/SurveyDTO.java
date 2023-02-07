package com.example.demo.dto;
import com.example.demo.model.SurveyEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SurveyDTO {

    private String key;
    private Long questionSeq;
    private String type;
    private String question;
    private String title;
    private String questionId;
    private String questionValue;


    public static SurveyEntity toEntity(SurveyDTO dto){
        return SurveyEntity.builder()
                .secretkey(dto.getKey())
                .questionseq(dto.getQuestionSeq())
                .build();
    }

}
