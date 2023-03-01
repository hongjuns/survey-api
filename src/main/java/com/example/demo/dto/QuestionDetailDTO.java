package com.example.demo.dto;
import com.example.demo.model.QuestionStoreEntity;
import com.example.demo.model.SurveyEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class QuestionDetailDTO {

    private String key;
    private Long questionSeq;
    private String type;
    private String question;
    private String title;
    private String questionId;
    private String questionValue;

    public QuestionDetailDTO (final QuestionStoreEntity entity){
        this.type=entity.getType();
        this.question=entity.getQuestion();
        this.title=entity.getTitle();
        this.questionId=entity.getQuestionId();
        this.questionValue=entity.getQuestionValue();
    }

    @Override
    public String toString() {
        return "QuestionDetailDTO{" +
                "key='" + key + '\'' +
                ", questionSeq=" + questionSeq +
                ", type='" + type + '\'' +
                ", question='" + question + '\'' +
                ", title='" + title + '\'' +
                ", questionId='" + questionId + '\'' +
                ", questionValue='" + questionValue + '\'' +
                '}';
    }
}
