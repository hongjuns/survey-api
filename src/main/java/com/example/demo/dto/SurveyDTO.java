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

    private Long questionSeq;
    private String key;
    private String userNm;
    private String regDt;

    public static SurveyEntity toEntity(SurveyDTO dto){
        return SurveyEntity.builder()
                .userNm(dto.getUserNm())
                .questionSeq(dto.getQuestionSeq())
                .build();
    }


}
