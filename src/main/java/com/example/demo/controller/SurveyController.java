package com.example.demo.controller;

import com.example.demo.dto.AnswerDTO;
import com.example.demo.dto.ResponseDTO;
import com.example.demo.dto.SurveyDTO;
import com.example.demo.model.QuestionDetailEntity;
import com.example.demo.model.SurveyEntity;
import com.example.demo.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/survey")
public class SurveyController {

    @Autowired
    private SurveyService surveyService;

    @GetMapping("/select")
    public ResponseEntity<?> selectQuestion (@RequestBody SurveyDTO dto) {
        SurveyEntity entity = SurveyDTO.toEntity(dto);
        List<QuestionDetailEntity> entities = surveyService.selectQuestion(entity);
        List<SurveyDTO> dtos = entities.stream().map(entityData -> new SurveyDTO(dto.getKey(),dto.getQuestionSeq(),entityData.getType(), entityData.getQuestion())).collect(Collectors.toList());
        ResponseDTO<SurveyDTO> response = ResponseDTO.<SurveyDTO>builder().data(dtos).build();
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/inset")
    public ResponseEntity<?> insertAnswer (AnswerDTO dto) {
        System.out.println("dto" + dto.toString());
        return null;
    }


}
