package com.example.demo.service;

import com.example.demo.model.QuestionDetailEntity;
import com.example.demo.model.SurveyEntity;
import com.example.demo.persistence.SurveyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class SurveyServiceImpl implements SurveyService {
    private final SurveyRepository surveyRepository;

    public SurveyServiceImpl(SurveyRepository surveyRepository) {
        this.surveyRepository = surveyRepository;
    }

    @Override
    public List<QuestionDetailEntity> selectQuestion(SurveyEntity entity) {
        //Validations
        validata(entity);
        Optional<SurveyEntity> original = Optional.ofNullable(surveyRepository.findBySecretkey(entity.getSecretkey()));
        if(original.isPresent()){
            SurveyEntity data = original.get();
            return surveyRepository.getSurveyByQuestionList(data.getQuestionseq());
        }else {
            throw new RuntimeException("No question type.");
        }
    }

    private void validata(SurveyEntity entity){
        if (entity.getSecretkey() == null){
            log.warn("Unknown Key.");
            throw new RuntimeException("Unknown Key.");
        }
    }

}
