package com.example.demo;

import com.example.demo.service.SurveyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EntityConnectionTest {
    @Autowired
    SurveyService surveyService;
    @Test
    void contextLoads() {
        SurveyDTO one = new SurveyDTO();
        one.setKey("123");
        one.setQuestionSeq(Long.valueOf(1));

        SurveyEntity entity = one.toEntity(one);
        System.out.println("entity" + entity);
        surveyService.selectQuestion(entity);
    }
}
