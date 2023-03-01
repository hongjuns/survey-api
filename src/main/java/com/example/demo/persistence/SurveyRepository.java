package com.example.demo.persistence;

import com.example.demo.model.SurveyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SurveyRepository extends JpaRepository<SurveyEntity,Long> {
    SurveyEntity findBySecretKey (String secretKey);
    
    @Modifying(clearAutomatically = true)
    @Query("UPDATE SurveyEntity p SET p.answerSeq = :answerSeq WHERE p.surveySeq = :surveySeq")
    int updateAnswer(@Param("answerSeq") Long answerSeq,
                     @Param("surveySeq") Long surveySeq);

}

