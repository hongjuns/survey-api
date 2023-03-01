package com.example.demo.service;

import com.example.demo.model.AnswerEntity;
import com.example.demo.model.SurveyEntity;

public interface SurveyService {
    SurveyEntity selectQuestion(SurveyEntity surveyEntity);
    AnswerEntity insertAnswer(AnswerEntity answerEntity);
    SurveyEntity insertSurvey (SurveyEntity surveyEntity);
}
