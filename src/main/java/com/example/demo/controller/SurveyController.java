package com.example.demo.controller;

import com.example.demo.dto.AnswerDTO;
import com.example.demo.dto.ResponseDTO;
import com.example.demo.dto.SurveyDTO;
import com.example.demo.model.AnswerEntity;
import com.example.demo.model.QuestionDetailEntity;
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
        SurveyDTO surveyDTO = new SurveyDTO();
        surveyDTO.setKey(key);
        SurveyEntity entity = SurveyDTO.toEntity(surveyDTO);
        List<QuestionDetailEntity> entities = surveyService.selectQuestion(entity);
        List<SurveyDTO> dtos = entities.stream().map(entityData -> new SurveyDTO(key,entityData.getSeq(),entityData.getType(), entityData.getQuestion(),entityData.getTitle(),entityData.getQuestionid(),entityData.getQuestionvalue()))
                .collect(Collectors.toList());
        ResponseDTO<SurveyDTO> response = ResponseDTO.<SurveyDTO>builder().data(dtos).build();
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/inset")
    public ResponseEntity<?> insertAnswer (@RequestBody AnswerDTO dto) {
        AnswerEntity entity = AnswerDTO.toEntity(dto);
        AnswerEntity entities = surveyService.insertAnswer(entity);
        List<AnswerDTO> dtos = new ArrayList();
        dtos.add(new AnswerDTO(entities.getSecretkey(),entities.getAnswer(),"등록이 완료되었습니다."));
        ResponseDTO<AnswerDTO> response = ResponseDTO.<AnswerDTO>builder().data(dtos).build();
        return ResponseEntity.ok().body(response);
    }


}
