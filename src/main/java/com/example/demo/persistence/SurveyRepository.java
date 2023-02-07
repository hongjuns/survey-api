package com.example.demo.persistence;

import com.example.demo.model.QuestionDetailEntity;
import com.example.demo.model.SurveyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface SurveyRepository extends JpaRepository<SurveyEntity,Long> {
    SurveyEntity findBySecretkey (String secretkey);

    // 연관관계가 없는 엔티티 조인 처리 (ON 사용)
    @Query("SELECT r FROM SurveyEntity b LEFT JOIN QuestionDetailEntity r ON r.survey = b WHERE b.questionseq =:questionSeq ORDER BY r.seq asc" )
    List<QuestionDetailEntity> getSurveyByQuestionList(@Param("questionSeq") Long questionSeq);

}
