package com.example.demo.controller;

import com.example.demo.dto.AnswerDTO;
import com.example.demo.dto.QuestionDetailDTO;
import com.example.demo.dto.ResponseDTO;
import com.example.demo.dto.SurveyDTO;
import com.example.demo.model.AnswerEntity;
import com.example.demo.model.SurveyEntity;
import com.example.demo.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/survey")
public class SurveyController {

    @Autowired
    private SurveyService surveyService;

    @GetMapping("/selectQuestion")
    public ResponseEntity<?> selectQuestion (@RequestParam("key") String key) {

        SurveyEntity entity = new SurveyEntity();
        entity.setSecretKey(key);

        SurveyEntity surveyEntity = surveyService.selectQuestion(entity);
        List <QuestionDetailDTO> dtos = surveyEntity.getQuestionStoreEntities().stream().map(entityData -> new QuestionDetailDTO(entityData)).collect(Collectors.toList());
        ResponseDTO<QuestionDetailDTO> response = ResponseDTO.<QuestionDetailDTO>builder().data(dtos).build();

        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/inset")
    public ResponseEntity<?> insertAnswer (@RequestBody AnswerDTO dto) {

        AnswerEntity entity = AnswerDTO.toEntity(dto);
        AnswerEntity entities = surveyService.insertAnswer(entity);

        List<AnswerDTO> dtos = new ArrayList();
        dtos.add(new AnswerDTO(entities.getSecretKey(),entities.getAnswer(),"등록이 완료되었습니다."));
        ResponseDTO<AnswerDTO> response = ResponseDTO.<AnswerDTO>builder().data(dtos).build();

        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/insertSurvey")
    public ResponseEntity<?> insertSurvey (@RequestBody SurveyDTO dto) {

        SurveyEntity entity = SurveyDTO.toEntity(dto);
        SurveyEntity entities = surveyService.insertSurvey(entity);

        List<SurveyDTO> dtos = new ArrayList();
        dtos.add(new SurveyDTO(entities.getQuestionSeq(), entities.getSecretKey(), entities.getUserNm()));
        ResponseDTO<SurveyDTO> response = ResponseDTO.<SurveyDTO>builder().data(dtos).build();

        return ResponseEntity.ok().body(response);
    }

}
