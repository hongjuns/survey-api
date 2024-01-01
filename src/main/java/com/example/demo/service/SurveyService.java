package com.example.demo.service;
import com.example.demo.dto.SurveyDTO;
import com.example.demo.model.Answer;
import com.example.demo.model.Survey;
import java.util.*;


public interface SurveyService {
    Survey findOne (int id);
    SurveyDTO findSurveyItem (Survey survey);
    void saveAnswer (List<Answer> answers);
}
