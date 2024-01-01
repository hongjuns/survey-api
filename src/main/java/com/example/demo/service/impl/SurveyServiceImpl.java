package com.example.demo.service.impl;
import com.example.demo.dto.ItemDTO;
import com.example.demo.dto.SurveyDTO;
import com.example.demo.model.Answer;
import com.example.demo.model.Question;
import com.example.demo.model.Survey;
import com.example.demo.persistence.AnswerRepository;
import com.example.demo.persistence.SurveyRepository;
import com.example.demo.service.SurveyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class SurveyServiceImpl implements SurveyService {

    @Autowired
    private SurveyRepository surveyRepository;
    @Autowired
    private AnswerRepository answerRepository;

    @Override
    public Survey findOne(int id) {
        return surveyRepository.findById(Long.valueOf(id)).orElse(null);
    }
    @Override
    public SurveyDTO findSurveyItem(Survey survey) {
        SurveyDTO surveyDTO = new SurveyDTO();

        surveyDTO.setId(survey.getSeq().intValue());        //설문지 SEQ
        surveyDTO.setSurveyTtl(survey.getSurveyTtl());      //설문지 이름
        List<Question> qlist = survey.getQuestions();

        List<ItemDTO> itemist =  qlist.stream().map(entityData -> ItemDTO.builder()
                .itemId(entityData.getItem().getId().intValue())    //설문지 아이템 SEQ
                .type(entityData.getItem().getItemTp())             //설문지 아이템 타입
                .itemTitle(entityData.getItem().getItemTtl())       //설문지 아이템 이름
                .question(entityData.getItem().getQuestion()).build()).collect(Collectors.toList());    //설문지 내용

        surveyDTO.setItemDTOList(itemist);

        return surveyDTO;
    }

    @Override
    public void saveAnswer(List<Answer> answers) {
        for (Answer item : answers){
            answerRepository.save(item);
        }
    }
}
