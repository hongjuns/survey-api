package com.example.demo.service;

import com.example.demo.model.QuestionDetailEntity;
import com.example.demo.model.SurveyEntity;

import java.util.List;

public interface SurveyService {
    List<QuestionDetailEntity> selectQuestion(SurveyEntity surveyEntity);
}
